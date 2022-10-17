package com.dbexercise;

import com.dbexercise.domain.User;

import java.sql.*;
import java.util.Map;
//(SELECT)
public class UserDao3 {
    public User select(String id) throws SQLException ,ClassNotFoundException {
        Map<String, String> env = System.getenv();
   //     Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD")
        ); // db연결
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users where id = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
        rs.close();
        pstmt.close();
        conn.close();

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserDao3 UserDao3 = new UserDao3();
        User user = UserDao3.select("1");
        System.out.println(user.getName());

    }
}