package cn.hctech2006.hotellist.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.hctech2006.hotellist.bean.NlOrder;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.util.DateTimeUtil;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImportExcelServiceImpl extends ImportExcelBaseService {
        @Autowired
        OrderServiceImpl orderService;

    /**
     * 代理通导入接口
     * @param file
     * @param req
     * @param resp
     * @param userName
     * @return
     */
    public List importExcelWithSimple(MultipartFile file,HttpServletRequest req,HttpServletResponse resp, String userName) {
        int rowNum = 0;//已取值的行数
        int colNum = 0;//列号
        int realRowCount = 0;//真正有数据的行数

        //得到工作空间
        Workbook workbook = null;
        try {
            workbook = super.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //得到工作表
        Sheet sheet = super.getSheetByWorkbook(workbook, 0);
        if (sheet.getRow(2000) != null){
            throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
        }

        realRowCount = sheet.getPhysicalNumberOfRows();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<NlOrder> list = new ArrayList<>();


        for(Row row:sheet) {

            if(realRowCount == rowNum) {
                break;
            }

            if(super.isBlankRow(row)) {//空行跳过
                continue;
            }

            if(row.getRowNum() == -1) {
                continue;
            }else {
                if(row.getRowNum() == 0) {//第一行表头跳过
                    continue;
                }
            }

            rowNum ++;

            NlOrder order = new NlOrder();
            order.setOrderId(UUID.randomUUID().toString());
            String orderReference = super.getCellValue(sheet, row, 0);
            System.out.println("渠道订单号: "+"代理通");
            order.setOrderReference("代理通");

            String hotelName = super.getCellValue(sheet, row, 1);
            System.out.println("酒店: "+hotelName);
            order.setHotelName(hotelName);

            String channel = super.getCellValue(sheet, row, 21);
            System.out.println("分销方-渠道: "+"代理通");
            order.setChannel(channel);

            String checkInDateStr = super.getCellValue(sheet, row, 6);
            System.out.println("checkInDateStr: "+checkInDateStr);
            Date checkInDate= HSSFDateUtil.getJavaDate(Double.valueOf(Integer.parseInt(checkInDateStr)));
            System.out.println("入住日期: "+checkInDate.getTime());
            order.setCheckInDate(checkInDate);
            String checkOutDateStr = super.getCellValue(sheet, row, 7);
            Date checkOutDate = HSSFDateUtil.getJavaDate(Double.parseDouble(checkOutDateStr));
            System.out.println("离店日期: "+checkOutDate);
            order.setCheckOutDate(checkOutDate);

            //todo 间夜数
            int numbersRoom = Integer.parseInt(super.getCellValue(sheet, row, 8));
            System.out.println("房间数: "+ numbersRoom);
            order.setNumbersRoom(numbersRoom);
            int numbersNight = Integer.parseInt(super.getCellValue(sheet, row, 9));
            System.out.println("夜晚数: "+ numbersNight);
            order.setNumbersNight(numbersNight);
            String checkInPerson = super.getCellValue(sheet, row, 10);
            System.out.println("入住人: "+ checkInPerson);
            order.setCheckInPerson(checkInPerson);
            //colNum++;
            String houseType = super.getCellValue(sheet, row, 4);
            System.out.println("房型: "+ houseType);
            order.setHouseType(houseType);
            //colNum++;
            list.add(order);
        }
        for (NlOrder nlOrder : list){
            ServerResponse response = orderService.uploadOrder(nlOrder, userName);
            if (!response.isSuccess()) return null;

        }
        return list;

    }

    /**
     * 飞猪导入接口
     * @param file
     * @param req
     * @param resp
     * @param userName
     * @return
     */
    public List importFliggyOrder(MultipartFile file,HttpServletRequest req,HttpServletResponse resp, String userName) {
        int rowNum = 0;//已取值的行数
        int colNum = 0;//列号
        int realRowCount = 0;//真正有数据的行数

        //得到工作空间
        Workbook workbook = null;
        try {
            workbook = super.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //得到工作表
        Sheet sheet = super.getSheetByWorkbook(workbook, 0);
        if (sheet.getRow(2000) != null){
            throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
        }

        realRowCount = sheet.getPhysicalNumberOfRows();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<NlOrder> list = new ArrayList<>();
        //UserConsumeDetailRecord UserConsumeDetailRecord = null;

        for(Row row:sheet) {

            if(realRowCount == rowNum) {
                break;
            }

            if(super.isBlankRow(row)) {//空行跳过
                continue;
            }

            if(row.getRowNum() == -1) {
                continue;
            }else {
                if(row.getRowNum() == 0 || row.getRowNum() == 1 || row.getRowNum() == 2) {//第一行表头跳过
                    continue;
                }
            }

            rowNum ++;

            NlOrder order = new NlOrder();
            order.setOrderId(UUID.randomUUID().toString());
            String orderReference = super.getCellValue(sheet, row, 0);
            System.out.println("渠道订单号: "+orderReference);
            order.setOrderReference(orderReference);

            String hotelName = super.getCellValue(sheet, row, 5);
            System.out.println("酒店: "+hotelName);
            order.setHotelName(hotelName);

            String targetTimeStr  = super.getCellValue(sheet, row, 2).replaceAll("/", "-");

            System.out.println("targetTimeStr: "+targetTimeStr);

            String targetYear = targetTimeStr.substring(0, targetTimeStr.indexOf("-"));

            Date setupTime = DateTimeUtil.strToDate(targetTimeStr);

            order.setTargetDate(setupTime);

            String channel = super.getCellValue(sheet, row, 21);
            System.out.println("分销方-渠道: "+"飞猪");
            order.setChannel("飞猪");

            String checkInDateStr = super.getCellValue(sheet, row, 9);
            Date checkInDate = null;
            if (checkInDateStr != null && !checkInDateStr.equals("")){
                checkInDateStr =targetYear +"-" +super.getCellValue(sheet, row, 9) +" 00:00:00";
                System.out.println("checkInDateStr: "+checkInDateStr);
                checkInDate = DateTimeUtil.strToDate(checkInDateStr);
                order.setCheckInDate(checkInDate);
                System.out.println("入住日期: "+checkInDate.getTime());
            }

            String checkOutDateStr = super.getCellValue(sheet, row, 10);
            Date checkOutDate = null;
            if (checkOutDateStr != null && !checkOutDateStr.equals("")){
                checkOutDateStr =targetYear +"-" +super.getCellValue(sheet, row, 10) +" 00:00:00";
                System.out.println("checkInDateStr: "+checkOutDateStr);
                checkOutDate= DateTimeUtil.strToDate(checkOutDateStr);
                order.setCheckOutDate(checkOutDate);
                System.out.println("退房日期: "+checkOutDate.getTime());
            }


            String checkInPerson = super.getCellValue(sheet, row, 15);
            System.out.println("入住人: "+ checkInPerson);
            order.setCheckInPerson(checkInPerson);
            //colNum++;
            String houseType = super.getCellValue(sheet, row, 7);
            System.out.println("房型: "+ houseType);
            order.setHouseType(houseType);



            order.setNumbersRoom(1);
            int numbersNight =Integer.parseInt(super.getCellValue(sheet, row, 8));
            System.out.println("入住夜晚数: "+numbersNight);
            order.setNumbersRoom(numbersNight);

            String orderStaus = super.getCellValue(sheet, row, 17);

            System.out.println("订单状态: "+orderStaus);
            order.setOrderStatus(orderStaus);

            String invoiceTitle = super.getCellValue(sheet, row, 27);
            System.out.println("抬头: "+ invoiceTitle);
            order.setInvoiceTitle(invoiceTitle);

            String dutyParagraph = super.getCellValue(sheet, row, 28);
            System.out.println("税号: "+ dutyParagraph);
            order.setDutyParagraph(dutyParagraph);

            list.add(order);
        }
        for (NlOrder nlOrder : list){
            ServerResponse response = orderService.uploadOrder(nlOrder, userName);
            if (!response.isSuccess()) return null;
        }
        return list;

    }

    /**
     * 青芒果录入接口
     * @param file
     * @param req
     * @param resp
     * @param userName
     * @return
     */
    public List importExcelWithGreenMangoes(MultipartFile file,HttpServletRequest req,HttpServletResponse resp, String userName) {
        int rowNum = 0;//已取值的行数
        int colNum = 0;//列号
        int realRowCount = 0;//真正有数据的行数

        //得到工作空间
        Workbook workbook = null;
        try {
            workbook = super.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到工作表
        Sheet sheet = super.getSheetByWorkbook(workbook, 0);
        if (sheet.getRow(2000) != null){
            throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
        }
        realRowCount = sheet.getPhysicalNumberOfRows();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<NlOrder> list = new ArrayList<>();

        int lastRowNum = sheet.getLastRowNum();

        for(int i = 1; i < lastRowNum-1; i +=2) {
            Row row = sheet.getRow(i);
            Row nextRow = sheet.getRow(i+1);
            if(realRowCount == rowNum) {
                break;
            }
            if(super.isBlankRow(row)) {//空行跳过
                continue;
            }
            if(row.getRowNum() == -1) {
                continue;
            }else {
                if(row.getRowNum() == 0) {//第一行表头跳过
                    continue;
                }
            }
            rowNum ++;
            NlOrder order = new NlOrder();
            order.setOrderId(UUID.randomUUID().toString());
            String orderReference = super.getCellValue(sheet, row, 0);
            System.out.println("渠道订单号: "+orderReference);
            order.setOrderReference(orderReference);

            String hotelName = super.getCellValue(sheet, row, 1);
            System.out.println("酒店: "+hotelName);
            order.setHotelName(hotelName);

            String channel = super.getCellValue(sheet, row, 21);
            System.out.println("分销方-渠道: "+"青芒果");
            order.setChannel("青芒果");

            String checkInDateStr = super.getCellValue(sheet, row, 2);
            System.out.println("checkInDateStr: "+checkInDateStr);
            Date checkInDate= HSSFDateUtil.getJavaDate(Double.valueOf(Integer.parseInt(checkInDateStr)));
            System.out.println("入住日期: "+checkInDate.getTime());
            order.setCheckInDate(checkInDate);

            String checkOutDateStr = super.getCellValue(sheet, nextRow, 2);
            Date checkOutDate = HSSFDateUtil.getJavaDate(Double.parseDouble(checkOutDateStr));
            System.out.println("离店日期: "+checkOutDate);
            order.setCheckOutDate(checkOutDate);

            //todo 间夜数
            int numbersRoom = Integer.parseInt(super.getCellValue(sheet, row, 4).substring(0,1));
            System.out.println("房间数: "+ numbersRoom);
            order.setNumbersRoom(numbersRoom);
            int numbersNight = Integer.parseInt(super.getCellValue(sheet, row, 4).substring(0,1));
            System.out.println("夜晚数: "+ numbersNight);
            order.setNumbersNight(numbersNight);
            String checkInPerson = super.getCellValue(sheet, row, 1);
            System.out.println("入住人: "+ checkInPerson);
            order.setCheckInPerson(checkInPerson);
            //colNum++;
            String houseType = super.getCellValue(sheet, row, 3);
            System.out.println("房型: "+ houseType);
            order.setHouseType(houseType);


            String orderStaus = super.getCellValue(sheet, row, 9);

            System.out.println("订单状态: "+orderStaus);
            order.setOrderStatus(orderStaus);

            String sellingPrice = super.getCellValue(sheet, row, 5);
            System.out.println("总价格: "+sellingPrice);
            double sellingPriceDouble = Double.parseDouble(sellingPrice.substring(0, sellingPrice.lastIndexOf("元")));



            order.setSellingPrice(sellingPriceDouble);
            //colNum++;
            list.add(order);
        }
        for (NlOrder nlOrder : list){
            ServerResponse response = orderService.uploadOrder(nlOrder, userName);
            if (!response.isSuccess()) return null;

        }
        return list;

    }

    public static void main(String[] args) {
        String date = "2020-02-02 00:00:00";
        String year = date.substring(0, date.indexOf("-"));
        System.out.println(year);
        Date checkInDate= DateTimeUtil.strToDate(date);
        System.out.println("入住日期: "+checkInDate);
    }

}