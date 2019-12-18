package com.github.acehjm.solbycloud.auth.constant;

/**
 * com.github.acehjm.solbycloud.auth.constant
 *
 * @author majhdk
 * @date 2019/12/17
 */
public class AuthConstant {
    private AuthConstant(){}

    public static final String CLIENT_ID = "client";
    public static final String CLIENT_SECRET = "client-secret";

    public static final String SCOPE_READ = "read";
    public static final String SCOPE_WRITE = "write";

    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60;
    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;

}
