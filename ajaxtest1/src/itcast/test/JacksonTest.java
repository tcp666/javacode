package itcast.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import itcast.domain.Person;
import org.junit.Test;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {
    @Test
    public void test1() throws Exception {
        //1,创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        //创建jackson核心对象

        ObjectMapper mapper = new ObjectMapper();

//        3,调用方法转换
        /**
         * 转换方法：
         *      1，writeValue（参数1，obj）
         *          参数1：
         *              File:将obj对象转换为JSON字符串，并保存到指定文件
         *              writer:将obj对象转换为JSON字符串,并填充到字符输出流中
         *              OutputStream:将obj对象转换为JSON字符串,并填充到字节输出流中
         *
         *
         *      2,writeValueAsString(obj);将对象转化为json字符串
         */
        String json = null;
        try {
            json = mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        {"name":"张三","age":23,"gender":"男"}
        System.out.println(json);

        //writeValue,将数据写到test.txt

//        mapper.writeValue(new File("test.txt"),p);

        mapper.writeValue(new FileWriter("test1.txt"), p);
    }

    @Test
    public void test2() throws Exception {
        //1,创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(p);
        System.out.println(json);//{"name":"张三","age":23,"gender":"男","birthday":1560945399969}

    }

    @Test
    public void test3() throws Exception {
        //1,创建person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(24);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("王五");
        p3.setAge(23);
        p3.setGender("男");
        p3.setBirthday(new Date());


        List<Person> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
        /**
         * [
         *  {"name":"张三","age":24,"gender":"男","birthday":"2019-06-19"},
         *  {"name":"李四","age":23,"gender":"男","birthday":"2019-06-19"},
         *  {"name":"王五","age":23,"gender":"男","birthday":"2019-06-19"}
         * ]
         */


    }

    @Test
    public void test4() throws Exception {
        //初始化json字符串
        String json = "{\"name\":\"张三\",\"age\":24,\"gender\":\"男\",\"birthday\":\"2019-06-19\"}";
        //创建对象
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }


}
