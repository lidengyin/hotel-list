package cn.hctech2006.hotellist.bean;

import java.io.Serializable;

public class NlHotel implements Serializable {
    private Integer id;

    private String hotelId;

    private String hotelReference;

    private String hotelCity;

    private String hotelAddress;

    private String hotelPhone;

    private String abutManager;

    private String abutManagerPhone;

    private String salesManager;

    private String operation;

    private String hotelStatus;

    private String contract;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelReference() {
        return hotelReference;
    }

    public void setHotelReference(String hotelReference) {
        this.hotelReference = hotelReference;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getAbutManager() {
        return abutManager;
    }

    public void setAbutManager(String abutManager) {
        this.abutManager = abutManager;
    }

    public String getAbutManagerPhone() {
        return abutManagerPhone;
    }

    public void setAbutManagerPhone(String abutManagerPhone) {
        this.abutManagerPhone = abutManagerPhone;
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

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hotelId=").append(hotelId);
        sb.append(", hotelReference=").append(hotelReference);
        sb.append(", hotelCity=").append(hotelCity);
        sb.append(", hotelAddress=").append(hotelAddress);
        sb.append(", hotelPhone=").append(hotelPhone);
        sb.append(", abutManager=").append(abutManager);
        sb.append(", abutManagerPhone=").append(abutManagerPhone);
        sb.append(", salesManager=").append(salesManager);
        sb.append(", operation=").append(operation);
        sb.append(", hotelStatus=").append(hotelStatus);
        sb.append(", contract=").append(contract);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}