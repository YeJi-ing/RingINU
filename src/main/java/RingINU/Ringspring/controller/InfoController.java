package RingINU.Ringspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@Controller
public class InfoController {
    // 현재 진행 중인 사용자 ID
    String ID;
    int score;

    // 입력한 userID을 DB에 저장 ( setAutoCommit(true) 상태 )
    void InsertDB(String userID) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("org.sqlite.JDBC");
        //String dbFileUrl = "C:\\Users\\HanYeJi\\Desktop\\jetbot\\Ring-spring\\src\\main\\java\\RingINU\\Ringspring\\controller\\DB\\UserInfo.db";
        String dbFileUrl = "./src/main/java/RingINU/Ringspring/controller/DB/UserInfo.db";

        try{
            con=DriverManager.getConnection("jdbc:sqlite:" + dbFileUrl);
            System.out.println("DB connected");

            stmt=con.createStatement();
            stmt.executeUpdate("insert into info(userID, score) values(\"" + userID + "\",null);"); 
            // 0을 null로 바꿈
            
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            stmt.close();
            //rs.close();
        }
    }

    // 최종 score를 DB에 저장
    void UpdateDB(int score) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("org.sqlite.JDBC");
        //String dbFileUrl = "C:\\Users\\HanYeJi\\Desktop\\jetbot\\Ring-spring\\src\\main\\java\\RingINU\\Ringspring\\controller\\DB\\UserInfo.db";
        String dbFileUrl = "./src/main/java/RingINU/Ringspring/controller/DB/UserInfo.db";

        try{
            con=DriverManager.getConnection("jdbc:sqlite:" + dbFileUrl);
            System.out.println("DB connected");

            stmt=con.createStatement();
            stmt.executeUpdate("UPDATE info set score=" + score + " where userID=\"" + ID + "\";");

        }catch (Exception e) {
            System.out.println(e);
        }finally {
            stmt.close();
            //rs.close();
        }
    }


    @RequestMapping(value = "send", method = RequestMethod.GET)
    public String send(String userID, Model model) throws ClassNotFoundException, SQLException {
        model.addAttribute("userID", userID);

        // 입력한 UserID를 DB에 저장
        InsertDB(userID);

        // 진행중인 사용자 ID 업데이트
        ID = userID;

        return "testinfo";
    }

    // page2에서 호출, page3로
    @GetMapping("squat") // 객체를 그대로 넘기는 상황 => JsonConverter 동작
    public String helloApi(Model model) throws SQLException, ClassNotFoundException {
        String nickname = ID;
        
        score = 300; // 임시 스코어 값 
        UpdateDB(score);

        model.addAttribute("score", score);
        model.addAttribute("nickname", nickname);

        return "page3";
    }


    @GetMapping("situp") // 객체를 그대로 넘기는 상황 => JsonConverter 동작
    public String situpApi(Model model) throws SQLException, ClassNotFoundException {
        String nickname = ID;

        score = 300; // 임시 스코어 값
        UpdateDB(score);

        model.addAttribute("score", score);
        model.addAttribute("nickname", nickname);

        return "page3_su";
    }

    @GetMapping("pushup") // 객체를 그대로 넘기는 상황 => JsonConverter 동작
    public String pushupApi(Model model) throws SQLException, ClassNotFoundException {
        String nickname = ID;

        score = 300; // 임시 스코어 값
        UpdateDB(score);

        model.addAttribute("score", score);
        model.addAttribute("nickname", nickname);

        return "page3_ps";
    }

    @GetMapping("result")
    public String resultApi(Model model) throws SQLException, ClassNotFoundException {

        String[] top = new String[3];
        int[] ScoreNum = new int[3];

        // SortDB
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("org.sqlite.JDBC");
        //String dbFileUrl = "C:\\Users\\HanYeJi\\Desktop\\jetbot\\Ring-spring\\src\\main\\java\\RingINU\\Ringspring\\controller\\DB\\UserInfo.db";
        String dbFileUrl = "./src/main/java/RingINU/Ringspring/controller/DB/UserInfo.db";

        try{
            con=DriverManager.getConnection("jdbc:sqlite:" + dbFileUrl);
            System.out.println("DB connected");

            stmt=con.createStatement();
            rs = stmt.executeQuery("SELECT userID, score FROM info ORDER by score desc LIMIT 3;");

            int cnt = 3;

            for(int i =0;i<cnt;i++)
            {
                rs.next();
                top[i] = rs.getString("userID");
                ScoreNum[i] = rs.getInt("score");
            }


        }catch (Exception e) {
            System.out.println(e);
        }finally {
            stmt.close();
            rs.close();
        }

        model.addAttribute("userID", ID);
        model.addAttribute("userScore", score);

        model.addAttribute("top1", top[0]);
        model.addAttribute("top2", top[1]);
        model.addAttribute("top3", top[2]);

        model.addAttribute("score1", ScoreNum[0]);
        model.addAttribute("score2", ScoreNum[1]);
        model.addAttribute("score3", ScoreNum[2]);

        return "page4";
    }

}
