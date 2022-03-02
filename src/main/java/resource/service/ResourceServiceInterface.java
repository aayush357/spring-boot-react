package resource.service;

import java.util.List;

import resource.model.Resource;

public interface ResourceServiceInterface {

	public Resource getResourceDetails(int resourceId);

	public boolean addResource(Resource r);

	public boolean deleteResource(int resourceId);

	public boolean updateReource(Resource r);
	
	public List<Resource> findAll();

}
