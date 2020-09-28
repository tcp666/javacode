package itcast.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import itcast.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showServlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Class<?> s=null;
        try{
           s=   Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/facetoface_db?serverTimezone=UTC",
                    "root","tcp666");
            pstm=conn.prepareStatement("select * from account");

           rs=pstm.executeQuery();
            List<Account> list=new ArrayList<>();
           while (rs.next()){
               Account p=new Account();
               p.setId(rs.getInt(1));
               p.setName(rs.getNString(2));
               p.setMoney(rs.getInt(3));
               list.add(p);
           }

            ObjectMapper mapper=new ObjectMapper();
           String json=mapper.writeValueAsString(list);

           resp.getWriter().write(json);

        }
       catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn!=null)
                try {
                    conn.close();
                    System.out.println("conn已经关闭");
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            if (pstm!=null)
                try {
                    pstm.close();
                    System.out.println("pstm已经关闭");
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            if (rs!=null)
                try {
                    rs.close();
                    System.out.println("rs已经关闭");
                }
                catch (SQLException e){
                    e.printStackTrace();
                }

        }
    }
}
