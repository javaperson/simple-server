package com.github.javaperson.common.throwable;


/**
 * HappyElements公共异常，所有运行时出错情况可统一抛出该异常
 */
public class HeException extends RuntimeException {

    /**
     * 错误编码
     */
    private final HeErrorCode code;

    /**
     * 根据错误编码构造异常对象
     *
     * @param code 错误编码
     */
    public HeException(HeErrorCode code) {
        this(code, null, (Object[]) null);
    }

    /**
     * 根据错误编码、信息参数构造异常对象
     *
     * @param code   错误编码
     * @param params 信息参数
     */
    public HeException(HeErrorCode code, Object... params) {
        this(code, null, params);
    }

    /**
     * 根据错误编码、原异常、信息参数构造异常对象
     *
     * @param code   错误编码
     * @param tx     原异常对象
     * @param params 信息参数
     */
    public HeException(HeErrorCode code, Throwable tx, Object... params) {
        super(HeErrorMessageBuilder.buildMessage(code, params), tx);
        this.code = code;
    }

    /**
     * 取得错误编码
     *
     * @return 错误编码
     */
    public HeErrorCode getCode() {
        return this.code;
    }
}
