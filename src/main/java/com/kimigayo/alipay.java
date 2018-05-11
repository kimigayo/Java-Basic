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
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDHkuMA/GQWIDle9IpjKlvmpzdUgQdBSV9DS99Ne4y2djf5cvTyYNz/n4GouD/MGnOeyoQxxFVQGPyeb68lj8jgKHiqKsSc6HWOcQ1859gmyShgZ4gI7lb5QHWrPuy9wC3tvDbJ97DS0wwbIuupZbbU8OzhEocngGH+yk/2ChgurOgBl9xIOVm0sZCCAWKwl6EryAJGnecdBxfwdrvNc20tYW4tLA1eGWgB9BV0DUJ5FIlmjo/GpyM8oBu04zV8t9f2Wj4MpaAV15rcJwSmwnxfbgWCUCURkIFwr2uH88enmEJNii2ugdY2v9VsWnypti8QEe3ruEdbrxRrvTCYUtLPAgMBAAECggEAPWzFN4l3GKREZChp64mfDYfL7NNlsz9s9Z6FlSiAr6wFIF60a2FKw9aJJq/G2wANNANq2pJuG6AFKJKBWtM9ZVivgth0+UJG5FeBaj9FdPKW3c0fvnf1BvRDAzjzzpc2y6QRTOpSXyEb6cI+vD2VH0cj8UYtmQfXoX8NS1HiDYMZI9FQrTR77i/MkPH68In3JwJVIPnCuPm3sjLqRVqM/QOrP4qx0nWBEki9CsTEH3QRwWjkC4PKrAVrkrXWm7rjKmyiXXuSacyTwVnmpO6UePRnHLt8rgnICZEEHSlZ83h8ebBqDX42mpbrAjJoeiJ3ZvbjXciueqjrOuBb5ICJaQKBgQDkZjM2udyW0zilrZBu+TbVqza5bsrHHl3TfIRx3H/qgV0NekyNRlaCA9H6xAB9q6J7sWujyKyd9P41szRcfaQPk40f1ZgRKybsVVQmoQnzESCNHpfGatrh0UQP7iycfSJAEAcC+vKy3pYsizbdT6ikgf3b3SrVppcSDKJkIkjnrQKBgQDfsPABctUc59jN/D9a6rqkUuw64OaIunBZqVTvDdbchT+7hC6J0AMfkGEwgrfjtBkiY3ve5uuUk0+CrmvvH4XrK1rLuAmP0CpCWGcQ2peih550LJsskF3ZJhnLLpes9saTM0JRCycED/eIjYJ4WAxhJl9grA2jNmo9IryKu8+j6wKBgQDIYu5N9nWWEo1htszAwIAeqQ/jU1QvrPHO6jFdoILOIV+dwo5FaM/fVDC3XZ28pIhzE6+HzDm+gENEpAytlUIKtH8dzg2UCpMkyJyDI8kR7BXuGkg5Omj9tNeNTn7vcU5KfIVaVQf4bRe+zwl81DX212H9s6awOm/S0yjqx7XFJQKBgGuuBRrtaGFtyhP+ZZEihY4szMLbGJ6hAQxoUxZwlwm4qyFdU/nLRHWhTufHRTY7sA25zhtTFfyDnTbPN+34QsMeL6r5gMDV+EHPxG18jJoUptZN0rT1Gfg6Oxhv6Vu9v4GEn1vb/oAaH5KAbFn6KJtrmWYz7KywuRuM6S3vktjZAoGBAKEgEw8Y0tw8JanCYKzFWEigfyeGAyDhA4GmOTv6Sa0wR2R210s4jLsyyWwxFd/L8v7KuB5l1DNk2ic9zc7Z8J6ZVO4IwrGIISVZCNbqCzy+WGTr3QRq0US6+puBsygDUBXtIX5+vsb9C8hBNDUN7luNQIy2Oh5NY0VHC0TJSvuD", "json", "utf-8", "", "RSA2");
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizContent("{" +
                "\"bill_type\":\"trade\"," +
                "\"bill_date\":\"2018-05-09\"" +
                "  }");
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            String urlStr = response.getBillDownloadUrl();
            //指定希望保存的文件路径
            String filePath = "\\fund_bill_20180509.csv.zip";
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
