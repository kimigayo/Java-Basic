package com.zoe.phip.vcard.pay.wxpay.service;


import com.zoe.phip.vcard.pay.wxpay.imp.WXPayConfigImpl;
import com.zoe.phip.vcard.pay.wxpay.sdk.WXPay;

import java.io.*;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class TestWXPay {


    private WXPay wxpay;
    private WXPayConfigImpl config;
//    private String out_trade_no;
//    private String total_fee;

    public TestWXPay() throws Exception {
        config = WXPayConfigImpl.getInstance();
        wxpay = new WXPay(config);
//        total_fee = "1";
//        out_trade_no = "201613091059590000003433-asd002";
    }

    public String doDownloadBill() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("bill_date", "20180402");
        data.put("bill_type", "ALL");
        InputStream fis = null;
        FileOutputStream fos = null;
        String result = "";
        try {
            Map<String, String> r = wxpay.downloadBill(data);
            System.out.println(r);
            if ("SUCCESS".equals(r.get("return_code"))) {
                String path = "wxpay";
                String fileName = "20180402_ALL.csv";
                String filePath = path + "/" + fileName;
                File targetFile = new File(path);
                if (!targetFile.exists()) {
                    boolean mkdirs = targetFile.mkdirs();
                }
                fis = new ByteArrayInputStream(r.get("data").replaceAll("`","").getBytes());
                byte[] temp = new byte[1024];
                int b;
                fos = new FileOutputStream(new File(filePath));
                while ((b = fis.read(temp)) != -1) {
                    fos.write(temp, 0, b);
                    fos.flush();
                }
                result ="成功";
            }else{
                result = "请求账单失败";
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            result = e.getMessage();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("--------------->");
        TestWXPay dodo = new TestWXPay();
        // dodo.doGetSandboxSignKey();

        // dodo.doUnifiedOrder();
        // dodo.doOrderQuery();
        dodo.doDownloadBill();
        // dodo.doShortUrl();
        // dodo.test001();
        // dodo.doOrderQuery();
        // dodo.doOrderClose();
        // dodo.doRefund();
        // dodo.doRefundQuery();
        // dodo.doOrderReverse();
        // dodo.test001();
        // dodo.testUnifiedOrderSpeed();

//        dodo.doOrderQuery();
//        dodo.doOrderReverse();
//        dodo.doOrderQuery();
//        dodo.doOrderReverse();
//        dodo.doOrderQuery();


        System.out.println("<---------------"); // wx2016112510573077
    }
}
