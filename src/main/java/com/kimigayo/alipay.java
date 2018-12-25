package com.kimigayo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class alipay {
    public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016091500517233", "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDSLumyqYcjelQcMO4u68v5sFL7hHYSjjG6iNcZH+wnDmugh79jcfMUm/s0HnbHn1phPVZLoRF1EqBgwxMTVS+fwGHZHGOcC/ksx1FZFDaBWrTRb0JFNdf5yDpSl+RgaUpomBUwQYnGmQW+TUZ/qAU6YwvHlyUPWdwccwR3Vuat+leffEyRWV2fONDfMxWm/nn17C6OVPq4wvEazJPWp6C/TNWkCn3ivoGgYHj0di7OxOfZGmtgxZ1edXSbIjx+AohYAT05bvbBdSim/VmoUFCacz5N5icZWuaC3Lp8vu8iBlKItyiDZ/iYGUgVmzaD47DZ5GZmUKzM7Wk0xt6EJeKDAgMBAAECggEALC5QUY3xKjP8mjBu4M4QAlxeFSCy8ROSwHMjQ9TB/zO4y/W89VpujlZ7Z2k/7pZAmVAbY6pn0QQpUi2vRNETQbFe4BRnm9WoexEquF7XVjmK6LtKYuH+lDLSj6n+B4YabgIJ8irUmzpvSqFTwGHBN5S6VSogUCnDaveCaNOLieZD5lcWQxte5kx5cP1t3o4FpBqgcOWttzeBFaawfyMdn27htBaTy/RMf3T5F9WWWF6g/duYct7018+WTX+PN3ZmO/IKjYp0xOaa8BoQg5O9mk+XGe/bZ9iNFvWkwiJFQ0SGT80CWpSj26f/eobglOQrlj477nAXQNBbe8nKa9J8AQKBgQD4QqTS2/K++sA9kFoOqc4saMUKdj1jJJpkfV8YN5s1Ir8PkaRM2cNfve9wildavyJMBJXQesdI99QGZdVDyvMVrYCkwhKqoJROLeMXbBjzAYJbJw/88rZdRMilzKNi6Qwvs8ASlZvhy8DHjlEo0rpPix70nZ2gpL4VGGJNPYrLYQKBgQDYvGCbaiV3qVBw3XAXaq6W87nv2PHbbWieNdAU70KYKdmSSA/R18V0xPqJg7cYL/ObAOIle2mFobd3xuH+g/phYJxseCjRC9qczSdUaoU+agPj3dybSj+mY8nUBees02f4O8d5GHuKwDt0SoQfnEKk57aJodLBgrqMFJB07N68YwKBgCGMH+m+fxb/m2q2TvUcTRgDMF0xjSoQkCx0JJ2JJhgQEfFwpNsdsiEF8Y0rpJJGscPD+tqpPLTHiIc0y5TVn/OV9oRNFWipOmE2IjHQEa8EzTC0Hpz3z1zbJqIA/TMoetUXXSUlwmLIvcw5lw4FK9gD3LMBeYNzv5vqJ554aoEBAoGAYFJoBOoJuMKQs3hWRrHs4b1z1zptUn2vTxDPZ15mFEYVIcPQ9AuW/6xDRDY7ew5kj3C3EL1mSjNy3FKRQZHaBsju++3zBeTkxWcPoZ6tlO18yRpi3skCvKoAmq/9JHvX6yR2JEVTMnj4c1him8HQhIVORKCcj8/PpE3HXY+f9c0CgYB0Lz57kDI9kogUI4n4AJ3eCUFZL/XIfSMD8c+OlhrXYqqTd6VaLg1afdABZDRDAbPZ0sNrDFeB6rcMHMleaJ7aLIPtI2RBNAlBLYbHFJAbsCLKCepa7SRyaB7lfhChYc3RtbjAx3bnvN0Go109KoVu3tnwN6J/N7LiUGZ9Yu63Fw==",
                "json", "utf-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvRGLzHKpb2KiOBNv1qDVYnaH+hsfBll0JHjcbQPH6sIopKhlxCd8LHYAFE81X+rDPy7XiEHix+3MUN9X+5a9HJhDejxolWjSi4XJXxtyt4Y9txgeHKCgwKT9SP6co/gxWo/jnlKfIFhCjd5Din4gVFWnUO/JvaoEkao/8u8KuHQyK7OoklIOpKf/1extu4+IbujokEmRiafNaTYgzfeHigW4r0ANzx7pWAWhovA/rMmexwXfA0CjX1Wcli7psxkBPuH7N0Hdqc2M/eEWHCp4N++7HQ1pNVdoU2YZlmPmVaftOARupbfSSUj8ISL00orI232U8NgF9z2fZbpnohQ4owIDAQAB", "RSA");
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizContent("{" +
                "\"bill_type\":\"trade\"," +
                "\"bill_date\":\"2018-05-09\"" +
                "  }");
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            String urlStr = response.getBillDownloadUrl();
            //指定希望保存的文件路径
            String filePath = "\\fund_bill_20180509.zip";
            URL url = null;
            HttpURLConnection httpUrlConnection = null;
            InputStream fis = null;
            FileOutputStream fos = null;
            try {
                url = new URL(urlStr);
                httpUrlConnection = (HttpURLConnection) url.openConnection();
                httpUrlConnection.setConnectTimeout(5 * 1000);
                httpUrlConnection.setDoInput(true);
                httpUrlConnection.setDoOutput(true);
                httpUrlConnection.setUseCaches(false);
                httpUrlConnection.setRequestMethod("GET");
                httpUrlConnection.setRequestProperty("CHARSET", "UTF-8");
                httpUrlConnection.connect();
                fis = httpUrlConnection.getInputStream();
                byte[] temp = new byte[1024];
                int b;
                fos = new FileOutputStream(new File(filePath));
                while ((b = fis.read(temp)) != -1) {
                    fos.write(temp, 0, b);
                    fos.flush();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) fis.close();
                    if (fos != null) fos.close();
                    if (httpUrlConnection != null) httpUrlConnection.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("调用失败");
        }
    }
}
