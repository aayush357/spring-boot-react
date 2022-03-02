package resource.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import resource.dao.ResourceDAOInterface;
import resource.model.Resource;

@Service
public class ResourceService implements ResourceServiceInterface {

	@Autowired
	private ResourceDAOInterface resourceDaoInterface;

	@Override
	public Resource getResourceDetails(int resourceId) {
		Optional<Resource> x = resourceDaoInterface.findById(resourceId);
		Resource r = new Resource(-1, "whocares", false);
		if (x.isPresent()) {
			r = x.get();
		}
		return r;
	}

	@Override
	public boolean addResource(Resource r) {
		Optional<Resource> x = resourceDaoInterface.findById(r.getResourceId());
		boolean added = false;
		if (x.isPresent()) {
			added = false;
		} else {
			try {
				resourceDaoInterface.save(r);
				added = true;
			} catch (Exception e) {
				e.printStackTrace();
				added = false;
			}
		}
		return added;
	}

	@Override
	public boolean deleteResource(int resourceId) {
		boolean del = false;
		try {
			resourceDaoInterface.deleteById(resourceId);
			del = true;
		} catch (Exception e) {
			del = false;
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public boolean updateReource(Resource r) {
		Optional<Resource> rd = resourceDaoInterface.findById(r.getResourceId());
		Resource updated = new Resource();
		if (rd.isPresent()) {
			updated = rd.get();
			updated.setAvaialability(r.isAvaialability());
			updated.setResourceName(r.getResourceName());
			resourceDaoInterface.save(updated);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Resource> findAll() {
		List<Resource> allResource = resourceDaoInterface.findAll();
		return allResource;
	}

}
