package kim.cms.service;

import kim.cms.domain.Mentee;

public interface AuthService {
  Mentee findbyemailpwd(String email , String pwd);
}
