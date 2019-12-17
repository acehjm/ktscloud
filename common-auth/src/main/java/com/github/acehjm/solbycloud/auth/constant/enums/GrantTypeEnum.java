package com.github.acehjm.solbycloud.auth.constant.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * com.github.acehjm.solbycloud.auth.constant.enums
 *
 * @author majhdk
 * @date 2019/12/17
 */
@Getter
public enum GrantTypeEnum {

    AUTHORIZATION_CODE("authorization_code", "授权码模式"),

    PASSWORD("password", "用户名密码模式"),

    IMPLICIT("implicit", "隐藏式授权模式"),

    CLIENT_CREDENTIALS("client_credentials", "客户端凭证模式"),

    REFRESH_TOKEN("refresh_token", "刷新令牌"),

    ;
    /**
     * 授权类型
     */
    private String grantType;
    /**
     * 描述
     */
    private String desc;

    GrantTypeEnum(String grantType, String desc) {
        this.grantType = grantType;
        this.desc = desc;
    }

    /**
     * 获取所有的授权类型
     *
     * @return
     */
    public static String[] types() {
        return Arrays.stream(GrantTypeEnum.values())
                .map(GrantTypeEnum::getGrantType)
                .collect(Collectors.toUnmodifiableList())
                .toArray(new String[]{});
    }

}
