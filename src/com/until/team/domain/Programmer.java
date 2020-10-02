package com.until.team.domain;

import com.until.team.service.Status;

/**
 * @ClassName Programmer
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 14:50
 * @Version 1.0
 */
public class Programmer extends Employee {
    /**
     * 开发团队中的ID
     */
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Programmer() {
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getDetailsForTeam() {
        return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t程序员";
    }
}
