package com.until.team.domain;

/**
 * @ClassName Designer
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 15:02
 * @Version 1.0
 */
public class Designer extends Programmer {
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t设计师\t" + getBonus();
    }
}
