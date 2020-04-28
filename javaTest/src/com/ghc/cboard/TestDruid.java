package com.ghc.cboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TestDruid {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String url = "jdbc:avatica:remote:url=http://192.168.0.168:8082/druid/v2/sql/avatica/";
        Properties connectionProperties = new Properties();

        try(Connection connection = DriverManager.getConnection(url,connectionProperties)){
            try(ResultSet resultSet =
                        connection.createStatement()
                                .executeQuery("SELECT COUNT (*) FROM jinfeng_three_1")) {
                while (resultSet.next()){
                    System.out.println("hello");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
