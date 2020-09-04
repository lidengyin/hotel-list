package cn.hctech2006.hotellist.bean;

import java.io.Serializable;
import java.util.Date;

public class NlHandler implements Serializable {

    private Integer id;

    private String handlerId;

    private String orderId;

    private String handler;

    private Date handlerTime;

    private String handlerContent;

    private String flag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Date getHandlerTime() {
        return handlerTime;
    }

    public void setHandlerTime(Date handlerTime) {
        this.handlerTime = handlerTime;
    }

    public String getHandlerContent() {
        return handlerContent;
    }

    public void setHandlerContent(String handlerContent) {
        this.handlerContent = handlerContent;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", handlerId=").append(handlerId);
        sb.append(", orderId=").append(orderId);
        sb.append(", handler=").append(handler);
        sb.append(", handlerTime=").append(handlerTime);
        sb.append(", handlerContent=").append(handlerContent);
        sb.append(", flag=").append(flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}