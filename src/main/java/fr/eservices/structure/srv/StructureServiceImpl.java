package fr.eservices.structure.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eservices.structure.dao.StructureDao;
import fr.eservices.structure.model.Structure;

@Component
public class StructureServiceImpl implements StructureService {
	
	@Autowired
	StructureDao dao;
		
	@Override
	public List<Structure> findAll() {
		return dao.listAll();
	}

	@Override
	public void create(Structure struct) {
		dao.create(struct);
	}

	@Override
	public List<Structure> filterByRegion(String regionName) {
		return dao.listByRegion(regionName);
	}
	
	@Override
	public Structure findStructById(Long id) {
		return dao.findById(id);
	}

	@Override
	public Structure update(Structure structure) {
		return dao.update(structure);
	}
	
	
}