package com.github.javaperson.common.throwable;

import com.github.javaperson.common.HeConsts;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.text.MessageFormat;

/**
 * 异常消息创建类
 */
public class HeErrorMessageBuilder {

    private static final LoadingCache<HeErrorCode, MessageFormat> cache = CacheBuilder.newBuilder().build(new CacheLoader<HeErrorCode, MessageFormat>() {
        @Override
        public MessageFormat load(HeErrorCode key) throws Exception {
            return new MessageFormat(key.getMessage());
        }
    });

    /**
     * 根据异常对象组件异常消息
     *
     * @param hec    异常编码
     * @param params 异常消息变量
     * @return 异常信息
     */
    public static String buildMessage(HeErrorCode hec, Object... params) {
        if (hec == null) return HeConsts.DFT_STRING_VAL;
        MessageFormat.format(hec.getMessage(), params);
        MessageFormat messageFormat = cache.getUnchecked(hec);
        return messageFormat.format(params);
    }
}
