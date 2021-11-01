package member.vo;

public class MemberVo {
	// Fields
	private int    rn;
	private String cid;
	private String cpwd;
	private String cname;
	private String cbirth;
	private String cemail;
	private String cresult;
	private String resday;
	
	private  int     totalcount;     // 전체 자료수
	
	// 생성자
	public MemberVo() {}
	// 페이징 목록 조회를 위한 생성자
	public MemberVo(int rn, String cid, String cpwd, String cbirth, String cname, String cemail, String cresult, String resday, int totalcount) {
		this.rn = rn;
		this.cid = cid;
		this.cpwd = cpwd;
		this.cbirth = cbirth;
		this.cname = cname;
		this.cemail = cemail;
		this.cresult = cresult;
		this.resday = resday;
		this.totalcount = totalcount;
	}
	// 아이디 조회를 위한 생성자
	public MemberVo(String cid, String cpwd) {
		this.cid = cid;
		this.cpwd = cpwd;
	}
	// 이름을 위한 생성자
	public MemberVo(String cname) {
		this.cname = cname;
	}
	public MemberVo(int rn, String cid, String cpwd, String cbirth, String cname, String cemail, String cresult, String resday) {
		this.rn = rn;
		this.cid = cid;
		this.cpwd = cpwd;
		this.cbirth = cbirth;
		this.cname = cname;
		this.cemail = cemail;
		this.cresult = cresult;
		this.resday = resday;
	}
	public MemberVo(String cid, String cpwd, String cname, String cbirth, String cemail) {
		this.cid = cid;
		this.cpwd = cpwd;
		this.cname = cname;
		this.cbirth = cbirth;
		this.cemail = cemail;
	}
	// Getter / Setter
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getCbirth() {
		return cbirth;
	}
	public void setCbirth(String cbirth) {
		this.cbirth = cbirth;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCresult() {
		return cresult;
	}
	public void setCresult(String cresult) {
		this.cresult = cresult;
	}
	public String getResday() {
		return resday;
	}
	public void setResday(String resday) {
		this.resday = resday;
	}
	
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberVo [cid=" + cid + ", cpwd=" + cpwd + ", cbirth=" + cbirth + ", cname=" + cname + ", cemail="
				+ cemail + ", cresult=" + cresult + ", resday=" + resday + "]";
	}
}
