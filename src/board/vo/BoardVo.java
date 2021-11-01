package board.vo;

public class BoardVo {
	// Fields
	private int    idx;
	private String menu_id;
	private String title;
	private String cont;
	private String writer;
	private String regdate;
	private String cname;
	private int    readcount;
	private int    bnum;
	private int    lvl;
	private int    step;
	private int    nref;
	private int    delnum;
	
	private  int     totalcount;     // 전체 자료수
	
	// 생성자
	public BoardVo() {}
	public BoardVo(int idx, String menu_id, String title, String cont, String writer, String regdate, int readcount,
			int bnum, int lvl, int step, int nref, int delnum) {
		this.idx = idx;
		this.menu_id = menu_id;
		this.title = title;
		this.cont = cont;
		this.writer = writer;
		this.regdate = regdate;
		this.readcount = readcount;
		this.bnum = bnum;
		this.lvl = lvl;
		this.step = step;
		this.nref = nref;
		this.delnum = delnum;
	}
	
	// 조회를 위한 생성자
	public BoardVo(int idx, String menu_id, String title, String cont, String writer, String regdate,
			String cname, int readcount, int bnum, int lvl, int step, int nref, int delnum, int totalcount) {
		this.idx = idx;
		this.menu_id = menu_id;
		this.title = title;
		this.cont = cont;
		this.writer = writer;
		this.regdate = regdate;
		this.cname = cname;
		this.readcount = readcount;
		this.bnum = bnum;
		this.lvl = lvl;
		this.step = step;
		this.nref = nref;
		this.delnum = delnum;
		this.totalcount = totalcount;
	}
	// Getter / Setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getNref() {
		return nref;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}
	public int getDelnum() {
		return delnum;
	}
	public void setDelnum(int delnum) {
		this.delnum = delnum;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	// toString
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", menu_id=" + menu_id + ", title=" + title + ", cont=" + cont + ", writer="
				+ writer + ", regdate=" + regdate + ", cname=" + cname + ", readcount=" + readcount + ", bnum=" + bnum
				+ ", lvl=" + lvl + ", step=" + step + ", nref=" + nref + ", delnum=" + delnum + ", totalcount="
				+ totalcount + "]";
	}

}
