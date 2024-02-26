package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;

public class MainController {
    private static UserInfo userInfo = new UserInfo();

    private static SettingInfo settingInfo = new SettingInfo();

    public static UserInfo getUserInfo() {
        return userInfo;
    }

    public static SettingInfo getSettingInfo() {
        return settingInfo;
    }

}
