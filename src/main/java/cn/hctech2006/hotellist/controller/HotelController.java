package cn.hctech2006.hotellist.controller;

import cn.hctech2006.hotellist.bean.NlHotel;
import cn.hctech2006.hotellist.common.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.bytedeco.javacpp.presets.opencv_core;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "自营酒店管理控制器")
@RequestMapping("/hotel")
@RestController
public class HotelController {
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
    public ServerResponse uploadHotel(NlHotel hotel){
        return null;
    }
}
