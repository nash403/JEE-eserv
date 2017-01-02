package fr.eservices.structure.dao;

public class StructureDaoFactory {
	public static StructureDao createStructureDao() {
		StructureDaoImpl dao = new StructureDaoImpl();
		dao.setManager("structureApp");
		return dao;
		
	}
}
