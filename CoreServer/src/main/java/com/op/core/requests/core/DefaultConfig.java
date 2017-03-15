package com.op.core.requests.core;

import org.apache.http.HttpVersion;

import java.nio.charset.Charset;

public class DefaultConfig {
    public static final HttpVersion HTTP_VERSION = HttpVersion.HTTP_1_1;
    public static final int SOCKET_TIMOUT = 60000;
    public static final int CONNECTION_TIMOUT = 60000;
    public static final String REQUEST_CHARSET = "UTF-8";
    public static final String CONTENT_TYPE = "application/json";
    public static final String LOGGER_FORMATE = "url:[%s], method:[%s], params:[%s], postform:[%s], body:[%s]";
    public static final String CHARSET = "UTF-8";
    public static final Charset DEFAULT_CHARSET_TYPE = Charset.defaultCharset();
}
