package kim.cms.service;

import kim.cms.domain.Mentee;

public interface MenteeService {

  void join(Mentee mentee);
  int checknick(Mentee mentee);
  int checkemail(Mentee mentee);
}
