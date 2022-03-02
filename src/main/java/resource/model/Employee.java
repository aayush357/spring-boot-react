package resource.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	private int empid;
	@ManyToMany(mappedBy= "employees")
	private Collection<Resource> resources;
}
