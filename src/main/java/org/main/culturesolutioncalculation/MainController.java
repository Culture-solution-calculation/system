package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;

public class MainController {
    private static UserInfo userInfo = new UserInfo();

    private static SettingInfo settingInfo = new SettingInfo();

    private static TableData tableData = new TableData();

    public static UserInfo getUserInfo() {
        return userInfo;
    }

    public static SettingInfo getSettingInfo() {
        return settingInfo;
    }

    public static TableData getTableData() {
        return tableData;
    }

}
