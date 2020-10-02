package com.until.team.service;

import com.until.team.domain.Architect;
import com.until.team.domain.Designer;
import com.until.team.domain.Employee;
import com.until.team.domain.Programmer;
import sun.security.krb5.internal.crypto.Des;

import java.time.temporal.Temporal;

/**
 * @ClassName TeamService
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 16:21
 * @Version 1.0
 */
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public TeamService() {
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 成员已满，无法添加
     * 该成员不是开发人员，无法添加
     * 该员工已在本开发团队中
     * 该员工已是某团队成员
     * 该员正在休假，无法添加
     * 团队中至多只能有一名架构师
     * 团队中至多只能有两名设计师
     * 团队中至多只能有三名程序员
     *
     * @param e
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }

        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }

        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员工已是某团队成员");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该员正在休假，无法添加");
        }

        int numOfArch = 0;
        int numOfDes = 0;
        int numOfPro = 0;

        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i;
        for (i = 0; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        if (i == total){
            throw new TeamException("找不到指定memberID的员工，删除失败");
        }

        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;
    }
}
