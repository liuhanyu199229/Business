package com.formssi.third.util;

import com.formssi.third.common.constants.RedisKeyConstant;
import com.formssi.third.security.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * \* User: layne
 * \* Date: 2020/6/2
 * \* Time: 11:32
 * \* Description: code编码生成工具
 * \* 利用redis自增功能实现
 * \
 */
public class GenerateCode {

    @AllArgsConstructor
    @Getter
    public enum CodeTypeEnum {
        //商品
        GOODS(RedisKeyConstant.FORMSSI_GOODS_CODE, "W", 6, true, "商品code"),
        //门店组
        GROUP(RedisKeyConstant.FORMSSI_GROUP_CODE, "M", 5, true, "门店组code"),
        //门店
        SHOP(RedisKeyConstant.FORMSSI_SHOP_CODE, "M", 10, true, "门店code"),
        //商品图片
        GOODS_IMAGE(RedisKeyConstant.FORMSSI_GOODS_IMAGE_CODE, "W", 6, true, "商品图片"),
        //门店组图片
        GROUP_IMAGE(RedisKeyConstant.FORMSSI_GROUP_IMAGE_CODE, "P", 5, true, "门店组图片"),
        //商品库存批次
        GOODS_BATCH(RedisKeyConstant.FORMSSI_GOODS_BATCH_CODE, "", 6, true, "商品库存批次code"),
        //商品优惠券库存编码
        GOODS_STOCK(RedisKeyConstant.FORMSSI_GOODS_STOCK_CODE, "", 10, false, "商品优惠券库存code"),
        //券状态变更excel编码
        COUPON_FILE_CODE(RedisKeyConstant.FORMSSI_GOODS_COUPON_FILE_CODE, "", 6, false, "券状态变更EXCEL");

        //code编码库
        private String database;
        //code编码前缀
        private String prefix;
        //code编码长度
        private Integer length;
        //是否包含商户编码
        private Boolean hasBusinessCode;
        //描述
        private String desc;


    }

    private RedisService redisService;

    private GenerateCode() {
    }

    private final static GenerateCode INSTANCE = new GenerateCode();

    public static GenerateCode getInstance() {
        return INSTANCE;
    }

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    /**
     * 获取code编码(利用redis)
     *
     * @param codeTypeEnum 编码类型枚举
     * @param sourceCode   原编码
     * @param delta        递增步长
     * @return code编码
     */
    public String getCode(CodeTypeEnum codeTypeEnum, String sourceCode, long delta) {
        String resultCode = null;
        switch (codeTypeEnum) {
            case GOODS_IMAGE:
                resultCode = sourceCode;
            case GROUP_IMAGE:
                resultCode = sourceCode.replaceFirst("M", "P");
                break;
            case GOODS:
            case GROUP:
            case SHOP:
            case GOODS_BATCH:
            case GOODS_STOCK:
            case COUPON_FILE_CODE:
                String codePrefix = codeTypeEnum.getPrefix() + sourceCode;
                String key = codeTypeEnum.getDatabase() + codePrefix;
                Long increment = this.redisService.incr(key, delta);
                if (increment.toString().length() <= codeTypeEnum.getLength()) {
                    resultCode = codePrefix + String.format("%0" + codeTypeEnum.getLength() + "d", increment);
                } else {
                    resultCode = codePrefix + increment.toString();
                }
                break;
            default:

                break;

        }
        return resultCode;
    }

    /**
     * 获取code编码(利用redis)
     *
     * @param codeTypeEnum 编码类型枚举
     * @param sourceCode   原编码
     * @return code编码
     */
    public String getCode(CodeTypeEnum codeTypeEnum, String sourceCode) {
        return getCode(codeTypeEnum, sourceCode, 1);
    }

    /**
     * 获取code编码(利用redis)
     *
     * @param codeTypeEnum 编码类型枚举
     * @param delta        递增步长
     * @return
     */
    public String getCode(CodeTypeEnum codeTypeEnum, long delta) {
        return getCode(codeTypeEnum, "", delta);
    }

    /**
     * 获取code编码(利用redis) 不需要关系商户
     *
     * @param codeTypeEnum 编码类型枚举
     * @return
     */
    public String getCode(CodeTypeEnum codeTypeEnum) {
        return getCode(codeTypeEnum, "");
    }

    /**
     * 设置code编码索引(利用redis)
     *
     * @param codeTypeEnum 编码类型枚举
     * @param businessCode 商户编码
     * @param index        索引值
     */
    public void setCodeIndex(CodeTypeEnum codeTypeEnum, String businessCode, Long index) {
        String codePrefix = codeTypeEnum.getPrefix() + businessCode;
        String key = codeTypeEnum.getDatabase() + codePrefix;
        this.redisService.set(key, index);
    }


    /**
     * 返回编码序列值(利用redis)
     *
     * @param codeTypeEnum 编码类型枚举
     * @param businessCode 商户编码
     * @return 序列值
     */
    public Long getCodeIndex(CodeTypeEnum codeTypeEnum, String businessCode) {
        String codePrefix = codeTypeEnum.getPrefix() + businessCode;
        String key = codeTypeEnum.getDatabase() + codePrefix;
        Integer index = (Integer) this.redisService.get(key);
        return Long.parseLong(index.toString());
    }

    /**
     * 返回编码序列值(利用redis)
     *
     * @param codeTypeEnum 编码类型枚举
     * @return 序列值
     */
    public Long getCodeIndex(CodeTypeEnum codeTypeEnum) {
        return getCodeIndex(codeTypeEnum, "");
    }

    /**
     * 根据code编码返回编码序列号
     *
     * @param codeTypeEnum 编码类型枚举
     * @param businessCode 商户编码
     * @param code         编码
     * @return 序列值
     */
    public Long getCodeIndexByCode(CodeTypeEnum codeTypeEnum, String businessCode, String code) {
        long maxCount = 0;
        switch (codeTypeEnum) {
            case GOODS:
            case GROUP:
            case SHOP:
            case GOODS_BATCH:
            case GOODS_STOCK:
                if (StringUtils.isNotBlank(code)) {
                    if (codeTypeEnum.getHasBusinessCode()) {
                        maxCount = Long.parseLong(code.substring(codeTypeEnum.getPrefix().length() + businessCode.length()));
                    } else {
                        maxCount = Long.parseLong(code.substring(codeTypeEnum.getPrefix().length()));
                    }
                }
                break;
            case GOODS_IMAGE:
            case GROUP_IMAGE:
                if (StringUtils.isNotBlank(code)) {
                    maxCount = Long.parseLong(code.substring(codeTypeEnum.getPrefix().length() + businessCode.length(), code.lastIndexOf(".")));
                }
                break;
            default:
                break;
        }
        return maxCount;
    }

    /**
     * 根据编码返回序列号
     *
     * @param codeTypeEnum 编码类型枚举
     * @param code         编码
     * @return 序列值
     */
    public Long getCodeIndexByCode(CodeTypeEnum codeTypeEnum, String code) {
        return getCodeIndexByCode(codeTypeEnum, "", code);
    }

    /**
     * 根据序列号获取编码
     *
     * @param codeTypeEnum 编码类型枚举
     * @param sourceCode   原编码
     * @param index        序列号
     * @return 编码
     */
    public String getCodeByIndex(CodeTypeEnum codeTypeEnum, String sourceCode, Long index) {
        String resultCode = null;
        switch (codeTypeEnum) {
            case GOODS_IMAGE:
                resultCode = sourceCode;
            case GROUP_IMAGE:
                resultCode = sourceCode.replaceFirst("M", "P");
                break;
            case GOODS:
            case GROUP:
            case SHOP:
            case GOODS_BATCH:
            case GOODS_STOCK:
                String codePrefix = codeTypeEnum.getPrefix() + sourceCode;
                if (index.toString().length() <= codeTypeEnum.getLength()) {
                    resultCode = codePrefix + String.format("%0" + codeTypeEnum.getLength() + "d", index);
                } else {
                    resultCode = codePrefix + index.toString();
                }
                break;
            default:
                break;
        }
        return resultCode;
    }

    /**
     * 根据序列号获取编码
     *
     * @param codeTypeEnum 编码类型枚举
     * @param index        序列号
     * @return 编码
     */
    public String getCodeByIndex(CodeTypeEnum codeTypeEnum, Long index) {
        return getCodeByIndex(codeTypeEnum, "", index);
    }


}
