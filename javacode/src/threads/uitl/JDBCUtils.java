package threads.uitl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
 * jdbc工具类
 *
 * */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
     * 文件的一次即可以拿到这些值。使用静态代码块
     * */
    static {
        //都区资源文件。获取值

        try {

            // 1创建Properties集合类
            Properties pro = new Properties();
            //2加载文件

            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("ajax/jdbc.properties");
           String path=res.getPath();
            System.out.println(path);
            pro.load(new FileReader(path));
            //3.获取数据
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4注册驱动
            Class.forName(driver);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /*
     * 获取连接
     * @return 连接对象
     * */
    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    /*
     * 释放资元
     * */
    public static void close(Statement stmt1, Connection conn2) {
        if (stmt1 != null) {
            try {
                stmt1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn2 != null) {
            try {
                conn2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {

               stmt.close();
                System.out.println("资源释放成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
