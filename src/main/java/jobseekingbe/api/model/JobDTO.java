package jobseekingbe.api.model;


public class JobDTO {
	private Long id;
	private String description;
	private String location;
	private String title;
    private String Logo;
    private String[] Industry;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String[] getIndustry() {
		return Industry;
	}
	public void setIndustry(String[] industry) {
		Industry = industry;
	}
    
    
}
