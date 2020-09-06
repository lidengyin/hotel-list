package cn.hctech2006.hotellist.mapper;

import cn.hctech2006.hotellist.bean.NlHotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface NlHotelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NlHotel record);

    NlHotel selectByPrimaryKey(Integer id);

    List<NlHotel> selectAll();

    int updateByPrimaryKey(NlHotel record);

    NlHotel selectByHotelId(String hotelId);

    List<NlHotel> selectByKeyword(@Param("hotelName") String hotelName, @Param("hotelCity") String hotelCity, @Param("hotelStatus") String hotelStatus);

    int updateByHotelId(NlHotel hotel);
    List<String> selectHotelCity();
}