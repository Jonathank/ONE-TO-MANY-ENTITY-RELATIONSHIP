package model.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.tutor.Tutor;

@Entity
@Table(name = "students")
@NamedQuery(name = "find student by id", query = "Select s from Student s where s.id = :id")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//auto_increment
	private long id;
	
	@Column(name = "first_name",nullable = false, length = 150)
	private String fname;
	@Column(name = "last_name", nullable = false, length = 150)
	private String lname;
	
	@OneToOne
	private Tutor tutor;
	

	public Student(long id, String fn, String ln) {
		this.id = id;
		this.fname = fn;
		this.lname = ln;
	}
	
	public Student() {
		
	}
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
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the tutor
	 */
	public Tutor getTutor() {
		return tutor;
	}

	/**
	 * @param tutor the tutor to set
	 */
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	
	
	@Override
	public String toString() {
		return "\nStudent [id=" + id + "\n fname=" + fname + "\n lname=" + lname + "\n tutor=" + tutor + "]";
	}
}
