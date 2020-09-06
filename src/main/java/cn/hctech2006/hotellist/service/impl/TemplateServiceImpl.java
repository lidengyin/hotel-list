package cn.hctech2006.hotellist.service.impl;

import ch.qos.logback.core.spi.PreSerializationTransformer;
import cn.hctech2006.hotellist.bean.NlHotel;
import cn.hctech2006.hotellist.bean.NlTemplate;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.mapper.NlTemplateMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Service
public class TemplateServiceImpl {
    @Autowired
    private NlTemplateMapper templateMapper;
    @Autowired
    private HotelServiceImpl hotelService;
    /**
     * 酒店模板上传
     * @param template
     * @return
     */

    public ServerResponse upload_template(NlTemplate template){
        if (template.getHotelId() == null || template.getHotelId().equals("")) return ServerResponse.createByError("酒店编号不能为空");
        if (template.getFloorPrice() == null || template.getFloorPrice().equals("")) return ServerResponse.createByError("酒店底价不能为空");
        if (template.getHouseType() == null || template.getHouseType().equals("")) return ServerResponse.createByError("酒店房型不能为空");

        ServerResponse response = hotelService.selectByHotelId(template.getHotelId());
        if (!response.isSuccess()) return ServerResponse.createByError("该酒店编号不存在");
        template.setTemplateId(UUID.randomUUID().toString());
        template.setDelFlag("1");
        int result = templateMapper.insert(template);
        if (result > 0) return ServerResponse.createBySuccess(template);
        return ServerResponse.createByError("酒店模板上传失败");
    }

    /**
     * 自营酒店房型模板列表
     * @param hotelId
     * @param delFlag
     * @return
     */
    public ServerResponse listTemplate(int pageNum, int pageSize, String hotelId, String delFlag ){
        PageHelper.startPage(pageNum, pageSize);
        List<NlTemplate> templates = templateMapper.selectTemplateByKeyword(hotelId, delFlag);
        PageInfo result = new PageInfo(templates);
        return ServerResponse.createBySuccess(result);
    }

    /**
     * 根据酒店模板进行修改
     * @param param
     * @return
     */
    public ServerResponse updateByTemplateId(NlTemplate param){
        if (param.getTemplateId() == null || param.getTemplateId().equals("")) return ServerResponse.createByError("底价模板不能为空");
        NlTemplate template = templateMapper.selectByTemplateId(param.getTemplateId());
        if (template == null) return ServerResponse.createByError("更新失败");
        int result = templateMapper.updateByTemplateId(param);
        if (result > 0) return ServerResponse.createBySuccess("修改成功");
        return ServerResponse.createByError("修改失败");
    }

    /**
     * 根据模板编号选择模板
     * @param templateId
     * @return
     */
    public ServerResponse selectByTemplateId(String templateId){
        if (templateId == null || templateId.equals("")) return ServerResponse.createByError("请输入正确的模板编号");
        NlTemplate template = templateMapper.selectByTemplateId(templateId);
        if (template == null ) return ServerResponse.createByError("模板为空");
        return ServerResponse.createBySuccess(template);
    }

}
