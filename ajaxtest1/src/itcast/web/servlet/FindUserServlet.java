package itcast.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     出理乱码
   response.setContentType("application/json;charset=UTF-8");

      //1，获取用户名
       String username= request.getParameter("username");
//调用service层是否存在
        Map<String,Object> map=new HashMap<>();


        if ("root".equals(username)){
            map.put("userExist",true);
            map.put("msg","用户名太受欢迎，请换一个");
        }else{
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }

        //将map-->json

        ObjectMapper mapper=new ObjectMapper();
//        将数据传送给客户端
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
