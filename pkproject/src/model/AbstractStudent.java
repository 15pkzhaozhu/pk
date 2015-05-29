package model;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudent implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private String name;
	private String phonenum;
	private Integer apartment;
	private String dorminum;

	// Constructors

	/** default constructor */
	public AbstractStudent() {
	}

	/** full constructor */
	public AbstractStudent(Integer stuId, String name, String phonenum,
			Integer apartment, String dorminum) {
		this.stuId = stuId;
		this.name = name;
		this.phonenum = phonenum;
		this.apartment = apartment;
		this.dorminum = dorminum;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public Integer getApartment() {
		return this.apartment;
	}

	public void setApartment(Integer apartment) {
		this.apartment = apartment;
	}

	public String getDorminum() {
		return this.dorminum;
	}

	public void setDorminum(String dorminum) {
		this.dorminum = dorminum;
	}

}