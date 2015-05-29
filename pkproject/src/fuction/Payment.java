package fuction;

import model.StudentWash;

public class Payment {
	public double paySingle(int stuID)
	{
		InforSearch is = new InforSearch();
		double totalCost = 0;
		int dannum = 0;
		dannum = is.getStudentwashByID(stuID).getDannum();
		int zhaonum = is.getStudentwashByID(stuID).getZhaonum();
		totalCost = dannum*is.getPriceByName("±ªµ•")  + zhaonum*is.getPriceByName("±ª’÷");
		return totalCost;
	}
	public double payDorminary(int apartnum,String dorminum)
	{
		InforSearch is = new InforSearch();
		int temp;
		int id;
		double totalCost = 0;
		if(is.getAllStudentwash()!=null)
		{	
			for(int i = 0; i < is.getAllStudentwash().size(); i++)
			{
				id = ((StudentWash)is.getAllStudentwash().get(i)).getStuId();
				if((is.getStudentByID(id)).getApartment() == apartnum && (is.getStudentByID(id)).getDorminum().equals(dorminum))
				{
					temp = id;
					totalCost += paySingle(temp);
				}
			}
		}
		return totalCost;
		
	}

}
