package RingINU.Ringspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String send(String building, Model model) {
        model.addAttribute("building", building);
        if (building.equals("정보기술")) { return "buildinginfo"; }

        return "testinfo";
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
