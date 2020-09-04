package cn.hctech2006.hotellist.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.druid.support.monitor.annotation.MTable;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@ExcelTarget("order")
public class NlOrder implements Serializable {
    private Integer id;

    private String orderId;
    @Excel(name = "渠道订单号", orderNum = "0")
    private String orderReference;
    @Excel(name = "酒店", orderNum = "1")
    private String hotelName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单日期", orderNum = "2")
    private Date targetDate;
    @Excel(name = "渠道", orderNum = "3")
    private String channel;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住日期", orderNum = "4")
    private Date checkInDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离店日期", orderNum = "5")
    private Date checkOutDate;
    @Excel(name = "入住人", orderNum = "6")
    private String checkInPerson;
    @Excel(name = "底价")
    private Double floorPrice;
    @Excel(name = "总卖价", orderNum = "7")
    private Double sellingPrice;

    private Double grossMargin;
    @Excel(name = "支付状态", orderNum = "8")
    private String orderStatus;

    private String salesManager;

    private String operation;

    private String invoiceTitle;

    private String dutyParagraph;

    private String remark;

    private Integer proprietaryHotel;

    private String houseType;

    private Integer numbersRoom;

    private Integer numbersNight;
    private String handler;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date handlerTime;
    private String handlerContent;
    private String delFlag;

    private static final long serialVersionUID = 1L;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCheckInPerson() {
        return checkInPerson;
    }

    public void setCheckInPerson(String checkInPerson) {
        this.checkInPerson = checkInPerson;
    }

    public Double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(Double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getGrossMargin() {
        return grossMargin;
    }

    public void setGrossMargin(Double grossMargin) {
        this.grossMargin = grossMargin;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(String salesManager) {
        this.salesManager = salesManager;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitile) {
        this.invoiceTitle = invoiceTitile;
    }

    public String getDutyParagraph() {
        return dutyParagraph;
    }

    public void setDutyParagraph(String dutyParagraph) {
        this.dutyParagraph = dutyParagraph;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getProprietaryHotel() {
        return proprietaryHotel;
    }

    public void setProprietaryHotel(Integer proprietaryHotel) {
        this.proprietaryHotel = proprietaryHotel;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getNumbersRoom() {
        return numbersRoom;
    }

    public void setNumbersRoom(Integer numbersRoom) {
        this.numbersRoom = numbersRoom;
    }

    public Integer getNumbersNight() {
        return numbersNight;
    }

    public void setNumbersNight(Integer numbersNight) {
        this.numbersNight = numbersNight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderReference=").append(orderReference);
        sb.append(", hotelName=").append(hotelName);
        sb.append(", targetDate=").append(targetDate);
        sb.append(", channel=").append(channel);
        sb.append(", checkInDate=").append(checkInDate);
        sb.append(", checkOutDate=").append(checkOutDate);
        sb.append(", checkInPerson=").append(checkInPerson);
        sb.append(", floorPrice=").append(floorPrice);
        sb.append(", sellingPrice=").append(sellingPrice);
        sb.append(", grossMargin=").append(grossMargin);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", salesManager=").append(salesManager);
        sb.append(", operation=").append(operation);
        sb.append(", invoiceTitile=").append(invoiceTitle);
        sb.append(", dutyParagraph=").append(dutyParagraph);
        sb.append(", remark=").append(remark);
        sb.append(", proprietaryHotel=").append(proprietaryHotel);
        sb.append(", houseType=").append(houseType);
        sb.append(", numbersRoom=").append(numbersRoom);
        sb.append(", numbersNight=").append(numbersNight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}