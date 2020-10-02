package com.until.team.service;

/**
 * @ClassName Status
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 14:53
 * @Version 1.0
 */
public class Status {
    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
