package kim.cms.service.Impi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import kim.cms.dao.MenteeDao;
import kim.cms.domain.Mentee;
import kim.cms.service.MenteeService;

@Service
public class MenteeServiceImpi implements MenteeService {
  
  @Autowired MenteeDao menteeDao;

  @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
  @Override
  public void join(Mentee mentee) {
    mentee.setSell('N');
    mentee.setStat('N');
    mentee.setMtstat('N');
    
    menteeDao.join(mentee);
  }

  @Override
  public int checknick(Mentee mentee) {
    System.out.println(menteeDao.checknick(mentee));
    return menteeDao.checknick(mentee);
  }

  @Override
  public int checkemail(Mentee mentee) {
    
    return menteeDao.checkemail(mentee);
  }
  
  
}
