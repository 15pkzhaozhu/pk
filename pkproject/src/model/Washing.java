package model;

/**
 * Washing entity. @author MyEclipse Persistence Tools
 */
public class Washing extends AbstractWashing implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Washing() {
	}

	/** full constructor */
	public Washing(String name, Double price) {
		super(name, price);
	}

}
