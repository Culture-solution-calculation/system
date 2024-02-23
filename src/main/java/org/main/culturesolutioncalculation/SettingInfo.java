package org.main.culturesolutioncalculation;

public class SettingInfo {
    // 그룹 이름
    private String group;
    // 라디오 버튼 text
    private String radioButton;
    // 모달창 입력 값
    private Integer value;

    public SettingInfo(String group, String radioButton, Integer value) {
        this.group = group;
        this.radioButton = radioButton;
        this.value = value;
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
}
