package com.lyq.utils;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092800613227";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDVQXRSJMyyIes9kuFXqevSgCm1uuZcryTB2LGemvVqly33QVmrMrStNFhepm2fwxRoLVcPnGMqVgFVVNji7BUC3NVhqsEzQy7cv4KQhxAzfin29mLKa8cxz8AyVmqMs1OCJbYkJBEYkwuQ50WDu4FG8QM4mbTswa3IiLS64KgbdONNkLN6we8adDhXbv117SUMS5UNXkuBKYOGwNxsDideQtdinAgEoE4kZ75P9sfIFjcjvzN7H2LhIOcl5Zrnqn/OaA0VPy59joak5a3T93b4PpfNZz4ohxv0GjKYoJb59wZbXprlbi0VaJAfOPEjpwQrHrp0uMxMaJGHrd2YZV4DAgMBAAECggEBALgKoAeQSLPmv+zIyP7t314wS07R+KK+aFt+1nNJykjuJbZASNGNlg3wod81hGAfbIonrv4C+jX8OXRaID9efReWW/TI96l07omGIXj3hwzZcf/3TPTipOshHv6SQ6wfyw8D2rhABB0QMigg34Y7mOsPbrc3N8QntgHdsROidJIT7rkxk5PqLyn1yrJsU+Q7++NIXl+fj3psvYEvnwo5zZJK3Ubrw0Rci2/vknqjq2LTK8n0wm4YP3IV185980xtAtPHewHZkddcGAIJA2KIqcCSMa9j94oKXt/28qynJy9FLxbYlbgoMEQN92Pfb+Cb/u64j0X7SY06yR+ZX0tYVHkCgYEA/bZIJ3XdlhkFJBMVwmKzPhJlCYqfE143dWtBLJh5qIFETQnuj/1cn0JRMSZxUGz5dxUiDHtdAFhGBZS3Az+LqqP6CG5+F4ALoiKhMwxrZaTOPglznhtCSGQnBUkvg2M12k8NbNmvtVlgb/FzBPqeiGT7TcahBXMYCEnWTRNO838CgYEA1y3GdGBVEahgK9feLcUZZOnLhlr5oUpT0V2Shidt83IDtPGiBWjfrl/BOIHANS85Kcj9GRTd3abKUMevAxS58QVuSmwHMsAEm9EWZDayrgcveGMrIqprqXihqTIMjcg06T2WN1W8KEw6VVX1O2IKsuskiuPqnbB7VtcOy1XQB30CgYA/+Q92i7zE1Sg7sWhCLHr/wsmhP0ffLVmUjOfRI91BRN8BAekae4s4SROJ7iSSX/gDM9vzA8QuixOU4qvG8OX5sAEi0SGQMWQ9jLfS1GXcKlMqx11U15C+CirgpVSKr6BrnJVJBhbNBm1PrLUQ41TIFZZcRSJi6mN764pSwvScZwKBgFuOKYuo1Wle+BSPlARrgcOTSrrPCLoc8w75PngAXOMhlvwtd9/PYKVELuWJJ6w5fJwP3ckHPOOrrRez7v5jmj44LlZSIrnwQ8W8sEdRkrNDcWpK37avRoHkRvzDw92r2v+G6dx/iUCoNoXKvj5XF/BK5tCF63TO+5vWg3/28j3NAoGAW+2dSdy5JBaJ3VlmarAg0wF4h12rm5VdJisYwp89/QKrswET2g8qMIjKLBVvxGr01hm0R5V9i3PNRJcBQa1mUuXyqmLohKbE4Q/500BvfPd3/+X/Vu70ny0svQ2ywtxMORFmCqGXvaTCCFWHL4erPUVLHOMnYdGvPRIvraQqpiA=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1UF0UiTMsiHrPZLhV6nr0oAptbrmXK8kwdixnpr1apct90FZqzK0rTRYXqZtn8MUaC1XD5xjKlYBVVTY4uwVAtzVYarBM0Mu3L+CkIcQM34p9vZiymvHMc/AMlZqjLNTgiW2JCQRGJMLkOdFg7uBRvEDOJm07MGtyIi0uuCoG3TjTZCzesHvGnQ4V279de0lDEuVDV5LgSmDhsDcbA4nXkLXYpwIBKBOJGe+T/bHyBY3I78zex9i4SDnJeWa56p/zmgNFT8ufY6GpOWt0/d2+D6XzWc+KIcb9BoymKCW+fcGW16a5W4tFWiQHzjxI6cEKx66dLjMTGiRh63dmGVeAwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8081/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8081/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关https://openapi.alipay.com/gateway.do
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\zifub\\src";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
