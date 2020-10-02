package com.until.team.junit;

import com.until.team.domain.Employee;
import com.until.team.service.NameListService;
import com.until.team.service.TeamException;
import jdk.management.resource.ResourceType;
import org.junit.Test;

/**
 * @ClassName NameListServiceTest
 * @Description TODO
 * @Author rick2
 * @Date 2020/10/2 15:46
 * @Version 1.0
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] allEmployees = service.getAllEmployees();
        for (int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i]);
        }
    }
    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id =123;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
