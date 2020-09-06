package cn.hctech2006.hotellist.service.impl;

import cn.hctech2006.hotellist.bean.NlHandler;
import cn.hctech2006.hotellist.bean.NlOrder;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.mapper.NlOrderMapper;
import cn.hctech2006.hotellist.vo.OrderHandlerVo;
import cn.hctech2006.hotellist.vo.OrderListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl {
    @Autowired
    private NlOrderMapper orderMapper;
    @Autowired
    private HandlerServiceImpl handlerService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddd hh:mm:ss");
    /**
     * 订单上传接口
     * @param params
     * @return
     */
    public ServerResponse uploadOrder(NlOrder params, String userName){
        //todo 订单编号是否存在
        String orderReference = params.getOrderReference();
        System.out.println("orderReference: "+orderReference);

        String hotelName = params.getHotelName();
        if (orderReference == null || orderReference.equals("") ) return ServerResponse.createByError("订单编号不存在请重新输入");
        if (hotelName == null || hotelName.equals("") ) return ServerResponse.createByError("酒店名称不存在请重新输入");
        //todo 该订单是否已经存在
        NlOrder nlOrder = orderMapper.selectByOrderReference(params.getOrderReference());
        if (nlOrder != null) {
            return update_order(nlOrder);

        }
        //todo 设置毛利等于卖价-底价
        if (params.getFloorPrice() != null && params.getSellingPrice() != null) params.setGrossMargin(params.getSellingPrice()-params.getFloorPrice());
        params.setOrderId(UUID.randomUUID().toString());
        params.setHandler(userName);
        params.setHandlerTime(new Date());
        params.setDelFlag("1");
        int result = orderMapper.insert(params);
        if (result > 0) {
            String handlerContent =  params.getHandler()+"在"+sdf.format(new Date())+", 新增一条订单记录";
            params.setHandlerContent(handlerContent);
            ServerResponse response = handlerService.uploadHandler(params.getOrderId(), params.getHandler(), params.getHandlerContent());

            if (!response.isSuccess()) return ServerResponse.createByError();

            return ServerResponse.createBySuccess("订单导入成功");
        }
        return ServerResponse.createByError("订单导入失败");
    }

    /**
     * 查看具体某一个订单接口
     * @param orderId
     * @return
     */
    public ServerResponse oneOrder(String orderId){
        if (orderId == null || orderId.equals("")) return ServerResponse.createByError("订单编号不能为空");
        NlOrder order = orderMapper.selectByOrderId(orderId);
        List<NlHandler> handlers = (List<NlHandler>) handlerService.listHandler(orderId).getData();

        if (order.getOrderId() == null || order.getOrderId().equals("")) return ServerResponse.createByError("该订单不存在或者已经被删除");
        OrderHandlerVo orderHandlerVo = new OrderHandlerVo();
        orderHandlerVo.setHandlers(handlers);
        orderHandlerVo.setOrder(order);
        return ServerResponse.createBySuccess(orderHandlerVo);
    }

    /**
     * 分页分关键词查看
     * @param pageNum
     * @param pageSize
     * @param hotelName
     * @param checkInPerson
     * @param orderReference
     * @param orderStatus
     * @param channel
     * @param operation
     * @param proprietaryHotel
     * @return
     */
    public ServerResponse listOrder(int pageNum, int pageSize, String hotelName, String checkInPerson, String orderReference, String orderStatus, String channel, String operation, String proprietaryHotel,
                                    String  dateFlag, Date startDate, Date endDate, String newFlag, String delFlag){
        int newOrderNum = orderMapper.selectNewOrderCount();
        int newCheckInNum = orderMapper.selectNewCheckInCount();
        int targetOrderNum = orderMapper.selectTargetOrderCount();
        System.out.println("newCheckInNum: "+ newCheckInNum);
        System.out.println("newOrderNum: "+newOrderNum);
        System.out.println("targetOrderNum: "+targetOrderNum);
        PageHelper.startPage(pageNum, pageSize);
        List<NlOrder> orders = orderMapper.selectByKeyword(hotelName, checkInPerson, orderReference, orderStatus, channel, operation, proprietaryHotel, dateFlag, startDate, endDate, newFlag, delFlag);
        PageInfo result = new PageInfo(orders);
        OrderListVo orderListVo = new OrderListVo(orders,newOrderNum, newCheckInNum, targetOrderNum);
        result.setList(Lists.newArrayList(orderListVo));
        return ServerResponse.createBySuccess(result);
    }


    /**
     * 订单修改
     * @param params
     */
    public ServerResponse update_order(NlOrder params) {
        //TODO 判断删除标志是否不合法
        System.out.println("delFlag: " + params.getDelFlag());
        if (params.getDelFlag() != null && !params.getDelFlag().equals("1") && !params.getDelFlag().equals("0"))
            return ServerResponse.createByError("删除标志只能是0或者1");
        //todo 判断唯一标示是否为空
        String orderId = params.getOrderId();
        if (orderId == null || orderId == "") return ServerResponse.createByError("订单唯一标识不能为空");
        NlOrder order = orderMapper.selectByOrderId(orderId);
        //todo 判断订单是否存在
        if (order == null) return ServerResponse.createByError("订单不存在请重新确认订单编号");
        //todo 判断订单底价是否修改, 如果修改,则继续判断卖价是否修改
        if (params.getFloorPrice() != null) {
            if (params.getSellingPrice() != null)
                params.setGrossMargin(params.getSellingPrice() - params.getFloorPrice());
            else params.setGrossMargin(order.getSellingPrice() - params.getFloorPrice());
        }
        //todo 修改结果
        int result = orderMapper.updateByOrderId(params);
        if (result > 0) {
            String handlerContent = params.getHandler() + "在" + sdf.format(new Date()) + ",修改了这条记录";
            if (params.getOperation() != null) {
                if (order.getOperation() == null) {

                } else if (!order.getOperation().equals(params.getOperation())) {
                    handlerContent += ",修改了运营人员";
                }


            }
            if (params.getSalesManager() != null) {
                if (order.getSalesManager() == null) {
                    handlerContent += ", 修改了销售经理";
                } else if (order.getSalesManager().equals(params.getSalesManager())) {
                    handlerContent += ", 修改了销售经理";
                }
            }
            if (params.getOrderStatus() != null) {
                if (order.getOrderStatus() == null) {
                    handlerContent += ",修改了订单状态";
                } else if (order.getOrderStatus().equals(params.getOrderStatus())) {
                    handlerContent += ",修改了订单状态";
                }

            }
            if (params.getGrossMargin() != null) {
                if (order.getGrossMargin() == null) {
                    handlerContent += ", 修改了毛利";
                } else if (order.getGrossMargin().equals(params.getGrossMargin())) {
                    handlerContent += ", 修改了毛利";
                }

            }
            if (params.getSellingPrice() != null) {
                if (order.getSellingPrice() == null) {
                    handlerContent += ",修改了总金额";
                } else if (!order.getSellingPrice().equals(params.getSellingPrice())) {
                    handlerContent += ",修改了总金额";
                }

            }
            if (params.getFloorPrice() != null) {
                if (order.getFloorPrice() == null) {
                    handlerContent += ", 修改了底价";
                } else if (!order.getFloorPrice().equals(params.getFloorPrice())) {
                    handlerContent += ", 修改了底价";
                }

            }
            if (params.getCheckInPerson() != null) {
                if (order.getCheckInPerson() == null) {
                    handlerContent += ",修改了入住者";
                } else if (!order.getCheckInPerson().equals(params.getCheckInPerson())) {
                    handlerContent += ",修改了入住者";
                }

            }
            if (params.getCheckOutDate() != null) {
                if (order.getCheckOutDate() == null) {
                    handlerContent += ", 修改了退房时间";
                } else if (!order.getCheckOutDate().equals(params.getCheckOutDate())) {
                    handlerContent += ", 修改了退房时间";
                }

            }
            if (params.getCheckInDate() != null) {
                if (order.getCheckInDate() == null){
                    handlerContent += ",修改了入住时间";
                }else if(!order.getCheckInDate().equals(params.getCheckInDate())){
                    handlerContent += ",修改了入住时间";
                }
            }
            if (params.getChannel() != null ) {
                if (order.getChannel() == null) {
                    handlerContent += ", 修改了渠道";
                } else if (!order.getCheckInDate().equals(params.getCheckInDate())) {
                    handlerContent += ", 修改了渠道";
                }
                }
                if (params.getTargetDate() != null) {
                    if (order.getTargetDate() == null) {
                        handlerContent += ",修改了预订日期";
                    } else if (!order.getTargetDate().equals(params.getTargetDate())) {
                        handlerContent += ",修改了预订日期";
                    }

                }
                if (params.getHotelName() != null) {
                    if (order.getHotelName() == null) {
                        handlerContent += ", 修改了酒店名";
                    } else if (!order.getHotelName().equals(params.getHotelName())) {
                        handlerContent += ", 修改了酒店名";
                    }

                }
                if (params.getOrderReference() != null) {
                    if (order.getOrderReference() == null) {
                        handlerContent += ", 修改了导入订单编号";
                    } else if (!order.getOrderReference().equals(params.getOrderReference())) {
                        handlerContent += ", 修改了导入订单编号";
                    }

                }
                if (params.getHouseType() != null) {
                    if (order.getHouseType() == null) {
                        handlerContent += ", 修改了房型";
                    } else if (!order.getHouseType().equals(params.getHouseType())) {
                        handlerContent += ", 修改了房型";
                    }

                }
                if (params.getInvoiceTitle() != null) {
                    if (order.getInvoiceTitle() == null) {
                        handlerContent += ", 修改了发票抬头";
                    } else if (!order.getInvoiceTitle().equals(params.getInvoiceTitle())) {
                        handlerContent += ", 修改了发票抬头";
                    }
                }
                if (params.getDutyParagraph() != null) {
                    if (order.getDutyParagraph() == null) {
                        handlerContent += ", 修改了税号";
                    } else if (!order.getDutyParagraph().equals(params.getDutyParagraph())) {
                        handlerContent += ", 修改了税号";
                    }

                }
                if (params.getDelFlag() != null) {
                    if (order.getDelFlag() == null) {
                        handlerContent += ", 修改了删除标志";
                    } else if (!order.getDelFlag().equals(params.getDelFlag())) {
                        handlerContent += ", 修改了删除标志";
                    }
                }
                params.setHandlerContent(handlerContent);
                ServerResponse response = handlerService.uploadHandler(params.getOrderId(), params.getHandler(), params.getHandlerContent());
                return ServerResponse.createBySuccess("修改成功");

            } else return ServerResponse.createByError("修改失败");

    }
    public ServerResponse deleteListOrder(List<String> orderIds, String userName){
        for (String orderId: orderIds){
            NlOrder order = new NlOrder();
            order.setOrderId(orderId);
            order.setDelFlag("0");
            int result = orderMapper.updateByOrderId(order);
            if (result < 0) return ServerResponse.createByError("删除失败,请重新删除");
            String handlerContent = userName+"在"+sdf.format(new Date())+",删除了这条记录";
            NlHandler params = new NlHandler();
            params.setHandler(userName);
            params.setOrderId(orderId);
            params.setHandlerContent(handlerContent);
            ServerResponse response = handlerService.uploadHandler(params.getOrderId(), params.getHandler(), params.getHandlerContent());
        }

        return ServerResponse.createBySuccess("删除成功");
    }

    /**
     * EXCEL导出接口
     * @param request
     * @param response
     * @throws Exception
     */

    public void excelExport(HttpServletRequest request, HttpServletResponse response,
                            String pageNum, String pageSize, String hotelName, String checkInPerson, String orderReference,
                            String orderStatus, String channel, String operation, String proprietaryHotel,
                            String  dateFlag, Date startDate, Date endDate, String newFlag, String excelFlag, String delFlag) {
        List<NlOrder> list = null;
        if (excelFlag == "0" || excelFlag.equals("0")){
            PageHelper.startPage(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
            List<NlOrder> orders  = orderMapper.selectByKeyword(hotelName, checkInPerson, orderReference, orderStatus, channel, operation, proprietaryHotel, dateFlag, startDate, endDate, newFlag, delFlag);
            PageInfo result = new PageInfo(orders);
             list = result.getList();
        }else{
            list  = orderMapper.selectByKeyword(hotelName, checkInPerson, orderReference, orderStatus, channel, operation, proprietaryHotel, dateFlag, startDate, endDate, newFlag, delFlag);
        }

        //开始模拟获取数据，实际应该在数据库查出来
        //EXCEL表导出核心代码
        //声明一个Excel
        HSSFWorkbook wb =null;
        //title代表的是你的excel表开头每列的名字
        String[] title =new String[]{"订单","酒店名称","预定日期","渠道","入住日期","离店日期","入住姓名","底价", "卖价", "毛利", "订单状态", "销售经理", "运营", "操作"};
        String name="测试";
        //excel文件名
        String fileName = name+".xls";
        //sheet名
        String sheetName = name+"表";
        //二维数组铺满整个Excel
        String[][] content = new String[list.size()][title.length];
        //--------------------------------------------------------------------------------------------
        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();

        //设置背景色
        //style.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
        //style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //设置边框

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置居右
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居右
        style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        //设置字体
        HSSFFont font=wb.createFont();
        //font.setFontName("黑体");
        //font.setFontHeightInPoints((short) 16);//设置字体大小
        HSSFFont font2=wb.createFont();
        font2.setFontName("仿宋_GB2312");
        //font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        font2.setFontHeightInPoints((short) 12);

        style.setFont(font);//选择需要用到的字体格式

        //设置列宽
        sheet.setColumnWidth(0, 1500);//第一个参数代表列id（从0开始），第二个参数代表宽度值
        sheet.setColumnWidth(1, 1500);//第一个参数代表列id（从1开始），第二个参数代表宽度值
        sheet.setColumnWidth(2, 1500);//第一个参数代表列id（从2开始），第二个参数代表宽度值
        sheet.setColumnWidth(3, 1500);//第一个参数代表列id（从3开始），第二个参数代表宽度值
        sheet.setColumnWidth(4, 2200);//第一个参数代表列id（从4开始），第二个参数代表宽度值
        style.setWrapText(true);//设置自动换行

        //加边框
        HSSFCellStyle cellStyle=wb.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }





        //把list放进content里
        //String[] title =new String[]{"订单","酒店名称","预定日期","渠道","入住日期","离店日期","入住姓名","底价", "卖价", "毛利", "订单状态", "销售经理", "运营", "操作"};
        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            NlOrder obj = list.get(i);
            content[i][0] = obj.getOrderReference()+"";
            content[i][1] = obj.getHotelName()+"";
            content[i][2] = obj.getTargetDate()+"";
            content[i][3] = obj.getChannel()+"";
            content[i][4] = obj.getCheckInDate()+"";
            content[i][5] = obj.getCheckOutDate()+"";
            content[i][6] = obj.getCheckInPerson()+"";
            content[i][7] = obj.getFloorPrice()+"";
            content[i][8] = obj.getSellingPrice()+"";
            content[i][9] = obj.getGrossMargin()+"";
            content[i][10] = obj.getOrderStatus()+"";
            content[i][11] = obj.getSalesManager()+"";
            content[i][12] = obj.getOperation()+"";


        }
        //添加数据进入excel

        for(int i=0;i<content.length;i++){

            row = sheet.createRow(i + 1);

            for(int j=0;j<content[i].length;j++){

                //将内容按顺序赋给对应的列对象
                HSSFCell cel = row.createCell(j);
                cel.setCellValue(content[i][j]);

            } }


        //响应到客户端
        try {
            try {
                try {
                    fileName = new String(fileName.getBytes(),"ISO8859-1");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
