package cn.hctech2006.hotellist.controller;

import cn.hctech2006.hotellist.bean.MmallUser;
import cn.hctech2006.hotellist.bean.NlHotel;
import cn.hctech2006.hotellist.common.Const;
import cn.hctech2006.hotellist.common.ResponseCode;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.service.impl.HotelServiceImpl;
import cn.hctech2006.hotellist.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@Api(tags = "自营酒店管理控制器")
@RequestMapping("/hotel")
@RestController
public class HotelController {
    @Autowired
    private HotelServiceImpl hotelService;
    @Autowired
    private UserServiceImpl userService;
    @ApiOperation(value = "自营酒店上传")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "hotelName", value = "酒店名称", required = true, defaultValue = "天朝中央饭店"),
            @ApiImplicitParam(type = "query", name = "hotelReference", value = "导入酒店编号", required = true, defaultValue = "123456"),
            @ApiImplicitParam(type = "query", name = "hotelCity", value = "酒店所在城市", required = true, defaultValue = "北京"),
            @ApiImplicitParam(type = "query", name = "hotelAddress", value = "酒店具体地址", required = true, defaultValue = "北京中南海"),
            @ApiImplicitParam(type = "query", name = "hotelPhone", value = "酒店电话", required = true, defaultValue = "110"),
            @ApiImplicitParam(type = "query", name = "abutManager", value = "对接经理", required = true, defaultValue = "特朗普"),
            @ApiImplicitParam(type = "query", name = "abutManagerPhone", value = "对接经理电话", required = true, defaultValue = "911"),
            @ApiImplicitParam(type = "query", name = "salesManager", value = "销售经理", required = true, defaultValue = "马克龙"),
            @ApiImplicitParam(type = "query", name = "operation", value = "运营", required = true, defaultValue = "安倍晋三竭诚为您服务"),
            @ApiImplicitParam(type = "query", name = "hotelStatus", value = "酒店状态", required = true, defaultValue = "上架"),
            @ApiImplicitParam(type = "query", name = "contract", value = "酒店合同", required = true, defaultValue = "xxxxxx"),
            @ApiImplicitParam(type = "query", name = "remark", value = "备注", required = true, defaultValue = "欢迎体验本店霸王餐闯关业务,活着通关后即可赢得终身免费大奖"),
    })
    @PostMapping("upload_hotel.do")
    public ServerResponse uploadHotel(@ApiIgnore HttpSession session,  NlHotel hotel){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return hotelService.uploadHotel(hotel);
    }

    @ApiOperation(value = "自营酒店修改")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "hotelId", value = "用于查找酒店编号", required = true, defaultValue ="xxxxx"),
            @ApiImplicitParam(type = "query", name = "hotelName", value = "酒店名称", required = false, defaultValue = "天朝中央饭店"),
            @ApiImplicitParam(type = "query", name = "hotelReference", value = "导入酒店编号", required = false, defaultValue = "123456"),
            @ApiImplicitParam(type = "query", name = "hotelCity", value = "酒店所在城市", required = false, defaultValue = "北京"),
            @ApiImplicitParam(type = "query", name = "hotelAddress", value = "酒店具体地址", required = false, defaultValue = "北京中南海"),
            @ApiImplicitParam(type = "query", name = "hotelPhone", value = "酒店电话", required = false, defaultValue = "110"),
            @ApiImplicitParam(type = "query", name = "abutManager", value = "对接经理", required = false, defaultValue = "特朗普"),
            @ApiImplicitParam(type = "query", name = "abutManagerPhone", value = "对接经理电话", required = false, defaultValue = "911"),
            @ApiImplicitParam(type = "query", name = "salesManager", value = "销售经理", required = false, defaultValue = "马克龙"),
            @ApiImplicitParam(type = "query", name = "operation", value = "运营", required = false, defaultValue = "安倍晋三竭诚为您服务"),
            @ApiImplicitParam(type = "query", name = "hotelStatus", value = "酒店状态, 0下架, 1上架", required = false, defaultValue = "上架"),
            @ApiImplicitParam(type = "query", name = "contract", value = "酒店合同", required = false, defaultValue = "xxxxxx"),
            @ApiImplicitParam(type = "query", name = "remark", value = "备注", required = false, defaultValue = "欢迎体验本店霸王餐闯关业务,活着通关后即可赢得终身免费大奖"),

    })
    @PutMapping("/update_hotel.do")
    public ServerResponse updateHotel(@ApiIgnore HttpSession session, NlHotel hotel){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        //判断用户是否是管理员
        if (userService.checkAdminRole(user).isSuccess()){

            return hotelService.updateHotel(hotel);

        }else {
            return ServerResponse.createByError("权限不足，请重新登录");
        }

    }

    @ApiOperation(value = "酒店列表展示")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "pageNum", value = "页数", required = true, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "pageSize", value = "页行", required = true, defaultValue = "10"),
            @ApiImplicitParam(type = "query", name = "hotelName", value = "酒店名称, 模糊查询", required = false, defaultValue = "帝国中央大酒店"),
            @ApiImplicitParam(type = "query", name = "hotelCity", value = "酒店所在城市", required = false, defaultValue = "北京"),
            @ApiImplicitParam(type = "query", name = "hotelStatus", value = "酒店状态查询, 0下架, 1上架", required = false, defaultValue = "1")
    })
    @GetMapping("/list_hotel.do")
    public ServerResponse list_hotel(@ApiIgnore HttpSession session,  int pageNum, int pageSize, String hotelName, String hotelCity, String hotelStatus){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return hotelService.listHotel(pageNum, pageSize, hotelName, hotelCity, hotelStatus);
    }
    @ApiOperation(value = "酒店详情展示")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "hotelId", value = "酒店编号", required = true, defaultValue = "11111")
    })
    @GetMapping("/one_hotel.do")
    public ServerResponse oneHotel(@ApiIgnore HttpSession session,  String hotelId){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return hotelService.selectByHotelId(hotelId);
    }
    @ApiOperation(value = "酒店所在城市列表")
    @ApiImplicitParams({

    })
    @GetMapping("city_list_hotel.do")
    public ServerResponse cityList(@ApiIgnore  HttpSession session){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return hotelService.selectHotelCityName();
    }
    @ApiOperation(value = "酒店合同上传控制器")
    @PostMapping("/upload_contract.do")
    public ServerResponse uploadContract(@ApiIgnore HttpSession session,  MultipartFile file){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return hotelService.uploadContract(file);
    }



}
