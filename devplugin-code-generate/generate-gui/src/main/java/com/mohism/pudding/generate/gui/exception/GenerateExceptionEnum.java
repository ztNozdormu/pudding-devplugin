package com.mohism.pudding.generate.gui.exception;

import com.mohism.pudding.kernel.model.exception.AbstractBaseExceptionEnum;

/**
 * @ 创建人 zt
 * @ 创建时间 2019/5/29
 * @ 描述 代码自动生成模块异常枚举
 */
public enum GenerateExceptionEnum implements AbstractBaseExceptionEnum {

    REPEAT_DICT_TYPE(2110, "该编码字典已经存在！"),
    NOT_EXISTED(2111, "字典不存在！"),
    PARENT_NOT_EXISTED(2112, "父级字典不存在！"),
    WRONG_STATUS(2113, "状态错误！"),
    DBDRIVER_NOT_FIND(2114, "找不到数据库驱动！");

    GenerateExceptionEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    private int code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
