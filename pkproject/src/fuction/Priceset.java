package fuction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import model.Washing;

public class Priceset {
	
	public void setPrice(String name, double newprice)
	{
		InforSearch is =new InforSearch();
		Washing temp = is.getWashByName(name);
		temp.setPrice(newprice);
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		session1.update(temp);
		tx.commit();
		session1.close();	
	}

}
