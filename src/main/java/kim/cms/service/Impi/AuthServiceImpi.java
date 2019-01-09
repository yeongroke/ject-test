package kim.cms.service.Impi;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kim.cms.dao.MenteeDao;
import kim.cms.domain.Mentee;
import kim.cms.service.AuthService;

@Service
public class AuthServiceImpi implements AuthService {

  @Autowired MenteeDao menteeDao;
  
  @Override
  public Mentee findbyemailpwd(String email , String pwd) {
    
    HashMap<String, Object> params = new HashMap<>();
    
    params.put("email", email.toLowerCase());
    params.put("pwd", pwd.toLowerCase());
    
    System.out.println(email.toLowerCase());
    System.out.println(pwd.toLowerCase());
    return menteeDao.findbyemailpwd(params);
  }
}
