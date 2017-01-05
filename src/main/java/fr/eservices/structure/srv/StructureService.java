package fr.eservices.structure.srv;

import java.util.List;

import fr.eservices.structure.model.Structure;

public interface StructureService {
	
	public List<Structure> findAll();
	public void create(Structure struct);
	public List<Structure> filterByRegion(String regionName);
	public Structure findStructById(Long id);
	public Structure update(Structure structure);
}