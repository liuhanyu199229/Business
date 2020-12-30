package com.formssi.third.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 生成随机数辅助类
 * @author LUOWENYAN
 * @date 2020-08-04 10:11
 */
public class RandomUtil {

    /**
     * 获取随机的流水号(10位)
     * @return
     */
    public static String getRandomReqNo() {
        int length=10;
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer stockCount = 10;
        Set couponSet = new HashSet();
        Set couponSet1 = new HashSet();
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        while (true){
            System.out.println("couponSet.size()"+couponSet.size());
            if(couponSet.size()>=stockCount.intValue()){
                break;
            }
            //三方商户标识（4）+动态生成10位（10）+雪花算法取18位（18）全局唯一
            //获取三方商户标识
            String businessCode = "CSYH";
            //获取10位随机数
            String randomReqNo = RandomUtil.getRandomReqNo();
            //雪花算法取18位
            long snowflakeId = idWorker.nextId();
            couponSet1.add(snowflakeId);
            //拼接成一个字符串
            String couponCodeStr = new StringBuffer(businessCode).append(randomReqNo).append(snowflakeId).toString();
            System.out.println(couponCodeStr);
            System.out.println(new StringBuffer(businessCode).append("-").append(randomReqNo).append("-").append(snowflakeId).toString());
            System.out.println(couponCodeStr.length());
            couponSet.add(couponCodeStr);
        }
        System.out.println("---------couponSet.size():"+couponSet.size());
        System.out.println("---------couponSet1.size():"+couponSet1.size());
    }
}
