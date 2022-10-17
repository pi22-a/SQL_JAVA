package com.dbexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
//(INSER)
public class UserDao2 {
    public void add() throws SQLException ,ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword); // db연결
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, "2");
        ps.setString(2, "pizza");
        ps.setString(3, "1234");

        ps.executeUpdate();
        ps.close();
        conn.close();


    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserDao2 userDao2 = new UserDao2();
        userDao2.add();

    }
}
