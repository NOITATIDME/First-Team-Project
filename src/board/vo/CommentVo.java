package board.vo;

public class CommentVo {
	// 필드
	private int comment_rn;
	private int comment_idx;
	private int comment_hboard;
	private String comment_writer;
	private String comment_regdate;
	private String comment_cont;
	private int comment_bnum;
	private int comment_lvl;
	private int comment_step;
	private int comment_nref;
	private int comment_delnum;
	
	private  int     totalcount;
	
	// 생성자
	public CommentVo() {}
	public CommentVo(int comment_rn, int comment_idx, int comment_hboard, String comment_writer,
			String comment_regdate, String comment_cont, int comment_bnum, int comment_lvl, int comment_step,
			int comment_nref, int comment_delnum, int totalcount) {
		this.comment_rn = comment_rn;
		this.comment_idx = comment_idx;
		this.comment_hboard = comment_hboard;
		this.comment_writer = comment_writer;
		this.comment_regdate = comment_regdate;
		this.comment_cont = comment_cont;
		this.comment_bnum = comment_bnum;
		this.comment_lvl = comment_lvl;
		this.comment_step = comment_step;
		this.comment_nref = comment_nref;
		this.comment_delnum = comment_delnum;
		this.totalcount = totalcount;
	}

	// Getter/ Setter

	public int getComment_rn() {
		return comment_rn;
	}
	public void setComment_rn(int comment_rn) {
		this.comment_rn = comment_rn;
	}
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public int getComment_hboard() {
		return comment_hboard;
	}
	public void setComment_hboard(int comment_hboard) {
		this.comment_hboard = comment_hboard;
	}
	public String getComment_writer() {
		return comment_writer;
	}
	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}
	public String getComment_regdate() {
		return comment_regdate;
	}
	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
	}
	public String getComment_cont() {
		return comment_cont;
	}
	public void setComment_cont(String comment_cont) {
		this.comment_cont = comment_cont;
	}
	public int getComment_bnum() {
		return comment_bnum;
	}
	public void setComment_bnum(int comment_bnum) {
		this.comment_bnum = comment_bnum;
	}
	public int getComment_lvl() {
		return comment_lvl;
	}
	public void setComment_lvl(int comment_lvl) {
		this.comment_lvl = comment_lvl;
	}
	public int getComment_step() {
		return comment_step;
	}
	public void setComment_step(int comment_step) {
		this.comment_step = comment_step;
	}
	public int getComment_nref() {
		return comment_nref;
	}
	public void setComment_nref(int comment_nref) {
		this.comment_nref = comment_nref;
	}
	public int getComment_delnum() {
		return comment_delnum;
	}
	public void setComment_delnum(int comment_delnum) {
		this.comment_delnum = comment_delnum;
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
		return "CommentVo [comment_rn=" + comment_rn + ", comment_idx=" + comment_idx + ", comment_hboard="
				+ comment_hboard + ", comment_writer=" + comment_writer + ", comment_regdate=" + comment_regdate
				+ ", comment_cont=" + comment_cont + ", comment_bnum=" + comment_bnum + ", comment_lvl=" + comment_lvl
				+ ", comment_step=" + comment_step + ", comment_nref=" + comment_nref + ", comment_delnum="
				+ comment_delnum + ", totalcount=" + totalcount + "]";
	}

}
