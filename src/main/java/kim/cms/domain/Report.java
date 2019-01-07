package kim.cms.domain;

import java.sql.Date;
import java.util.List;

public class Report {
  private int no;
  private String titl; // 제목
  private String conts; // 내용
  private String url; // URL
  private String type; // 신고유형
  private String type_detail; // 분류
  private Date rtdt; // 신고일
  private int meno; // 신고자
  private int meno2; // 피신고자
  private char stat; // 신고 상태

  private String menteeNick; // 신고자 닉네임
  private String mentee2Email; // 피신고자 이메일
  private String mentee2Nick; // 피신고자 닉네임

  private int cnt;

  private List<Report> finishlist;


  public List<Report> getFinishlist() {
    return finishlist;
  }

  public void setFinishlist(List<Report> finishlist) {
    this.finishlist = finishlist;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitl() {
    return titl;
  }

  public void setTitl(String titl) {
    this.titl = titl;
  }

  public String getConts() {
    return conts;
  }

  public void setConts(String conts) {
    this.conts = conts;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType_detail() {
    return type_detail;
  }

  public void setType_detail(String type_detail) {
    this.type_detail = type_detail;
  }

  public Date getRtdt() {
    return rtdt;
  }

  public void setRtdt(Date rtdt) {
    this.rtdt = rtdt;
  }

  public int getMeno() {
    return meno;
  }

  public void setMeno(int meno) {
    this.meno = meno;
  }

  public int getMeno2() {
    return meno2;
  }

  public void setMeno2(int meno2) {
    this.meno2 = meno2;
  }

  public String getMenteeNick() {
    return menteeNick;
  }

  public void setMenteeNick(String menteeNick) {
    this.menteeNick = menteeNick;
  }

  public String getMentee2Email() {
    return mentee2Email;
  }

  public void setMentee2Email(String mentee2Email) {
    this.mentee2Email = mentee2Email;
  }

  public String getMentee2Nick() {
    return mentee2Nick;
  }

  public void setMentee2Nick(String mentee2Nick) {
    this.mentee2Nick = mentee2Nick;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public char getStat() {
    return stat;
  }

  public void setStat(char stat) {
    this.stat = stat;
  }

  @Override
  public String toString() {
    return "Report [no=" + no + ", titl=" + titl + ", conts=" + conts + ", url=" + url + ", type="
        + type + ", type_detail=" + type_detail + ", rtdt=" + rtdt + ", meno=" + meno + ", meno2="
        + meno2 + ", stat=" + stat + ", menteeNick=" + menteeNick + ", mentee2Email=" + mentee2Email
        + ", mentee2Nick=" + mentee2Nick + ", cnt=" + cnt + ", finishlist=" + finishlist + "]";
  }



}
