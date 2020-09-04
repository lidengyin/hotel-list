package cn.hctech2006.hotellist.service.impl;

import cn.hctech2006.hotellist.bean.NlHotel;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.mapper.NlHotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl {
    @Autowired
    private NlHotelMapper hotelMapper;
    public ServerResponse uploadHotel(NlHotel hotel){
        //todo
        return null;
    }
}
