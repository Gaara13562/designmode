package t11_chainOfResp;

/**
 * 待处理请求的实体类
 */
public class Request {

	private Leader sponsor; // 请求的发起者
	private int days; // 申请时长
	private String reason; // 理由

	public Request() {
		super();
	}

	public Request(Leader sponsor, int days, String reason) {
		super();
		this.sponsor = sponsor;
		this.days = days;
		this.reason = reason;
	}

	public Leader getSponsor() {
		return sponsor;
	}

	public void setSponsor(Leader sponsor) {
		this.sponsor = sponsor;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void beHandled() {
		this.getSponsor().handleRequest(this);
	}
}
