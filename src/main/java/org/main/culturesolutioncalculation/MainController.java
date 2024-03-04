package org.main.culturesolutioncalculation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

import java.io.IOException;

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

    public MacroTabController getMacroTabController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MacroTab.fxml"));
            Tab tab = loader.load();
            MacroTabController macroTabController = loader.getController();
            return macroTabController;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
