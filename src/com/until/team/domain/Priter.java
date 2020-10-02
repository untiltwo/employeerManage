package com.until.team.domain;

/**
 * @ClassName Priter
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 14:46
 * @Version 1.0
 */
public class Priter implements Equipment {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Priter() {
    }

    public Priter(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
