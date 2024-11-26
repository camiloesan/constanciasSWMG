package com.swmg.constanciasswmg.utils;

public class SessionDetails {
    public static String accountId;
    public static String userType;
    public static int userId;
    public static String email;

    public SessionDetails() {}

    public SessionDetails(String accountId, String userType, int userId, String email) {
        SessionDetails.accountId = accountId;
        SessionDetails.userType = userType;
        SessionDetails.userId = userId;
        SessionDetails.email = email;
    }

    public static String getAccountId() {
        return accountId;
    }

    public static void setAccountId(String accountId) {
        SessionDetails.accountId = accountId;
    }

    public static String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        SessionDetails.userType = userType;
    }

    public static int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        SessionDetails.userId = userId;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        SessionDetails.email = email;
    }
}
