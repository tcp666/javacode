package com.itheima.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 * 耦合：
 *      程序间的依赖关系
 *      类依赖
 *      方法依赖
 *   解耦：
 *      降低程序间的依赖关系
 *   编译器不依赖
 *   运行时才以来
 *
 * 解耦思路：
 *  1，使用反射机制创建类对象（写死了）
 *  2，通过读取配置文件来获取类名
 *
 *
 */
public class JdbcDemo1 {
    public static void main(String[] args) {
        //1注册驱动
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
           // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2获取链接
            conn = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/facetoface_db?serverTimezone=UTC",
                            "root",
                            "tcp666");
            //3获取处理对象
            pstm = conn.prepareStatement("select * from account;");
            //4，获取结果集
            rs = pstm.executeQuery();
            //5，便利
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
     } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null)
                try{
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (rs!=null)
                try{
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (pstm!=null)
                try{
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }

    }
}
