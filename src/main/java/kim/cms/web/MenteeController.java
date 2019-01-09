package kim.cms.web;

import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import kim.cms.domain.Mentee;
import kim.cms.service.MenteeService;


@Controller
@RequestMapping("/mentee")
public class MenteeController {

  MenteeService menteeService;
  ServletContext sc;
  
  public MenteeController(MenteeService menteeService,ServletContext sc) {
    this.menteeService = menteeService;
    this.sc = sc;
  }
  
  @RequestMapping(value = "join", method=RequestMethod.GET)
  public void join(Mentee mentee) {
    
  }
  
  @RequestMapping(value = "join", method=RequestMethod.POST)
  public String join2(Mentee mentee) {
    menteeService.join(mentee);
    
    return "redirect:/app/auth/login";
  }
  
  @RequestMapping(value = "checknick.do", method = { RequestMethod.GET, RequestMethod.POST})
  public @ResponseBody int checknick(Mentee mentee) {
    return menteeService.checknick(mentee);
  }
  
  @RequestMapping(value = "checkemail.do", method = { RequestMethod.GET, RequestMethod.POST})
  public @ResponseBody int checkemail(Mentee mentee) {
    return menteeService.checkemail(mentee);
  }
  
  @RequestMapping("main")
  public void main() {
    
  }
  
  @RequestMapping("login") 
  public void login() {
    
  }
}
