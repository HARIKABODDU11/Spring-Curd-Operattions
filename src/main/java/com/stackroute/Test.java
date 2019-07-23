package com.stackroute;

import com.stackroute.Employee;
import com.stackroute.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeDao employeeDao = applicationContext.getBean("edao", EmployeeDao.class);
        //insertion into table
        System.out.println("insertion");

        int status=employeeDao.insertIntoemployee(new Employee(102,"harika",1222));
        System.out.println(status);
        System.out.println("update");
        Employee employee1 = new Employee();
        employee1.setId(2);


        //update record based on employeeId
        int status1 = employeeDao.updateEmployee(new Employee(employee1.getId(), "hema",122));
        System.out.println(status1);


        //delete recordbased on employeeId

        System.out.println("delete");
        Employee e=new Employee();
        e.setId(102);

        int status2=employeeDao.deleteEmployee(e);
        System.out.println(status2);


        ////retrive  the details
        System.out.println("retrive");

        List<Employee> list=employeeDao.retriveEmployees();

        for(Employee employee:list)
            System.out.println(employee);

    }

}