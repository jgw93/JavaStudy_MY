package JGW_TEST_240318;

public class ToolDTO {
	private String toolname;
	private String toolserial;
	private String inventory;
	private String location;
	private String manager;
	public String getId() {
		return toolname;
	}
	public String getToolname() {
		return toolname;
	}
	public void setToolname(String toolname) {
		this.toolname = toolname;
	}
	public String getToolserial() {
		return toolserial;
	}
	public void setToolserial(String toolserial) {
		this.toolserial = toolserial;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "ToolDTO [toolname=" + toolname + ", toolserial=" + toolserial + ", inventory=" + inventory + ","
				+ " location=" + location + ", manager=" + manager + "]";
				
	}
	public void setInventory1(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}
	public void setId1(String id) {
		// TODO Auto-generated method stub
		
	}
}
