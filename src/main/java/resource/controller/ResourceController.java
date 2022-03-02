package resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import resource.model.Resource;
import resource.service.ResourceServiceInterface;

@RestController
@CrossOrigin("*")
public class ResourceController {

	@Autowired
	private ResourceServiceInterface resourceServiceInterface;

	// http://localhost:7777/gr/3
	@GetMapping("/gr/{resourceId}")
	public Resource getResourceDetails(@PathVariable int resourceId) {
		return resourceServiceInterface.getResourceDetails(resourceId);

	}

	// erquest body somebody has to supply resource object.
	// as a json spring will convert that into java object
	@PostMapping("/ar")
	public boolean addResource(@RequestBody Resource r) {
		return resourceServiceInterface.addResource(r);
	}

	@PutMapping("/ur")
	public boolean updateResource(@RequestBody Resource r) {
		return resourceServiceInterface.updateReource(r);
	}

	@DeleteMapping("/dr")
	public boolean deleteResource(@RequestParam("id") int resourceId) {
		return resourceServiceInterface.deleteResource(resourceId);
	}
	
	@GetMapping("/all")
	public List<Resource> getAll(){
		return resourceServiceInterface.findAll();
	}

}
