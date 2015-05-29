package model;

/**
 * AbstractWashing entity provides the base persistence definition of the
 * Washing entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWashing implements java.io.Serializable {

	// Fields

	private String name;
	private Double price;

	// Constructors

	/** default constructor */
	public AbstractWashing() {
	}

	/** full constructor */
	public AbstractWashing(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}