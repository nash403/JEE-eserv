package fr.eservices.structure.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.eservices.structure.model.Structure;

public class StructureDaoImpl implements StructureDao {
	
	EntityManager em;
	EntityManagerFactory emf;
	EntityTransaction tx;
	
	public void setManager(String name) {
		emf = Persistence.createEntityManagerFactory(name);
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public void close() {
		em.close();
		emf.close();
	}

	@Override
	public List<Structure> listAll() {
		return em.createQuery("select s from Structure s",Structure.class).getResultList();
	}

	@Override
	public List<Structure> listByRegion(String region_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Structure findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Structure struct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Structure struct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
}