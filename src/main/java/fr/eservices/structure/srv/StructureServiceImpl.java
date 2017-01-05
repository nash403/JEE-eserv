package fr.eservices.structure.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eservices.structure.dao.StructureDao;
import fr.eservices.structure.model.RoleMock;
import fr.eservices.structure.model.Structure;

@Component
public class StructureServiceImpl implements StructureService {

	@Autowired
	StructureDao dao;

	@Override
	public List<Structure> findAll() {
		if(UserMockService.getCurrentUser().getRole() == RoleMock.ADMIN)
			return dao.listAll();

		return null;
	}

	@Override
	public Structure create(Structure struct) {
		if(UserMockService.getCurrentUser().getRole() == RoleMock.ADMIN) {
			return dao.create(struct);
		}

		return null;
	}

	@Override
	public List<Structure> filterByRegion(String regionName) {
		if(UserMockService.getCurrentUser().getRole() == RoleMock.ADMIN)
			return dao.listByRegion(regionName);

		return null;
	}

	@Override
	public Structure findStructById(Long id) {
		if(UserMockService.getCurrentUser().getRole() == RoleMock.ADMIN)
			return dao.findById(id);

		return null;
	}

	@Override
	public Structure update(Structure structure) {
		if(UserMockService.getCurrentUser().getRole() == RoleMock.ADMIN)
			return dao.update(structure);

		return null;
	}


}
