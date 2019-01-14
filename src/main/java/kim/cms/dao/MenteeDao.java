package kim.cms.dao;

import java.util.Map;
import kim.cms.domain.Mentee;

public interface MenteeDao {
  
  int join(Mentee mentee);
  
  int Naverjoin(Mentee mentee);
  int updateNaver(Mentee mentee);
  
  int checknick(Mentee mentee);
  int checkemail(Mentee mentee);
  
  Mentee findbyemailpwd(Map<String, Object> params);
}
