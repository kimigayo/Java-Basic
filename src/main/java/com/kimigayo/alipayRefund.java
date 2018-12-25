package com.kimigayo;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;

public class alipayRefund {
    public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "2018110662023424", "MIIEugIBADANBgkqhkiG9w0BAQEFAASCBKQwggSgAgEAAoIBAQCANTLRmHfxjaSdbKl4FcSw2I2/0M7YLloRdVhd0OGhhza3oK8Yx3YI+AzeINskbe8sP/opdar/A0sqIioREnqZ+zTMUtT0S7wbPER6AN40kc8a1X3ToxUMmC3Iu4oVz6dTwfwFvwWRhTUCR8jx6J4BM/burjxDkNsvjRg1fDko6Cef0uIWNxOwF+Jw0C2lUND7lZq3mauougAb1oRn6S78iG5nWo31ySANskAUH8WShjfAOMqg6FPoG1N4xV1DTMNiVFVHCLoUj35Gp05XIXv/AZmQUcxF0dH63kMvUdoV9s1NWKO4mmQYJU/o65u1/+kOCwc8R6T/n1mcz0qb9LjPAgMBAAECggEAUh5A+6D2CoEYFEE6VxFSV5eNS3Q6WJtv00jfHdAiBS0vLfS80llH0DzZORnAY5gKnsQnvpCAwzBf34/cc+zrHF+blNflUMiFpsg2cBLIQNG33s8p9fm6DMQYZz9AFfJYkbxpaWDN90RkDJ7gJZpCQjD/lCeDsB9DVTTBcdisX/dPnWHJfYDhli8kPjL/EYn8mw4II9CTgKYKCuwFSHMG26VTMpStQa3SL8hRRXn3NLp2Z2nXFZK6i1hhsc7b4UVgQCcj0pPyQjrDy4N8jep/lMqFV0McGNVTHwGWG8vx7i6XjIcHDJG6n/HpFeNLAeg6/5WY+OndoC/c7OlGc3mUoQKBgQDWzzcO3Y2+auf9jLfisMWKN3Wlg4kJbYFzQ4NjceL8n2nm3q9uRzyjku//nv25GkfJJuSgdIpWY3IPwmAGFIV6AnN94cND4M5B4pfiZ/kKm2D8+76i3L79ZHe9hUr3L2xxE14ClNBWoydmoyvAobOInsFp7z9kv/lDmWN0zBkvMQKBgQCYystXAoQZyMo6a+WFP4/0AhauQnJ4pM1hunKJAYlTlB8HzLq2dG3JbX3G0QsQqtoV0QzL0EeeuLHYTyyPAJFnCncfaMkYLFhMKor3WGHs0pcjxmQxxZ3tU9FntKNaZTLaeO/t1PXdEqe1J7378Xx4fRdSev36SRFutmONFoJn/wKBgHtMwfvEbIIqdzNwvHRgp2Lo5py03coNk0qILDi+vF3pWy5sECKqvUHfK+d8aYMAdMgfjQgVHPrtZiFpnxieWudn1Mci+aRSu9HRsQECUU8nVQqhrhFpyC9GpfyhMCCmlgZp6YJtzRCN4iXl701JA/aducOG0sqP7xJAT3hRVvthAn9TjpOlAbs8XpI5YMgkFp6i0oGUysHPOFEZIN2CD1UKX/aYTV3Oad2gSkB+edOTSdv6EljtHPoN0vNvV90GV0ktEIwUoTlX/uhKvvlASxVCbeg5qEUi8u9q2muqSx8KUE1/LKQJbG0IeSs95n3/ShDH06DtelVqior+AMBwZ97pAoGAHuzjFMiWDRBSJynGxz6iyRs7nyyXaUsc1bKjfIoIPVO2EVeReJvbZ8CatB5ezYd5TqLGYG30doN/XfXJax7FhsyrFBAx/h7Q+z6yE8y1dOpzcRt5ZkKy+IQYXfxj8+1NdLEP0mwy3EWggaVkUydqUxwL6lSZr2Z3vDaC5Ll56T0=", "json", "utf-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAinrwg5afTMMJF2MR+4H2njMDkbv7GK07e2aA/Q6GwCPZnWIWm/xYfgC3XTcVxOKeoGQJ0rssZpLQszsrOx3qxRnT73rxU/Mc8fH9NEJs07SM1yiSe35Wjpcjg7eOuD+ZBMdp8ETwl/GWw4jgHl2ON2rfDXmLHZeyNPSgCw5uHU0rYy73baz3iYVoZXdHOpZMrcpq2RIbh9Cow8oqJ0d/6F50wVNqcPWxj/mTEzpxTYhnRfYlfnW9TH0YcLpLCKtJ7f5YxaloNIfWhdaPFNl+QKAM7o5MhKUNyC0TdRR+jo3EOg5UT4vhn4piC3FQ63xMa6eM5VbVEtfTGuHh1+d2XwIDAQAB", "RSA2");
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"UP201811161701472312\"," +
                "\"trade_no\":\"UP201811161701472312\"," +
                "\"refund_amount\":0.01," +
                "\"refund_reason\":\"正常退款\"," +
                "\"out_request_no\":\"zdtUP201811161701472312\"" +
                "  }");
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        System.out.println(JSON.toJSONString(response));
    }
}
