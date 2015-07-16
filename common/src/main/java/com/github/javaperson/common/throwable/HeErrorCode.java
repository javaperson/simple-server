package com.github.javaperson.common.throwable;

public interface HeErrorCode {

    /**
     * 取得格式化前异常信息
     *
     * @return 异常信息
     */
    public String getMessage();

    /**
     * 取得异常编码
     *
     * @return 异常编码
     */
    public int getCode();
}
