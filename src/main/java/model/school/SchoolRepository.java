package model.school;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.student.Student;

public class SchoolRepository {

	private EntityManager em;
	private EntityManagerFactory emf;

	public SchoolRepository() {
		this.emf = Persistence.createEntityManagerFactory("Student_PU");
		this.em = this.emf.createEntityManager();
	}
	public SchoolRepository(String PU) {
		this.emf = Persistence.createEntityManagerFactory(PU);
		this.em = this.emf.createEntityManager();
	}

	//adds school
	public School addSchool(School sch) {
		em.getTransaction().begin();
		em.persist(sch);
		em.getTransaction().commit();

		return sch;
	}
	
	//returns student object by their id
	public School find(long id) {
		return em.find(School.class, id);
	}
	
	//updates students details
	public School updateSchool(School sch) {
		School schUpdate = find(sch.getId());
		em.getTransaction().begin();
		schUpdate.setName(sch.getName());
		schUpdate.setCity(sch.getCity());
		em.getTransaction().commit();
		return schUpdate;
	}

	
	
	//deletes student object from db
		public void deleteStudent(School sch) {
			School schUpdate = find(sch.getId());
			em.getTransaction().begin();
			em.remove(schUpdate);
			em.getTransaction().commit();
		}
		
		//add student to a school
		public void addStudentToSch(long id, Student std) {
			em.getTransaction().begin();
			School sch = find(id);
			if(sch != null) {
				sch.getAddStudent().add(std);
				}
			em.getTransaction().commit();
		}
	//removes student from school
		public void removeStdFromSch(long id,Student std) {
			em.getTransaction().begin();
			School sch = find(id);
			if(sch != null) {
				sch.getAddStudent().remove(std);
			}
			em.getTransaction().commit();
		}
		
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
