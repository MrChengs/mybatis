package com.lg.jdbcexample;

import java.io.IOException;
import java.sql.*;

public class JDBCExample {
    public static void getConnection() throws IOException, SQLException {
        String url = "jdbc:mysql://localhost:3306/sql_training?characterEncoding=utf-8";
        Connection connection = DriverManager.getConnection(url,"root","123456");
        Statement statement = connection.createStatement();
        String dropTable = "drop table department";//drop table department if exists
        statement.execute(dropTable);


        String createTable = "create table if not exists department(" +
                "code int(5) primary key,"+//comment "学院编号"
                "name varchar(25) not null"+//comment "学院名称"
                ")"+"charset=utf8";
        statement.execute(createTable);

        String insertSql = "insert into department(code,name) values (10001,\"机电工程学院\"),(10002,\"资源与环境学院\")";
        statement.execute(insertSql);
        ResultSet resultSet = statement.getResultSet();

        String querySql = "select * from department";
        statement.execute(querySql);
        resultSet = statement.getResultSet();
        while (resultSet.next()){
//            Array array = resultSet.getArray(1);
//            Array array1 = resultSet.getArray(2);
            int code = resultSet.getInt("code");
            String name = resultSet.getString("name");
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        getConnection();
    }
}
