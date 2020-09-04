package cn.hctech2006.hotellist.mapper;

import cn.hctech2006.hotellist.bean.NlOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface NlOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NlOrder record);

    NlOrder selectByPrimaryKey(Integer id);

    List<NlOrder> selectAll();

    int updateByPrimaryKey(NlOrder record);

    NlOrder selectByOrderReference(String orderReference);
    NlOrder selectByOrderId(String orderId);
    List<NlOrder> selectByKeyword(@Param("hotelName") String hotelName, @Param("checkInPerson") String checkInPerson, @Param("orderReference") String orderReference, @Param("orderStatus") String orderStatus,
                                  @Param("channel") String channel, @Param("operation") String operation, @Param("proprietaryHotel") String proprietaryHotel,
                                  @Param("dateFlag") String  dateFlag,@Param("startDate") Date startDate,@Param("endDate") Date endDate,
                                  @Param("newFlag") String newFlag, @Param("delFlag") String delFlag);
    int updateByOrderId(NlOrder order);
    int selectNewOrderCount();
    int selectNewCheckInCount();
    int selectTargetOrderCount();
    int deleteByOrderId(String orderId);
}