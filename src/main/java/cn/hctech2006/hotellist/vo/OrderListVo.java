package cn.hctech2006.hotellist.vo;

import cn.hctech2006.hotellist.bean.NlOrder;


import java.io.Serializable;
import java.util.List;

public class OrderListVo implements Serializable {

    private List<NlOrder> orders;
    private int newOrderCount;
    private int newCheckInCount;
    private int targetOrderCount;

    public OrderListVo(List<NlOrder> orders, int newOrderCount, int newCheckInCount, int targetOrderCount) {
        this.orders = orders;
        this.newOrderCount = newOrderCount;
        this.newCheckInCount = newCheckInCount;
        this.targetOrderCount = targetOrderCount;
    }

    public List<NlOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<NlOrder> orders) {
        this.orders = orders;
    }

    public int getNewOrderCount() {
        return newOrderCount;
    }

    public void setNewOrderCount(int newOrderCount) {
        this.newOrderCount = newOrderCount;
    }

    public int getNewCheckInCount() {
        return newCheckInCount;
    }

    public void setNewCheckInCount(int newCheckInCount) {
        this.newCheckInCount = newCheckInCount;
    }

    public int getTargetOrderCount() {
        return targetOrderCount;
    }

    public void setTargetOrderCount(int targetOrderCount) {
        this.targetOrderCount = targetOrderCount;
    }
}
