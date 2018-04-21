package com.kimigayo.excel;

import java.util.Date;

public class Bill {
    private String merchantId;
    private Date createAt;
    private String merchantDealId;
//    private String platformDealId;
//    private String merchantRefundId;
//    private String platformRefundId;
//    private String refundAmount;
//    private String state;
//    private String payChannel;
//    private String merchantNam;
//    private String belongChannel;
//    private String merchantShortName;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getMerchantDealId() {
        return merchantDealId;
    }

    public void setMerchantDealId(String merchantDealId) {
        this.merchantDealId = merchantDealId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "merchantId='" + merchantId + '\'' +
                ", createAt=" + createAt +
                ", merchantDealId='" + merchantDealId + '\'' +
                '}';
    }
}
