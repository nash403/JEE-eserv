package fr.eservices.structure.dao;	

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.eservices.structure.model.Structure;


@Component
public class StructureDaoImpl implements StructureDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Structure> listAll() {
		return em.createQuery("select s from Structure s ",Structure.class).getResultList();
	}

	@Override
	public List<Structure> listByRegion(String region_name) {
		return em
			.createQuery("SELECT s FROM Structure s where UPPER(s.region) like :region_name", Structure.class)
			.setParameter("region_name", "%"+region_name.toUpperCase()+"%")
			.getResultList();
	}

	@Override
	public Structure findById(long id) {
		return em.find(Structure.class, id);
	}

	@Override
	@Transactional
	public Structure create(Structure struct) {
		if(!em.contains(struct)){
			em.persist(struct);
			em.flush();
			return struct;		
		}else{
			return null;
		}
	}

	@Override
	@Transactional
	public Structure update(Structure struct) {
		int updatedStruct = em.createQuery("UPDATE Structure SET name = :name, street = :street, region = :region, city = :city, country = :country, status = :status, zipcode = :zipcode WHERE id = :id")
		.setParameter("name", struct.getName())
		.setParameter("street", struct.getStreet())
		.setParameter("region", struct.getRegion())
		.setParameter("city", struct.getCity())
		.setParameter("country", struct.getCountry())
		.setParameter("status", struct.getStatus())
		.setParameter("id", struct.getId())
		.setParameter("zipcode", struct.getZipcode())
		.executeUpdate();
		return updatedStruct == 1 ? struct : null;
	}

	@Override
	public void delete(long id) {
		Structure structureToDelete = this.findById(id);
		if(structureToDelete != null){
			em.remove(structureToDelete);
		}
	}

	public EntityManager getEm() {
		return em;
	}
	
}
