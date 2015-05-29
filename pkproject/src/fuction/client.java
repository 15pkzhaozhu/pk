package fuction;

import model.StudentWash;

public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InforSearch is = new InforSearch();
		//is.addStuToDB(131110134, "’‘÷˘", "1", 9, "131b");
		Payment p = new Payment();
		//System.out.print(p.paySingle(131110101));
		//System.out.print(p.payDorminary(9, "131b"));
		//System.out.print(is.getStudentByID(131110134).getName());
		//System.out.print(is.getPriceByName("±ªµ•"));
	    //is.addStuToDB("cao", "123", 9, "131");
		//StudentWash a = (StudentWash)is.getAllStudentwash().get(0);
		//System.out.print(is.getStudentwashByID(131110102).getDannum());
		//is.deletelStudentwashByID(131110101);
		is.delete(9, "131b");

	}

}
