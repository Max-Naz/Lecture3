package com.qatestlab.lecture3.util;

public class Properties {
    private static final String DEFAULT_BASE_ADMIN_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String ADMIN_EMAIL = "webinar.test@gmail.com";
    private static final String ADMIN_PASSWORD = "Xcg7299bnSmMuRLp9ITw";

    public static String getDefaultBaseAdminUrl() {
        return DEFAULT_BASE_ADMIN_URL;
    }

    public static String getAdminEmail() {
        return ADMIN_EMAIL;
    }

    public static String getAdminPassword() {
        return ADMIN_PASSWORD;
    }
}
