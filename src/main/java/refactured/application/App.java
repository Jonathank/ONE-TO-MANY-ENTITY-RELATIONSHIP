/**
 * 
 */
package refactured.application;

import model.school.School;
import model.school.SchoolRepository;
import model.student.Student;
import model.tutor.Tutor;
import model.tutor.TutorRepository;
import refactured.studentUtilities.StudentRepository;

/**
 * @author JONATHAN
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Student std = new Student();
		std.setFname("BAMUJJE");
		std.setLname("HERMAN");
		
		StudentRepository rep;
		SchoolRepository schrep = new SchoolRepository();
		TutorRepository tutorRep = new TutorRepository();
		
		rep = new StudentRepository();
		rep.addStudent(std);
		System.out.println("\nADDED STUDENT  : " + std.toString());
		
		Tutor tutor = new Tutor("Kamoga","Alex");
		tutorRep.addTutor(tutor);
		System.out.println("\nNEW ADDED TUTOR  : " + tutor.toString());
		
		
		tutor = tutorRep.find(tutor.getId());
		rep.addStdTutor(std.getId(),tutor );
		System.out.println("\nADDED TUTOR TO STUDENT : " + std.toString());
		
		
		School sch = new School("Nana Schools","Kampala");
		schrep.addSchool(sch);
		System.out.println("\nNEW SCHOOL ADDED  : " + sch.toStringsch());
		
		
		std = rep.findbyId(std.getId());
		sch = schrep.find(sch.getId());
		schrep.addStudentToSch(sch.getId(), std);
		System.out.println("\nSTUDENT ADDED TO SCHOOL : " + sch.toString());
		//
		
		rep.findfirstnames().forEach(System.out::println);
		
		rep.findlasttnames().forEach(System.out::println);

		std = rep.findbyId(std.getId());
		System.out.println("\nFOUND STUDENT BY ID  : " + std.toString());
		
		rep.findStudent(std.getId());
		System.out.println("\nFOUND STUDENT  : " + std.toString());

		std.setFname("KING");
		std.setLname("NEUTON");
		rep.updateStudent(std);
		System.out.println("\nUPDATED STUDENT  : " + std.toString());

		std = rep.updateFirstName("KYEYUNE",std.getId());
		System.out.println("\nNEW UPDATED FIRST NAME  : >>>>" + std.toString());

		std = rep.updateLastName("HERMAN",std.getId());
		System.out.println("\nNEW UPDATED LAST NAME  : >>>>" + std.toString());

		//rep.deletestdbyId(std.getId());
		//System.out.println("\nDELETED STUDENT BY ID : >>>>" + std.toString());


		rep.close();
	}

}
