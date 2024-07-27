package model.school;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import model.student.Student;

@Entity

/*
 * Lombok annotations
 * @Getter
 * 
 * @Setter
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 */
public class School {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String city;
	
	@OneToMany(targetEntity = Student.class)
	private Set<Student> addStudent = new HashSet<>();
	

	/**
	 * @param name
	 * @param city
	 */
	public School(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	public School() {}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the stdSchool
	 */
	public Set<Student> getAddStudent() {
		return addStudent;
	}

	/**
	 * @param addstd the stdSchool to set
	 */
	public void setAddStudent(Set<Student> addstd) {
		this.addStudent = addstd;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", city=" + city + ", AddStudent =" + addStudent + "]";
	}
	
	public String toStringsch() {
		return "School [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
