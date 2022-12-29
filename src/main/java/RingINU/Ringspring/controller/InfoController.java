package RingINU.Ringspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@Controller
public class InfoController {
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(String userID, Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("userID", userID);

        // 입력한 userID을 DB에 저장
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("org.sqlite.JDBC");
        String dbFileUrl = "C:\\Users\\HanYeJi\\Desktop\\jetbot\\Ring-spring\\src\\main\\java\\RingINU\\Ringspring\\controller\\DB\\UserInfo.db";

        //try{
            con=DriverManager.getConnection("jdbc:sqlite:" + dbFileUrl);
            System.out.println("DB connected");

            stmt=con.createStatement();
            stmt.executeUpdate("insert into info(userID, score) values(\"" + userID + "\",0);");

            //rs=stmt.executeQuery("");
            con.commit();
            con.setAutoCommit(true);
        //}//catch (Exception e) {
            //System.out.println(e);
       // }finally {
            con.close();
            stmt.close();
            rs.close();
        //}

        return "testinfo";
        return
    }

    @GetMapping("hello-string") // http://localhost:8080/hello-string?name=예지
    @ResponseBody // 내가 직접 html body 부분에 해당내용을 넣겠다 == 기본 문자 그대로 넘겨라 => StringConverter 동작
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // name: spring => "hello spring"
    }

    // API 방식: view 없이 HttpMessageConverter(StringConverter or JsonConverter) 동작. return 문자 그대로 내려감
//    @GetMapping("hello-string") // http://localhost:8080/hello-string?name=
//    @ResponseBody // 내가 직접 html body 부분에 해당내용을 넣겠다 == 기본 문자 그대로 넘겨라 => StringConverter 동작
//    public String helloString(@RequestParam("name") String name){
//        JSONParser parser = new JSONParser();
//        String jsonFilename = "/timetable.json";
//
//        File file = new File(jsonFilename);
//        FileReader fileReader1 = new FileReader(file);
//        Object obj = parser.parse(fileReader1);
//
//        JSONObject jsonObject =(JSONObject) obj;
//        System.out.println("============"+jsonObject.toString());
//
//        return "hello " + name; // name: spring => "hello spring"
//    }


}
