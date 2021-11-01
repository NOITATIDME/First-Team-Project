package survey.vo;

public class SurveyVo {
	
	// Field
	private int    face_num;  // 얼굴형번호
	private String face_name; // 얼굴형이름
	private String hair_id;   // 헤어아이디
	private String hair_name; // 헤어이름
	private String resday;    // 예약일
	private String cid;       // 회원아이디
	
	// Constructor
	public SurveyVo() {
		
	}
	
	public SurveyVo(int face_num, String face_name, String hair_id, String hair_name, String resday, String cid) {
		this.face_num = face_num;
		this.face_name = face_name;
		this.hair_id = hair_id;
		this.hair_name = hair_name;
		this.resday = resday;
		this.cid = cid;
	}
	
	public SurveyVo(String hair_id, String hair_name) {
		this.hair_id = hair_id;
		this.hair_name = hair_name;
	}

	public SurveyVo(String face_name, String hair_id, String hair_name) {
		this.face_name = face_name;
		this.hair_id = hair_id;
		this.hair_name = hair_name;
	}
	
	public SurveyVo(int face_num, String face_name, String hair_id, String hair_name) {
		this.face_num = face_num;
		this.face_name = face_name;
		this.hair_id = hair_id;
		this.hair_name = hair_name;
	}

	// Getter / Setter
	public int getFace_num() {
		return face_num;
	}
	public void setFace_num(int face_num) {
		this.face_num = face_num;
	}
	public String getFace_name() {
		return face_name;
	}
	public void setFace_name(String face_name) {
		this.face_name = face_name;
	}
	public String getHair_id() {
		return hair_id;
	}
	public void setHair_id(String hair_id) {
		this.hair_id = hair_id;
	}
	public String getHair_name() {
		return hair_name;
	}
	public void setHair_name(String hair_name) {
		this.hair_name = hair_name;
	}
	public String getResday() {
		return resday;
	}
	public void setResday(String resday) {
		this.resday = resday;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	// toString
	@Override
	public String toString() {
		return "SurveyVo [face_num=" + face_num + ", face_name=" + face_name + ", hair_id=" + hair_id + ", hair_name="
				+ hair_name + ", resday=" + resday + "]";
	}
	
}
