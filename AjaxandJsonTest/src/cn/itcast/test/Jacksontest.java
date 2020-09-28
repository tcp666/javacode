package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class Jacksontest {
    //    javaobj-->json
    @Test
    public void test1() throws JsonProcessingException {
        Person p = new Person();
        p.setAge(22);
        p.setName("李天王");
        p.setGender("男");

        //创件
        ObjectMapper mapper = new ObjectMapper();
        /**
         * 转换方法：
         *  mapper.writeValue(file，obj);
         */
        String pjson = mapper.writeValueAsString(p);
        System.out.println(pjson);//{"name":"男","age":22,"gender":null}


    }

    @Test
    public void test2() throws JsonProcessingException {
        Person p = new Person();
        p.setAge(22);
        p.setName("李天王");
        p.setGender("男");
        p.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

    }
    @Test
    public void test3() throws JsonProcessingException {
        Person p1 = new Person();
        p1.setName("李天王");
        p1.setAge(22);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setAge(22);
        p2.setName("李天王");
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setAge(22);
        p3.setName("李天王");
        p3.setGender("男");
        p3.setBirthday(new Date());

        List<Person> list =new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String pjsons = mapper.writeValueAsString(list);
        System.out.println(pjsons);
    }

    @Test
    public void test4() throws JsonProcessingException {


        Map<String,Object>  map=new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");
        ObjectMapper mapper = new ObjectMapper();
        String pjsons = mapper.writeValueAsString(map);
        System.out.println(pjsons);
    }

    @Test
    public void test5() throws IOException {
//        初始化
        String json="{\"name\":\"李天王\",\"age\":22,\"gender\":\"男\",\"birthday\":\"2019-10-28\"}";

        ObjectMapper mapper=new ObjectMapper();
        Person p=mapper.readValue(json,Person.class);
        System.out.println(p);
    }
}
