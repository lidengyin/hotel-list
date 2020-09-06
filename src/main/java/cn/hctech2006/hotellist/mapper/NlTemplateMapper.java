package cn.hctech2006.hotellist.mapper;

import cn.hctech2006.hotellist.bean.NlTemplate;
import java.util.List;

public interface NlTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NlTemplate record);

    NlTemplate selectByPrimaryKey(Integer id);

    List<NlTemplate> selectAll();

    int updateByPrimaryKey(NlTemplate record);
}