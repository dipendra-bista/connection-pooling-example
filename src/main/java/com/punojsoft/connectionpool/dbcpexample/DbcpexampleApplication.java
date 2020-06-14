package com.punojsoft.connectionpool.dbcpexample;

import com.punojsoft.connectionpool.dbcpexample.model.Employee;
import com.punojsoft.connectionpool.dbcpexample.repository.EmployeeRepository;
import com.punojsoft.connectionpool.dbcpexample.utils.DBUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootApplication
public class DbcpexampleApplication implements ApplicationRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DbcpexampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        employeeRepository.save(Employee.builder()
                .name("Dipendra Bista").build());

        try (BasicDataSource dataSource = DBUtils.getDataSource();
             Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Employee");) {
            System.out.println("The Connection Object is of Class: " + connection.getClass());
            try (ResultSet resultSet = pstmt.executeQuery();) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + "," + resultSet.getString(2));
                }
            } catch (Exception e) {
                connection.rollback();
                e.printStackTrace();
            }
        }

    }
}
