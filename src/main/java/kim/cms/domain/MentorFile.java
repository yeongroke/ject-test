package kim.cms.domain;

public class MentorFile {
  private int no;
  private String mfname;
  private int mono;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getMfname() {
    return mfname;
  }
  public void setMfname(String mfname) {
    this.mfname = mfname;
  }
  public int getMono() {
    return mono;
  }
  public void setMono(int mono) {
    this.mono = mono;
  }
  @Override
  public String toString() {
    return "MentorFile [no=" + no + ", mfname=" + mfname + ", mono=" + mono + "]";
  }
  

  
}
