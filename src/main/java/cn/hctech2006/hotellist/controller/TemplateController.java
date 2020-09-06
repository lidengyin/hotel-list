package cn.hctech2006.hotellist.controller;

import cn.hctech2006.hotellist.bean.MmallUser;
import cn.hctech2006.hotellist.bean.NlTemplate;
import cn.hctech2006.hotellist.common.Const;
import cn.hctech2006.hotellist.common.ResponseCode;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.service.impl.TemplateServiceImpl;
import cn.hctech2006.hotellist.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@Api(tags = "酒店模板管理控制器")
@RequestMapping("/template")
@RestController
public class TemplateController {
    @Autowired
    private TemplateServiceImpl templateService;
    @Autowired
    private UserServiceImpl userService;
    @ApiOperation(value = "酒店模板上传")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "hotelId", value = "酒店编号", required = true, defaultValue = "xxxxx"),
            @ApiImplicitParam(type = "query", name = "floorPrice", value = "酒店底价", required = true, defaultValue = "22.2"),
            @ApiImplicitParam(type = "query", name = "houseType", value = "房型", required = true, defaultValue = "总统套房")

    })
    @PostMapping("/upload_template.do")
    public ServerResponse upload_template(@ApiIgnore HttpSession session, NlTemplate template){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return templateService.upload_template(template);
    }

    @ApiOperation(value = "酒店模板列表")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "pageNum", value = "页码", required = true, defaultValue = "1"),
            @ApiImplicitParam(type = "query", name = "pageSize", value = "页行", required = true, defaultValue = "10"),
            @ApiImplicitParam(type = "query", name = "hotelId", value = "酒店编号", required = false, defaultValue = "xxxxxx"),
            @ApiImplicitParam(type = "query", name = "delFlag", value = "是否废弃, 0废弃,1正常", required = false, defaultValue = "0"),
    })
    @GetMapping("/list_template.do")
    public ServerResponse listTemplate(@ApiIgnore HttpSession session, int pageNum, int pageSize, String hotelId, String delFlag ){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return templateService.listTemplate(pageNum,pageSize,hotelId, delFlag);
    }
    @ApiOperation(value = "酒店模板修改")
    @ApiImplicitParams({

            @ApiImplicitParam(type = "query", name = "templateId", value = "模板编号", required = true, defaultValue = "xxxxx"),
            @ApiImplicitParam(type = "query", name = "hotelId", value = "酒店编号", required = false, defaultValue = "xxxxx"),
            @ApiImplicitParam(type = "query", name = "floorPrice", value = "酒店底价", required = false, defaultValue = "22.2"),
            @ApiImplicitParam(type = "query", name = "houseType", value = "房型", required = false, defaultValue = "总统套房"),
            @ApiImplicitParam(type = "query", name = "delFlag", value = "删除标志, 1正常, 0删除", required = false, defaultValue = "1")
    })

    @PutMapping("/update_template.do")
    public ServerResponse updateTemplate(@ApiIgnore HttpSession session, NlTemplate nlTemplate){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        //判断用户是否是管理员
        if (userService.checkAdminRole(user).isSuccess()){

            return templateService.updateByTemplateId(nlTemplate);

        }else {
            return ServerResponse.createByError("权限不足，请重新登录");
        }
    }

    @ApiOperation(value = "根据模板编号具体查看")
    @ApiImplicitParams({
            @ApiImplicitParam(type = "query", name = "templateId", value = "模板编号", required = true, defaultValue = "xxxx")
    })
    @GetMapping("/one_template.do")
    public ServerResponse oneTemplate(@ApiIgnore HttpSession session, String templateId){
        //判断用户是否登录
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        if (user == null){

            return ServerResponse.createByError(ResponseCode.NEED_LOGIN.getCode(),"用户未登录");

        }
        return templateService.selectByTemplateId(templateId);
    }
}
