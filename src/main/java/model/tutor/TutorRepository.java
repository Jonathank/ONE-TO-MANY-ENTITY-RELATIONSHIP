package model.tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TutorRepository {

	private EntityManager em;
	private EntityManagerFactory emf;

	public TutorRepository() {
		this.emf = Persistence.createEntityManagerFactory("Student_PU");
		this.em = this.emf.createEntityManager();
	}
	public TutorRepository(String PU) {
		this.emf = Persistence.createEntityManagerFactory(PU);
		this.em = this.emf.createEntityManager();
	}

	//adds tutor
	public Tutor addTutor(Tutor tutor) {
		em.getTransaction().begin();
		em.persist(tutor);
		em.getTransaction().commit();

		return tutor;
	}
	
	//returns tutor object by their id
	public Tutor find(long id) {
		return em.find(Tutor.class, id);
	}
	
	//updates tutor details
	public Tutor updateTutor(Tutor tutor) {
		Tutor tutorUpdate = find(tutor.getId());
		em.getTransaction().begin();
		tutorUpdate.setFname(tutor.getFname());
		tutorUpdate.setLname(tutor.getLname());
		em.getTransaction().commit();
		return tutorUpdate;
	}

	
	
	//deletes tutor object from db
		public void deleteTutor(Tutor tutor) {
			Tutor tutorUpdate = find(tutor.getId());
			em.getTransaction().begin();
			em.remove(tutorUpdate);
			em.getTransaction().commit();
		}
		
	
		
	public void close() {
		this.em.close();
		this.emf.close();
	}
}
