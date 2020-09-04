package cn.hctech2006.hotellist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.hctech2006.hotellist.bean.MmallUser;
import cn.hctech2006.hotellist.common.Const;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.service.impl.ImportExcelServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "Excel管理控制器")
@RestController
@RequestMapping("/excel")
public class ImportExcelController {

    @Autowired
    ImportExcelServiceImpl iImportExcelService;
    @ApiOperation(value = "代理通导入")
    @PostMapping(value="/input_agency_order.do")
    public ServerResponse inputAgentOrder(HttpSession session, MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
        //从Session缓存中获取当前用户
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        //判断用户是否为空，如果不为空返回当前用户，否则返回错误信息
        if(user != null){
            List list = iImportExcelService.importExcelWithSimple(file, req, resp, user.getUsername());
            if(list == null || list.size() == 0 ) {
                return ServerResponse.createByError("导入失败");
            }
            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByError("用户未登录，无法执行当前操作");

    }
    @ApiOperation(value = "飞猪导入")
    @PostMapping(value="/input_fliggy_order.do")
    public ServerResponse inputFliggyOrder(@ApiIgnore HttpSession session,  MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {

        //从Session缓存中获取当前用户
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        //判断用户是否为空，如果不为空返回当前用户，否则返回错误信息
        if(user != null){
            List list = iImportExcelService.importFliggyOrder(file, req, resp, user.getUsername());

            if(list == null || list.size() == 0 ) {
                return ServerResponse.createByError("导入失败");
            }

            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByError("用户未登录，无法执行当前操作");

    }
    @ApiOperation(value = "青芒果导入")
    @PostMapping(value="/input_green_mango_order.do")
    public ServerResponse inputGreenMangoOrder(@ApiIgnore HttpSession session,  MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {

        //从Session缓存中获取当前用户
        MmallUser user = (MmallUser) session.getAttribute(Const.CURRENT_USER);
        //判断用户是否为空，如果不为空返回当前用户，否则返回错误信息
        if(user != null){
            List list = iImportExcelService.importExcelWithGreenMangoes(file, req, resp, user.getUsername());

            if(list == null || list.size() == 0 ) {
                return ServerResponse.createByError("导入失败");
            }

            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByError("用户未登录，无法执行当前操作");

    }

}