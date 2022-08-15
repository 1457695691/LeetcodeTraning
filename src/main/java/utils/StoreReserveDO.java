package utils;

import java.util.Date;

/**
 * The table 门店预约库存
 */
public class StoreReserveDO{

    /**
     * id ID.
     */
    private Long id;
    /**
     * itemId 暂时为null.
     */
    private Long itemId;
    /**
     * storeId STORE_ID.
     */
    private Long storeId;
    /**
     * merchantId 机构id.
     */
    private Long merchantId;
    /**
     * itemName 暂时为null.
     */
    private String itemName;
    /**
     * storeName STORE_NAME.
     */
    private String storeName;
    /**
     * merchantName MERCHANT_NAME.
     */
    private String merchantName;
    /**
     * todayWorkTime 格式：
     [
     {"start":"08:30","end":"12:00"},
     {"start":"13:00","end":"18:00"},
     ].
     */
    private String todayWorkTime;
    /**
     * status 0=正常 1=删除.
     */
    private Integer status;
    /**
     * reserveNum 当天库存总数.
     */
    private Integer reserveNum;
    /**
     * workStatus 0=工作 1=歇业.
     */
    private Integer workStatus;
    /**
     * reserveSurplus 当天剩余库存.
     */
    private Integer reserveSurplus;
    /**
     * gmtCreate 订单创建时间.
     */
    private Date gmtCreate;
    /**
     * gmtModified GMT_MODIFIED.
     */
    private Date gmtModified;
    /**
     * reserveDate 时间.
     */
    private Date reserveDate;

    /**
     * Set id ID.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set itemId 暂时为null.
     */
    public void setItemId(Long itemId){
        this.itemId = itemId;
    }

    /**
     * Get itemId 暂时为null.
     *
     * @return the string
     */
    public Long getItemId(){
        return itemId;
    }

    /**
     * Set storeId STORE_ID.
     */
    public void setStoreId(Long storeId){
        this.storeId = storeId;
    }

    /**
     * Get storeId STORE_ID.
     *
     * @return the string
     */
    public Long getStoreId(){
        return storeId;
    }

    /**
     * Set merchantId 机构id.
     */
    public void setMerchantId(Long merchantId){
        this.merchantId = merchantId;
    }

    /**
     * Get merchantId 机构id.
     *
     * @return the string
     */
    public Long getMerchantId(){
        return merchantId;
    }

    /**
     * Set itemName 暂时为null.
     */
    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    /**
     * Get itemName 暂时为null.
     *
     * @return the string
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * Set storeName STORE_NAME.
     */
    public void setStoreName(String storeName){
        this.storeName = storeName;
    }

    /**
     * Get storeName STORE_NAME.
     *
     * @return the string
     */
    public String getStoreName(){
        return storeName;
    }

    /**
     * Set merchantName MERCHANT_NAME.
     */
    public void setMerchantName(String merchantName){
        this.merchantName = merchantName;
    }

    /**
     * Get merchantName MERCHANT_NAME.
     *
     * @return the string
     */
    public String getMerchantName(){
        return merchantName;
    }

    /**
     * Set todayWorkTime 格式：
     [
     {"start":"08:30","end":"12:00"},
     {"start":"13:00","end":"18:00"},
     ].
     */
    public void setTodayWorkTime(String todayWorkTime){
        this.todayWorkTime = todayWorkTime;
    }

    /**
     * Get todayWorkTime 格式：
     [
     {"start":"08:30","end":"12:00"},
     {"start":"13:00","end":"18:00"},
     ].
     *
     * @return the string
     */
    public String getTodayWorkTime(){
        return todayWorkTime;
    }

    /**
     * Set status 0=正常 1=删除.
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * Get status 0=正常 1=删除.
     *
     * @return the string
     */
    public Integer getStatus(){
        return status;
    }

    /**
     * Set reserveNum 当天库存总数.
     */
    public void setReserveNum(Integer reserveNum){
        this.reserveNum = reserveNum;
    }

    /**
     * Get reserveNum 当天库存总数.
     *
     * @return the string
     */
    public Integer getReserveNum(){
        return reserveNum;
    }

    /**
     * Set workStatus 0=工作 1=歇业.
     */
    public void setWorkStatus(Integer workStatus){
        this.workStatus = workStatus;
    }

    /**
     * Get workStatus 0=工作 1=歇业.
     *
     * @return the string
     */
    public Integer getWorkStatus(){
        return workStatus;
    }

    /**
     * Set reserveSurplus 当天剩余库存.
     */
    public void setReserveSurplus(Integer reserveSurplus){
        this.reserveSurplus = reserveSurplus;
    }

    /**
     * Get reserveSurplus 当天剩余库存.
     *
     * @return the string
     */
    public Integer getReserveSurplus(){
        return reserveSurplus;
    }

    /**
     * Set gmtCreate 订单创建时间.
     */
    public void setGmtCreate(Date gmtCreate){
        this.gmtCreate = gmtCreate;
    }

    /**
     * Get gmtCreate 订单创建时间.
     *
     * @return the string
     */
    public Date getGmtCreate(){
        return gmtCreate;
    }

    /**
     * Set gmtModified GMT_MODIFIED.
     */
    public void setGmtModified(Date gmtModified){
        this.gmtModified = gmtModified;
    }

    /**
     * Get gmtModified GMT_MODIFIED.
     *
     * @return the string
     */
    public Date getGmtModified(){
        return gmtModified;
    }

    /**
     * Set reserveDate 时间.
     */
    public void setReserveDate(Date reserveDate){
        this.reserveDate = reserveDate;
    }

    /**
     * Get reserveDate 时间.
     *
     * @return the string
     */
    public Date getReserveDate(){
        return reserveDate;
    }
}
