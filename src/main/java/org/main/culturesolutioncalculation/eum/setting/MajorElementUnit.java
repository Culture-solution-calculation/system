package org.main.culturesolutioncalculation.eum.setting;

public enum MajorElementUnit {
    ppm(0,"ppm(피피엠)"),
    mM(1,"mM(밀리몰)"),
    me(2,"me(밀리당량)");
    private final int idx;
    private final String name;

    MajorElementUnit(int idx, String name) {
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
