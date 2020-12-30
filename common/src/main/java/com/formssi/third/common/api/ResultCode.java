package com.formssi.third.common.api;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    NOFILE(400, "请选择上传文件。"),

    //错误提示编码6位数字
    //公共提示，从100000开始
    //比如：参数为空
    PARAM_MISSING(100000, "参数缺失"),
    UPLOAD_FILE_FAILED(100001, "文件上传失败"),
    USER_NOT_LOGIN(100002, "用户未登录"),
    ANALYSIS_FILE_FAILED(100003, "解析文件失败"),
    ANALYSIS_FILE_EMPTY(100004, "未解析到数据，请重新上传文件"),
    ACCOUNT_EXIST(100005, "账号已存在"),
    USER_NOT_EXIST(100006, "用户不存在"),
    OLD_PASSWORD_ERROR(100007, "旧密码不正确"),
    PASSWORD_ERROR(100008, "密码不正确"),
    ILLEGAL_MOBILE(100009, "手机号不合格"),
    ROLE_NOT_EXIST(100010, "角色不存在，无法删除"),
    ROLE_DELETE_FAIL(100011, "删除失败！请先取消当前角色已关联的账号，再进行删除操作"),
    ACCOUNT_NOT_ROLE(100012, "因账号未分配角色,请先分配角色，再登陆"),
    ACCOUNT_EXCEPTION(100013, "因关联的角色已被禁用，请确保角色已启用，再登陆"),
    FIELD_NOT_NULL(100014, "第%d行%s是必填项"),
    FIELD_INCORRECT(100015, "第%d行%s的值不正确"),
    FIELD_FORMAT_ERROR(100016, "第%d行%s的值不正确,正确格式是:%s"),
    BUSINESS_CODE_EXIST(100017,"部门编码已存在"),
    BUSINESS_NAME_EXIST(100018,"部门名称已存在"),
    PARAM_VALUE_ERROR(100018, "参数值不正确");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
