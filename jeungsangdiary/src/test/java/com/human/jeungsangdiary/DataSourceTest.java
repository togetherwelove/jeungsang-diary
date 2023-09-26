package com.human.jeungsangdiary;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSourceTest implements CommandLineRunner{

    private final DataSource dataSource;

    public DataSourceTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("데이터베이스 연결 성공 : " + conn.toString());
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패 : " + e.getMessage());
        }
    }
}