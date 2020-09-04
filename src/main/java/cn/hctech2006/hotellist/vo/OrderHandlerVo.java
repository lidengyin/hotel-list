package cn.hctech2006.hotellist.vo;

import cn.hctech2006.hotellist.bean.NlHandler;
import cn.hctech2006.hotellist.bean.NlOrder;

import java.util.List;
import java.util.logging.Handler;

public class OrderHandlerVo {
    private List<NlHandler> handlers;
    private NlOrder order;

    public List<NlHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<NlHandler> handlers) {
        this.handlers = handlers;
    }

    public NlOrder getOrder() {
        return order;
    }

    public void setOrder(NlOrder order) {
        this.order = order;
    }
}
