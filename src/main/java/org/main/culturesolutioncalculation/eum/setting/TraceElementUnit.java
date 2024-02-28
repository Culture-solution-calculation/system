package org.main.culturesolutioncalculation.eum.setting;

public enum TraceElementUnit {
    ppm(0,"ppm(피피엠)"),
    microM(1,"µM(마이크로몰)");
    private final int idx;
    private final String name;

    TraceElementUnit(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }

    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }
}
