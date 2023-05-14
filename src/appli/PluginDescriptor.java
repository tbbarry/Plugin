package appli;

public class PluginDescriptor  {
	public String name;
	public String categorie;
	public Boolean autoRun ;
	public StatusPlugin status;
	public StatusPlugin getStatus() {
		return status;
	}
	public void setStatus(StatusPlugin status) {

		this.status = status;
	}
	public Boolean getAutoRun() {
		return autoRun;
	}
	public void setAutoRun(Boolean autoRun) {
		this.autoRun = autoRun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PluginDescriptor(String name, String description, String className, String categorie, Boolean autoRun) {
		super();
		this.name = name;
		this.description = description;
		this.className = className;
		this.categorie = categorie;
		this.autoRun = autoRun;
		this.status = StatusPlugin.attente;
	}
	
	public PluginDescriptor() {
		this.name = "";
		this.description = "";
		this.className = "";
		this.categorie = "";
		this.autoRun = true;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String description;
	public String className;

}
