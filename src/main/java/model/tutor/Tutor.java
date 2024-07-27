package model.tutor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//auto_increment
	private long id;
	
	@Column(name = "first_name",nullable = false, length = 150)
	private String fname;
	@Column(name = "last_name", nullable = false, length = 150)
	private String lname;
	
	public Tutor() {}
	/**
	 * @param id
	 * @param fname
	 * @param lname
	 */
	public Tutor(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
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
	@Override
	public String toString() {
		return "Tutor [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
	
	
}
