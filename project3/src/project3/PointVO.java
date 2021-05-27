package project3;

public class PointVO {

	private String member_id;
	private int point_p;
	private String point_date;
	private String point_content;
	
	public PointVO(String member_id, int point_p, String point_date, String point_content) {
		super();
		
		this.member_id = member_id;
		this.point_p = point_p;
		this.point_date = point_date;
		this.point_content = point_content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getPoint_p() {
		return point_p;
	}
	public void setPoint_p(int point_p) {
		this.point_p = point_p;
	}
	public String getPoint_date() {
		return point_date;
	}
	public void setPoint_date(String point_date) {
		this.point_date = point_date;
	}
	public String getPoint_content() {
		return point_content;
	}
	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}
	
}	
