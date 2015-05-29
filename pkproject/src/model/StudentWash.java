package model;

/**
 * StudentWash entity. @author MyEclipse Persistence Tools
 */
public class StudentWash extends AbstractStudentWash implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public StudentWash() {
	}

	/** full constructor */
	public StudentWash(Integer stuId, Integer dannum, Integer zhaonum) {
		super(stuId, dannum, zhaonum);
	}

}
