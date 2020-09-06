package cn.hctech2006.hotellist.mapper;

import cn.hctech2006.hotellist.bean.NlTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface NlTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NlTemplate record);

    NlTemplate selectByPrimaryKey(Integer id);

    List<NlTemplate> selectAll();

    int updateByPrimaryKey(NlTemplate record);

    List<NlTemplate>  selectTemplateByKeyword(@Param("hotelId") String hotelId,@Param("delFlag") String delFlag);

    NlTemplate selectByTemplateId(String templateId);
    int updateByTemplateId(NlTemplate template);
}