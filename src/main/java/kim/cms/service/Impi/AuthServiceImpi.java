package kim.cms.service.Impi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import kim.cms.dao.MenteeDao;
import kim.cms.domain.Mentee;
import kim.cms.service.AuthService;

@Service
public class AuthServiceImpi implements AuthService {

  @Autowired MenteeDao menteeDao;
  
  @Override
  public Mentee findbyemailpwd(String email , String pwd) {
    
    HashMap<String, Object> params = new HashMap<>();
    
    params.put("email", email);
    params.put("pwd", pwd);
    
    return menteeDao.findbyemailpwd(params);
  }

  @Override
  public Mentee Naverjoin(String access_token) {
    String header = "Bearer " + access_token; // Bearer 다음에 공백 추가
    String phot="";
    String name="";
    String nickname="";
    String email="";
    System.out.println();
    System.out.println("authimpidddd");
        try {
              String apiURL = "https://openapi.naver.com/v1/nid/me";
              URL url = new URL(apiURL);
              HttpURLConnection con = (HttpURLConnection)url.openConnection();
              con.setRequestMethod("GET");
              con.setRequestProperty("Authorization", header);
              int responseCode = con.getResponseCode();
              BufferedReader br;
              System.out.println("1");
              if(responseCode==200) { // 정상 호출
                  br = new BufferedReader(new InputStreamReader(con.getInputStream()));
              } else {  // 에러 발생
                  br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
              }
              System.out.println("2");
              String inputLine;
              String str = "";
              while ((inputLine = br.readLine()) != null) {
                  str +=inputLine; 
              }
              System.out.println("3");
              br.close();
              
              ObjectMapper mapper = new ObjectMapper();
              
              Map<String, Object> map = mapper.readValue(str, Map.class);
              map = (Map<String, Object>) map.get("response");
              
              System.out.println("4");
              /*nickname = (String) map.get("nickname");
              name = (String) map.get("name");
              email = (String) map.get("email");
              phot = map.get("profile_image").toString();*/
              
              nickname = "hi1";
              name = "김";
              email= "kk@test.com";
              phot = "ddddasdfasdfasdf";

              System.out.println("8");
              Mentee mentee = new Mentee();
              mentee.setEmail(email);
              System.out.println("authimpi에서 email값: "+menteeDao.checkemail(mentee));
              if(menteeDao.checkemail(mentee) == 0) {
                mentee.setNick(nickname);
                mentee.setName(name);
                mentee.setEmail(email);
                mentee.setPhot(phot);
                
                menteeDao.Naverjoin(mentee);
              } else {
                mentee.setNick(nickname);
                mentee.setName(name);
                mentee.setEmail(email);
                mentee.setPhot(phot);
                
                menteeDao.updateNaver(mentee);
              }
              return mentee;
          } catch (Exception e) {
              System.out.println("에러"+e);
              return null;
          }
  }
}
