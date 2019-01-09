package kim.cms.web;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kim.cms.domain.Mentee;
import kim.cms.service.AuthService;
import kim.cms.service.MenteeService;


@Controller
@RequestMapping("/auth")
public class AuthController {

  MenteeService menteeService;
  AuthService authService;
  ServletContext sc;
  
  public AuthController(MenteeService menteeService, AuthService authService,
      ServletContext sc) {
    this.menteeService = menteeService;
    this.authService = authService;
    this.sc = sc;
  }
  
  @GetMapping("login") 
  public void login() {
    
  }
  
  @PostMapping("login.do") 
  public @ResponseBody int logindo(String email , String pwd , String save , HttpSession session , HttpServletResponse response) {
    
    if(save != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 30);
      response.addCookie(cookie);
      Cookie cookie2 = new Cookie("save", "checked");
      cookie.setMaxAge(60 * 60 * 24 * 30);
      response.addCookie(cookie2);
    } else {
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
      Cookie cookie2 = new Cookie("save", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie2);
    }
    
    Mentee loginUser = authService.findbyemailpwd(email, pwd);
    if(loginUser != null) {
      session.setAttribute("loginUser", loginUser);
      return 1;
    } else {
      session.invalidate();
      return 0;
    }
  }
}
