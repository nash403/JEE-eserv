package fr.eservices.structure.srv;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.eservices.structure.dao.StructureDao;
import fr.eservices.structure.dao.StructureDaoFactory;
import fr.eservices.structure.model.Structure;

@Component
public class StructureServiceImpl implements StructureService {
	
	StructureDao dao = StructureDaoFactory.createStructureDao();
		
	@Override
	public List<Structure> findAll() {
		return dao.listAll();
	}

	@Override
	public void create(Structure struct) {
		dao.create(struct);
	}
	
}