package kim.cms.web;

import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import kim.cms.service.MenteeService;


@Controller
@RequestMapping("/mainpage")
public class MainController {

  MenteeService menteeService;
  ServletContext sc;
  
  public MainController(MenteeService menteeService,ServletContext sc) {
    this.menteeService = menteeService;
    this.sc = sc;
  }
  
  @RequestMapping("main")
  public void main() {
    
  }
  
}
