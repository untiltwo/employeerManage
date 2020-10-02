package com.until.team.domain;

import sun.security.krb5.internal.crypto.Des;

/**
 * @ClassName Architect
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 15:03
 * @Version 1.0
 */
public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }


    @Override
    public String getDetailsForTeam() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t架构师\t" + getBonus()+"\t"+getStock();
    }
}
