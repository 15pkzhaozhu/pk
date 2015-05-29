package model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Integer stuId, String name, String phonenum,
			Integer apartment, String dorminum) {
		super(stuId, name, phonenum, apartment, dorminum);
	}

}
