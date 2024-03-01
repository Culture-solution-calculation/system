package org.main.culturesolutioncalculation;

import java.util.HashMap;
import java.util.Map;

public class SettingInfo {
    // SettingInfo 맵
    private static Map<String, Integer> totalSetting = new HashMap<>();

    public SettingInfo() {
    }

    public Map<String, Integer> getTotalSetting() {
        return totalSetting;
    }

    public static void setTotalSetting(Map<String, Integer> map) {
        totalSetting = map;
    }
}
