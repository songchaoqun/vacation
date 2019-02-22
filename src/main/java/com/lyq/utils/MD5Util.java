/** 
 * <pre>项目名称:goods_cht 
 * 文件名称:MD5Util.java 
 * 包名:com.jk.cht.util 
 * 创建日期:2018-6-22上午12:33:12 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.lyq.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * <pre>项目名称：goods_cht    
 * 类名称：MD5Util    
 * 类描述：    
 * 创建人：柴华通 cht_java@126.com    
 * 创建时间：2018-6-22 上午12:33:12    
 * 修改人：柴华通 cht_java@126.com  
 * 修改时间：2018-6-22 上午12:33:12    
 * 修改备注：       
 * @version </pre>    
 */
public class MD5Util {
	
	/**
	 * 
	 * 方法: getMd532 <br>
	 * 描述: 32位md5加密 <br>
	 * 作者: Teacher song<br>
	 * 时间: 2017年6月27日 下午2:27:38
	 * @param plainText
	 * @return
	 */
	public static String getMd532(String plainText) {
	    try {  
	        MessageDigest md = MessageDigest.getInstance("MD5");  
	        md.update(plainText.getBytes());  
	        byte b[] = md.digest();  
	        int i;
	        StringBuffer buf = new StringBuffer("");  
	        for (int offset = 0; offset < b.length; offset++) {  
	            i = b[offset];  
	            if (i < 0)  
	                i += 256;  
	            if (i < 16)  
	                buf.append("0");  
	            buf.append(Integer.toHexString(i));  
	        }  
	        //32位加密  
	        return buf.toString();  
	        // 16位的加密 
	        //return buf.toString().substring(8, 24);  
	    } catch (NoSuchAlgorithmException e) {  
	        e.printStackTrace();  
	        return null;  
	    }  
	}  
	
	 /** 
     * 对字符串md5加密(小写+字母) 
     * 
     * @param str 传入要加密的字符串 
     * @return  MD5加密后的字符串 
     */  
    public static String getMD5(String str) {  
        try {  
            // 生成一个MD5加密计算摘要  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            // 计算md5函数  
            md.update(str.getBytes());  
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符  
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值  
            return new BigInteger(1, md.digest()).toString(16);  
        } catch (Exception e) {  
           e.printStackTrace();  
           return null;  
        }  
    }  
      
      
    /** 
     * 对字符串md5加密(大写+数字) 
     * 
     * @param str 传入要加密的字符串 
     * @return  MD5加密后的字符串 
     */  
      
    public static String MD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
  
        try {  
            byte[] btInput = s.getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
         public static void main(String[] args) {  
        	  String md5 = MD5(MD5("cht"));  
             // String md52 = getMD5("cht"); 
              System.out.println(md5);
    }  
}
