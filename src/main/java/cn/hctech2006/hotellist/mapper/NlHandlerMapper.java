package cn.hctech2006.hotellist.mapper;

import cn.hctech2006.hotellist.bean.NlHandler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NlHandlerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NlHandler record);

    NlHandler selectByPrimaryKey(Integer id);

    List<NlHandler> selectAll();

    int updateByPrimaryKey(NlHandler record);

    List<NlHandler> selectByOrderIdDesc(String orderId);

}