package com.formssi.third.common.constants;

/**
 * 缓存key前缀定义,避免key重复
 */
public final class RedisKeyConstant {

    /**
     * 商品
     */
    public static final String FORMSSI_GOODS = "formssi:goods:";

    /**
     * 商品提交
     */
    public static final String FORMSSI_GOODS_SUBMIT = "formssi:goods:submit:";

    /**
     * 商品立即提交次数统计
     */
    public static final String FORMSSI_GOODS_SUBMIT_COUNT = FORMSSI_GOODS_SUBMIT + "count:";

    /**
     * 商品定时任务提交次数统计
     */
    public static final String FORMSSI_GOODS_RUNNER_COUNT = "formssi:goods:runner:count:";

    /**
     * 商品一级分类
     */
    public static final String FORMSSI_GOODS_MAIN_CATEGORY = FORMSSI_GOODS + "category:";

    /**
     * 商品编码
     */
    public static final String FORMSSI_GOODS_CODE = FORMSSI_GOODS + "code:";

    /**
     * 商品图片编码
     */
    public static final String FORMSSI_GOODS_IMAGE_CODE = FORMSSI_GOODS + "image:code:";

    /**
     * 商品库存批次编码
     */
    public static final String FORMSSI_GOODS_BATCH_CODE = FORMSSI_GOODS + "batch:code:";

    /**
     * 商品券状态变更批次编码
     */
    public static final String FORMSSI_GOODS_COUPON_FILE_CODE = FORMSSI_GOODS + "coupon:file:code:";

    /**
     * 商品优惠券库存编码
     */
    public static final String FORMSSI_GOODS_STOCK_CODE = FORMSSI_GOODS + "stock:code:";

    /**
     * 商品优惠券缓存
     */
    public static final String FORMSSI_GOODS_COUPON_CACHE = FORMSSI_GOODS + "coupon:cache:";
    /**
     * 商品优惠券数量缓存
     */
    public static final String FORMSSI_GOODS_COUPON_COUNT_CACHE = FORMSSI_GOODS + "coupon:count:cache:";

    /**
     * 商品审核
     */
    public static final String FORMSSI_GOODS_AUDIT = "formssi:goods:audit:";

    /**
     * 门店
     */
    public static final String FORMSSI_SHOP = "formssi:shop:";

    /**
     * 门店-编号
     */
    public static final String FORMSSI_SHOP_CODE = "formssi:shop:code:";

    /**
     * 门店组
     */
    public static final String FORMSSI_GROUP = "formssi:group:";

    /**
     * 门店组-编号
     */
    public static final String FORMSSI_GROUP_CODE = "formssi:group:code:";

    /**
     * 门店组图片-编号
     */
    public static final String FORMSSI_GROUP_IMAGE_CODE = "formssi:group:image:code:";

    /**
     * 门店组审核
     */
    public static final String FORMSSI_SHOP_GROUP_AUDIT = "formssi:shop:group:audit:";


    /**
     * 公用基础模块
     */
    public static final String FORMSSI_BASE = "formssi:base:";

    /**
     * 公用基础模块-省市区地址信息
     */
    public static final String FORMSSI_BASE_REGION = "formssi:base:region:";

    /**
     * 公用基础模块-省市区地址信息： hash存储 key 存parentCode 值存BmsRegion对象列表
     */
    public static final String FORMSSI_BASE_REGION2 = "formssi:base:region2:";

    /**
     * 公用基础模块-省市区地址信息： hash存储 key 存regionCode 值存BmsRegion对象
     */
    public static final String FORMSSI_BASE_REGION3 = "formssi:base:region3:";

    /**
     * 公用基础模块-用户信息
     */
    public static final String FORMSSI_BASE_USER = "formssi:base:user:";

    /**
     * 公用基础模块-用户token信息
     */
    //public static final String FORMSSI_BASE_USER_TOKEN = "formssi:base:user:token:";

    /**
     * 公用基础模块-资源权限
     */
    public static final String FORMSSI_BASE_USER_RESOURCE = "formssi:base:user:resource:";

    /**
     * 公用基础模块-文件信息
     */
    public static final String FORMSSI_BASE_FILE = "formssi:base:file:";

    /**
     * 缓存时长，5年时间
     */
    public static final long EXPIRATION_TIME_OVER = 15552000L;

    /**
     * 缓存时长，1年时间
     */
    public static final long EXPIRATION_TIME_1_YEAR = 31536000L;

    /**
     * 缓存时长，1月
     */
    public static final long EXPIRATION_TIME_1_MONTH = 2592000L;

    /**
     * 缓存时长，1周
     */
    public static final long EXPIRATION_TIME_1_WEEK = 604800L;

    /**
     * 缓存时长，1天
     */
    public static final long EXPIRATION_TIME_24_HOUR = 86400;

    /**
     * 缓存时长，1小时
     */
    public static final long EXPIRATION_TIME_1_HOUR = 3600;

    /**
     * 缓存时长，30分钟
     */
    public static final long EXPIRATION_TIME_30 = 1800;

    /**
     * 缓存时长，10分钟
     */
    public static final long EXPIRATION_TIME_10 = 600;

    /**
     * 缓存时长，5分钟
     */
    public static final long EXPIRATION_TIME_5 = 300;

    /**
     * 缓存时长，1分钟
     */
    public static final long EXPIRATION_TIME_1 = 60;

    /**
     * 缓存时长，10秒
     */
    public static final long EXPIRATION_SECOND_10 = 10;
}
