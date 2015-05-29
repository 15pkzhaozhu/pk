package model;

/**
 * AbstractStudentWash entity provides the base persistence definition of the
 * StudentWash entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudentWash implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private Integer dannum;
	private Integer zhaonum;

	// Constructors

	/** default constructor */
	public AbstractStudentWash() {
	}

	/** full constructor */
	public AbstractStudentWash(Integer stuId, Integer dannum, Integer zhaonum) {
		this.stuId = stuId;
		this.dannum = dannum;
		this.zhaonum = zhaonum;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Integer getDannum() {
		return this.dannum;
	}

	public void setDannum(Integer dannum) {
		this.dannum = dannum;
	}

	public Integer getZhaonum() {
		return this.zhaonum;
	}

	public void setZhaonum(Integer zhaonum) {
		this.zhaonum = zhaonum;
	}

}