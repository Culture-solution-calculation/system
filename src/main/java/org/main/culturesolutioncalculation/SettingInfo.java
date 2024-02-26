package org.main.culturesolutioncalculation;

import java.util.HashMap;
import java.util.Map;

public class SettingInfo {
    // 그룹 이름
    private String group;
    // 라디오 버튼 text
    private String radioButton;
    // 모달창 입력 값
    private Integer value;
    // SettingInfo 맵
    private static Map<String, SettingInfo> groupInfoMap = new HashMap<>();

    public SettingInfo() {
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getRadioButton() {
        return radioButton;
    }

    public void setRadioButton(String radioButton) {
        this.radioButton = radioButton;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Map<String, SettingInfo> getGroupInfoMap() {
        return groupInfoMap;
    }

    public static void setGroupInfoMap(Map<String, SettingInfo> map) {
        groupInfoMap = map;
    }

    @Override
    public String toString() {
        return "RadioButton=" + radioButton+
                ", value=" + value;
    }
}
