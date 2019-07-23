package com.stackroute;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //insert values into employee
    public int insertIntoemployee(Employee e){
        String query="insert into employee values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
        return jdbcTemplate.update(query);
    }
    //update  employee details
    public int updateEmployee(Employee e){
        String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);

    }
    //delete employee details
    public int deleteEmployee(Employee e){
        String query="delete from employee where  id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    //retrive details
    public List<Employee> retriveEmployees(){
        String query="select * from employee";
        final List<Employee> list = new ArrayList<Employee>();
        return jdbcTemplate.query(query,new ResultSetExtractor<List<Employee>>(){

            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {


                while (resultSet.next()) {
                    Employee e = new Employee();
                    e.setId(resultSet.getInt(1));
                    e.setName(resultSet.getString(2));
                    e.setSalary(resultSet.getInt(3));
                    list.add(e);
                }
                return list;
            }
        }
        );

    }
}
