package cn.hctech2006.hotellist.mapper;

import cn.hctech2006.hotellist.bean.NlHotel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NlHotelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NlHotel record);

    NlHotel selectByPrimaryKey(Integer id);

    List<NlHotel> selectAll();

    int updateByPrimaryKey(NlHotel record);
}