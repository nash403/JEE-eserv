package fr.eservices.structure.dao;

import java.util.List;

import fr.eservices.structure.model.Structure;

public interface StructureDAO {
	
	public List<Structure> listAll();
	public List<Structure> listByRegion(String region_name);
	public Structure findById(long id);
	
	public void create(Structure struct);
	public void update(Structure struct);
	public void delete(long id);
}