package org.main.culturesolutioncalculation;

import java.util.Map;

public class TableData {
    private Map<String, Integer> macroSettings;
    private Map<String, Integer> microSettings;

    public TableData() {
    }


    public void setMacroSettings(Map<String, Integer> macroSettings) {
        this.macroSettings = macroSettings;
    }

    public void setMicroSettings(Map<String, Integer> microSettings) {
        this.microSettings = microSettings;
    }

    public Map<String, Integer> getMacroSettings() {
        return macroSettings;
    }

    public Map<String, Integer> getMicroSettings() {
        return microSettings;
    }
}
