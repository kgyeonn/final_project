package project3;

public class RankVO {

	private String region;
	private int totalPoint;
	private int countId;
	public RankVO(String region, int totalPoint, int countId) {
		super();
		this.region = region;
		this.totalPoint = totalPoint;
		this.countId = countId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	public int getCountId() {
		return countId;
	}
	public void setCountId(int countId) {
		this.countId = countId;
	}

	
}
