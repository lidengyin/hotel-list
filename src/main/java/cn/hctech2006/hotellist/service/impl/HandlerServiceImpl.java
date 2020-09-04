package cn.hctech2006.hotellist.service.impl;

import cn.hctech2006.hotellist.bean.NlHandler;
import cn.hctech2006.hotellist.common.ServerResponse;
import cn.hctech2006.hotellist.mapper.NlHandlerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HandlerServiceImpl {

    @Autowired
    private NlHandlerMapper handlerMapper;
    public ServerResponse uploadHandler(String orderId, String handlerName, String handlerContent){
        NlHandler handler = new NlHandler();
        handler.setHandlerId(UUID.randomUUID().toString());
        handler.setHandler(handlerName);
        handler.setHandlerContent(handlerContent);
        handler.setHandlerTime(new Date());
        handler.setOrderId(orderId);
        handler.setFlag("1");
        int result = handlerMapper.insert(handler);
        if (result > 0) return ServerResponse.createBySuccess();
        return ServerResponse.createByError();
    }


    public ServerResponse listHandler(String orderId){
        List<NlHandler> handlers = handlerMapper.selectByOrderIdDesc(orderId);
        return ServerResponse.createBySuccess(handlers);
    }
}
