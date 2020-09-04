package cn.hctech2006.hotellist.controller;

import cn.hctech2006.hotellist.bean.MmallUser;
import cn.hctech2006.hotellist.bean.NlOrder;
import cn.hctech2006.hotellist.common.Const;
import cn.hctech2006.hotellist.common.ResponseCode;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.service.impl.OrderServiceImpl;
import cn.hctech2006.hotellist.service.impl.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

@Api(tags = "订单管理控制器")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceImpl userService;
    @ApiOperation(value = "订单手动录入接口")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "orderReference", value = "订单编号",required = true, defaultValue = "13324087059"),
            @ApiImplicitParam(type = "query", name = "hotelName", value = "酒店名称",required = true, defaultValue = "北京国宾馆"),
            @ApiImplicitParam(type = "query", name = "targetDate", value = "预定日期",required = false, defaultValue = "2020-08-30"),
            @ApiImplicitParam(type = "query", name = "channel", value = "渠道",required = false, defaultValue = "飞猪"),
            @ApiImplicitParam(type = "query", name = "checkInDate", value = "入住日期",required = false, defaultValue = "2020-08-31"),
            @ApiImplicitParam(type = "query", name = "checkOutDate", value = "离店日期",required = false, defaultValue = "2020-09-01"),
            @ApiImplicitParam(type = "query", name = "checkInPerson", value = "入住人",required = false, defaultValue = "王思聪"),
            @ApiImplicitParam(type = "query", name = "floorPrice", value = "底价, 需要人工标注, 我们默认给0.00",required = false, defaultValue = "0.00"),
            @ApiImplicitParam(type = "query", name = "sellingPrice", value = "卖价, 默认0.00",required = false, defaultValue = "0.00"),
            //@ApiImplicitParam(type = "query", name = "grossMargin", value = "毛利, 毛利通过卖价减去底价获得",required = true, defaultValue = "119.00"),
            @ApiImplicitParam(type = "query", name = "ordrerStatus", value = "订单状态,可以手写,但是不是必须的",required = false, defaultValue = "交易成功"),
            @ApiImplicitParam(type = "query", name = "salesManager", value = "销售经理",required = false, defaultValue = "马云"),
            @ApiImplicitParam(type = "query", name = "operation", value = "运营",required = false, defaultValue = "马化腾"),
            @ApiImplicitParam(type = "query", name = "invoiceTitle", value = "发票抬头",required = false, defaultValue = "北京德云社"),
            @ApiImplicitParam(type = "query", name = "dutyParagraph", value = "税号",required = false, defaultValue = "91440300MA5DA5PPXP"),
            @ApiImplicitParam(type = "query", name = "remark", value = "备注",required = false, defaultValue = "相声相声你真棒,德云德运你最强,师傅师傅郭德纲"),
            @ApiImplicitParam(type = "query", name = "proprietaryHotel", value = "是否是自营酒店, 0不是, 1是",required = false, defaultValue = "0"),
            @ApiImplicitParam(type = "query", name = "houseType", value = "房间类型",required = false, defaultValue = "总统套房-全额预付含双早"),
            @ApiImplicitParam(type = "query", name = "numbersRoom", value = "房间数",required = false, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "numbersNight", value = "夜数",required = false, defaultValue = "1"),
            //@ApiImplicitParam(type = "query", name = "handler", value = "删除修改录入操作者姓名",required = false, defaultValue = "李登印"),
            //@ApiImplicitParam(type = "query", name = "handlerTime", value = "操作时间, 精确到秒",required = false, defaultValue = "2020-09-03 15:07:55"),
            //@ApiImplicitParam(type = "query", name = "handlerContent", value = "操作内容",required = false, defaultValue = "修改了某某某")

    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.PUT}, allowCredentials = "true", allowedHeaders = "*")
    @PostMapping("/upload_order.do")
    public ServerResponse uploadOrder(@ApiIgnore HttpSession session, NlOrder nlOrder, String handlerContent){
        //从Session缓存中获取当前用户
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        //判断用户是否为空，如果不为空返回当前用户，否则返回错误信息
        if(user != null){

            return orderService.uploadOrder(nlOrder, user.getUsername());
        }
        return ServerResponse.createByError("用户未登录，无法执行当前操作");
        //System.out.println("handlerContent: "+handlerContent);
        //return orderService.uploadOrder(nlOrder);

    }
    @ApiOperation(value = "根据订单编号查看具体订单")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "orderId", value = "订单编号", required = true, defaultValue = "13324087059")
    })
    @GetMapping("one_order.do")
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.PUT}, allowCredentials = "true", allowedHeaders = "*")
    public ServerResponse oneOrder(@ApiIgnore HttpSession session,  String orderId){
        //从Session缓存中获取当前用户
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        //判断用户是否为空，如果不为空返回当前用户，否则返回错误信息
        if(user != null){
            return orderService.oneOrder(orderId);
        }
        return ServerResponse.createByError("用户未登录，无法执行当前操作");

    }

    @ApiOperation(value = "分页查看订单列表", notes = "" +
            "newCheckInNum: 今日入住" +
            "newOrderNum: 今日新增" +
            "targetOrderNum: 待入住")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "pageNum", value = "页数", required = true, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "pageSize", value = "页行", required = true, defaultValue = "10"),
            @ApiImplicitParam(type = "query", name = "hotelName", value = "酒店名称", required = false, defaultValue = "北京国宾馆"),
            @ApiImplicitParam(type = "query", name = "checkInPerson", value = "客人姓名", required = false, defaultValue = "特朗普"),
            @ApiImplicitParam(type = "query", name = "orderReference", value = "显示订单号", required = false, defaultValue = "13324087059"),
            @ApiImplicitParam(type = "query", name = "orderStatus", value = "订单状态", required = false, defaultValue = "待支付"),
            @ApiImplicitParam(type = "query", name = "channel", value = "渠道", required = false, defaultValue = "美团"),
            @ApiImplicitParam(type = "query", name = "operation", value = "运营", required = false, defaultValue = "安倍晋三"),
            @ApiImplicitParam(type = "query", name = "proprietaryHotel", value = "自营, 1自营, 0非自营", required = false, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "dateFlag", value = "时间类型, 0是全部日期, 1, 预定日期, 2, 入住日期, 3, 离店日期", required = false, defaultValue = "0"),
            @ApiImplicitParam(type = "query", name = "newFlag", value = "今日判断标志, 0是今日新增, 1是今日入住, 2是待入住", required = false, defaultValue = "0"),
            @ApiImplicitParam(type = "query", name = "delFlag", value = "删除判断标志, 0是删除标志, 1正常显示", required = false, defaultValue = "1")


    })
    @GetMapping("/list_order.do")
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.PUT}, allowCredentials = "true", allowedHeaders = "*")
    public ServerResponse listOrder(@ApiIgnore HttpSession session,  int pageNum, int pageSize, String hotelName, String checkInPerson, String orderReference, String orderStatus, String channel, String operation, String proprietaryHotel,
                                    String dateFlag,String nowFlag,
                                    @ApiParam(name = "startDate" , value = "模糊查询开始时间") @RequestParam(name = "startDate", required = false)  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                    @ApiParam(name  = "endDate" , value= "模糊查询结束时间") @RequestParam(name = "endDate", required = false)  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT")   @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                    String newFlag, String delFlag){


        //从Session缓存中获取当前用户
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        //判断用户是否为空，如果不为空返回当前用户，否则返回错误信息
        if(user != null){
            return orderService.listOrder(pageNum, pageSize, hotelName, checkInPerson, orderReference, orderStatus, channel, operation, proprietaryHotel,
                    dateFlag, startDate, endDate, newFlag, delFlag);
        }
        return ServerResponse.createByError("用户未登录，无法执行当前操作");

    }
    @ApiOperation(value = "订单修改接口", notes = "唯一标示是orderId" +
            "需要修改的是底价, 毛利, 订单状态, 销售经理, 运营, 发票抬头, 税号, 备注这一些, 其他接口也开放出来不过可能不需要修改")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "orderId", value = "自生成唯一性订单编号",required = true, defaultValue = "13324087059"),
            @ApiImplicitParam(type = "query", name = "orderReference", value = "导入订单编号",required = false, defaultValue = "13324087059"),
            @ApiImplicitParam(type = "query", name = "hotelName", value = "酒店名称",required = false, defaultValue = "北京国宾馆"),
            @ApiImplicitParam(type = "query", name = "targetDate", value = "预定日期",required = false, defaultValue = "2020-08-30"),
            @ApiImplicitParam(type = "query", name = "channel", value = "渠道",required = false, defaultValue = "飞猪"),
            @ApiImplicitParam(type = "query", name = "checkInDate", value = "入住日期",required = false, defaultValue = "2020-08-31"),
            @ApiImplicitParam(type = "query", name = "checkOutDate", value = "离店日期",required = false, defaultValue = "2020-09-01"),
            @ApiImplicitParam(type = "query", name = "checkInPerson", value = "入住人",required = false, defaultValue = "王思聪"),
            @ApiImplicitParam(type = "query", name = "floorPrice", value = "底价, 需要人工标注, 我们默认给0.00",required = false, defaultValue = "0.00"),
            @ApiImplicitParam(type = "query", name = "sellingPrice", value = "卖价, 默认0.00",required = false, defaultValue = "0.00"),
            //@ApiImplicitParam(type = "query", name = "grossMargin", value = "毛利, 毛利通过卖价减去底价获得",required = true, defaultValue = "119.00"),
            @ApiImplicitParam(type = "query", name = "orderStatus", value = "订单状态",required = false, defaultValue = "交易成功"),
            @ApiImplicitParam(type = "query", name = "salesManager", value = "销售经理",required = false, defaultValue = "马云"),
            @ApiImplicitParam(type = "query", name = "operation", value = "运营",required = false, defaultValue = "马化腾"),
            @ApiImplicitParam(type = "query", name = "invoiceTitle", value = "发票抬头",required = false, defaultValue = "北京德云社"),
            @ApiImplicitParam(type = "query", name = "dutyParagraph", value = "税号",required = false, defaultValue = "91440300MA5DA5PPXP"),
            @ApiImplicitParam(type = "query", name = "remark", value = "备注",required = false, defaultValue = "相声相声你真棒,德云德运你最强,师傅师傅郭德纲"),
            @ApiImplicitParam(type = "query", name = "proprietaryHotel", value = "是否是自营酒店, 0不是, 1是",required = false, defaultValue = "0"),
            @ApiImplicitParam(type = "query", name = "houseType", value = "房间类型",required = false, defaultValue = "总统套房-全额预付含双早"),
            @ApiImplicitParam(type = "query", name = "numbersRoom", value = "房间数",required = false, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "numbersNight", value = "夜数",required = false, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "delFlag", value = "删除判断标志,删除订单使用, 0是删除标志, 1正常显示", required = false, defaultValue = "1")
    })
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.PUT}, allowCredentials = "true", allowedHeaders = "*")
    @PutMapping("/update_order.do")
    public ServerResponse update_order(@ApiIgnore HttpSession session,  NlOrder nlOrder, String handlerContent){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");
        }
        //判断用户是否是管理员
        if (userService.checkAdminRole(user).isSuccess()){
            nlOrder.setHandler(user.getUsername());
            nlOrder.setHandlerContent(handlerContent);
            return orderService.update_order(nlOrder);
        }else {
            return ServerResponse.createByError("权限不足，请重新登录");
        }

    }

    @ApiOperation(value = "订单批量删除功能", notes = "注意现在是真实删除,不可恢复")
    @DeleteMapping("/delete_list_order.do")
    public ServerResponse deleteListOrder(@ApiIgnore HttpSession session, @ApiParam(name = "订单编号orderId列表, list格式", defaultValue = "[\n" +
            "  \"8505484f-ddca-43ee-b544-ecc656033e45,\"\n" +
            "83345a82-f18f-4333-877b-90cc1dc65d03]") @RequestBody List<String> orderIds){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        //判断用户是否是管理员
        if (userService.checkAdminRole(user).isSuccess()){

            return orderService.deleteListOrder(orderIds, user.getUsername());

        }else {
            return ServerResponse.createByError("权限不足，请重新登录");
        }

    }


    @ApiOperation(value = "Excel导出订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "excelFlag", value = "分页逻辑, 0是当前界面, 1是整个界面", required = false, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "pageNum", value = "页数", required = false, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "pageSize", value = "页行", required = false, defaultValue = "10"),
            @ApiImplicitParam(type = "query", name = "hotelName", value = "酒店名称", required = false, defaultValue = "北京国宾馆"),
            @ApiImplicitParam(type = "query", name = "checkInPerson", value = "客人姓名", required = false, defaultValue = "特朗普"),
            @ApiImplicitParam(type = "query", name = "orderReference", value = "显示订单号", required = false, defaultValue = "13324087059"),
            @ApiImplicitParam(type = "query", name = "orderStatus", value = "订单状态", required = false, defaultValue = "待支付"),
            @ApiImplicitParam(type = "query", name = "channel", value = "渠道", required = false, defaultValue = "美团"),
            @ApiImplicitParam(type = "query", name = "operation", value = "运营", required = false, defaultValue = "安倍晋三"),
            @ApiImplicitParam(type = "query", name = "proprietaryHotel", value = "自营, 1自营, 0非自营", required = false, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "dateFlag", value = "时间类型, 0是全部日期, 1, 预定日期, 2, 入住日期, 3, 离店日期", required = false, defaultValue = "0"),
            @ApiImplicitParam(type = "query", name = "newFlag", value = "今日判断标志, 0是今日新增, 1是今日入住, 2是待入住", required = false, defaultValue = "0"),
            @ApiImplicitParam(type = "query", name = "delFlag", value = "删除判断标志, 0是删除标志, 1正常显示", required = false, defaultValue = "1")


    })
    @GetMapping("/output_excel_order.do")
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.PATCH, RequestMethod.PUT}, allowCredentials = "true", allowedHeaders = "*")

    public void outputExcelOrder(HttpServletRequest request, HttpServletResponse response, String  pageNum, String pageSize, String hotelName, String checkInPerson, String orderReference, String orderStatus, String channel, String operation, String proprietaryHotel,
                                    String dateFlag,String nowFlag,
                                    @ApiParam(name = "startDate" , value = "模糊查询开始时间") @RequestParam(name = "startDate", required = false)  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                    @ApiParam(name  = "endDate" , value= "模糊查询结束时间") @RequestParam(name = "endDate", required = false)  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT")   @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                    String newFlag, String excelFlag,String delFlag) throws Exception {
         orderService.excelExport(request, response,pageNum, pageSize, hotelName, checkInPerson, orderReference, orderStatus, channel, operation, proprietaryHotel,
                dateFlag, startDate, endDate, newFlag, excelFlag,delFlag);
    }

    public static void main(String[] args) {

        NlOrder order = new NlOrder();

        Class listClass = order.getClass();
        Field[] fields = listClass.getDeclaredFields();
        for (int i = 0; i < fields.length-1; i ++){
            Field field = fields[i];
            field.setAccessible(true);
            //key得到属性名
            String key = field.getName();
            System.out.println("key: "+key);
        }
    }


}
