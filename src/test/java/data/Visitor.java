package data;

/**
 * 
 * @author cloverdolphin
 *
 */
public class Visitor {
	
	private String visitorName = "";
	private String visitorCompany = "";
	private String visitorLocation = "";
	private String visitorHost = "";
	
	public Visitor(String vName, String vCompany, String vLocation, String vHost) {
		this.visitorName = vName;
		this.visitorCompany = vCompany;
		this.visitorLocation = vLocation;
		this.visitorHost = vHost;
	}
	
	// use default values when 'location' and 'host' not providing
	public Visitor(String vName, String vCompany) {
		this.visitorName = vName;
		this.visitorCompany = vCompany;
	}
	
	// get all information of the visitor
	public String getVisitorInfo(Visitor v) {
		String info = String.format("visitor info: name=%s, company=%s, location=%s, visiting=%s ", v.visitorName, v.visitorCompany, v.visitorLocation, v.visitorHost );
		return info;
	}

	// ===================== getter ========================
	public String getVisitorName() {
		return this.visitorName;
	}
	
	public String getVisitorCompany() {
		return this.visitorCompany;
	}
	
	public String getVisitoLocation() {		
		return this.visitorLocation;
	}
	
	public String getVisitorHost() {
		return this.visitorHost;
	}
	
	// ====================== setter ========================
	public void setVisitorName(String name) {
		this.visitorName = name;
	}
	
	public void setVisitorCompany(String company) {
		this.visitorCompany = company;
	}
	
	public void setVisitorLocation(String location) {
		this.visitorLocation = location;
	}
	
	public void setVisitorHost(String host) {
		this.visitorHost = host;
	}
}
