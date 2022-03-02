package resource.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Resource {
	
	@Id
	private int resourceId; 
	
	private String resourceName;
	private boolean avaialability;
	@ManyToMany
	@JoinTable(
		joinColumns = @JoinColumn(name = "employee_id")
	)
	private Collection<Employee> employees = new ArrayList<Employee>();
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public boolean isAvaialability() {
		return avaialability;
	}
	public void setAvaialability(boolean avaialability) {
		this.avaialability = avaialability;
	}
	public Resource(int resourceId, String resourceName, boolean avaialability) {
		
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.avaialability = avaialability;
	}
	public Resource() {
		// TODO Auto-generated constructor stub
	}
	
	

}
