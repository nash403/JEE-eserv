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
		List<Structure> res = new ArrayList<>();

		res = em.createQuery("SELECT s FROM Structure s where s.region = :region_name")
		.setParameter("region_name", region_name)
		getResultList();

		return res;
	}

	@Override
	public Structure findById(long id) {
		return em.find(Structure.class, id);
	}

	@Override
	public void create(Structure struct) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Structure struct) {
		int updatedStruct = em.createQuery("UPDATE Structure SET name = :name, street = :street, region = :region, city = :city, country = :country, status = :status WHERE id = :id")
		.setParameter("name", struct.getName())
		.setParameter("street", struct.getStreet())
		.setParameter("region", struct.getRegion())
		.setParameter("city", struct.getCity())
		.setParameter("status", struct.getStatus())
		.setParameter("id", struct.getId())
		.executeUpdate();

		return updatedStruct == 1 ? struct : null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
