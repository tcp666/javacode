package itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1，获取请求参数
        String username=request.getParameter("username");
        //处理业务逻辑。耗时
//       try {
//           Thread.sleep(5000);
//       }
//       catch (InterruptedException e) {
//           e.printStackTrace();
//       }

//  2,打印请求参数
        System.out.println("username:"+username);
//        响应
response.getWriter().write("hello,world");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
