package fuction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import model.Student;
import model.StudentWash;
import model.Washing;

public class InforSearch {
	public java.util.List getAllStudent()
	{
		String str="from Student";
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list(); 
		tx.commit();
		session1.close();
		return list;
	}
	public Student getStudentByID(int stuID)
	{
		String str="from Student where stuID="+stuID;
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list(); 
		tx.commit();
		session1.close();
		Student temp = null;
		if(!list.isEmpty())
		{
			temp = (Student) list.get(0);
		}
		return temp;
	}
	public double getPriceByName(String sname)
	{
		String str="from Washing where name='"+sname+"'";
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list(); 
		tx.commit();
		session1.close();
		Washing temp = new Washing();
		if(!list.isEmpty())
		{
			temp = (Washing) list.get(0);
		}
		return temp.getPrice();
	}
	public StudentWash getStudentwashByID(int stuID)
	{
		String str="from StudentWash where stuID="+stuID;
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list(); 
		tx.commit();
		session1.close();
		StudentWash temp = new StudentWash();
		if(!list.isEmpty())
		{
			temp = (StudentWash) list.get(0);
		}
		return temp;
	}
	public java.util.List getAllStudentwash()
	{
		String str="from StudentWash";
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list(); 
		tx.commit();
		session1.close();
		return list;
	}
	
	public void addStuToDB(Integer stuId, String name, String phonenum,Integer apartment, String dorminum)
	{
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		Student temp = new Student(stuId, name, phonenum, apartment, dorminum);
		session1.saveOrUpdate(temp);
		tx.commit();
		session1.close();
	}
	public void addStudentwash(Integer stuId, Integer dannum, Integer zhaonum)
	{
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		StudentWash temp = new StudentWash(stuId, dannum, zhaonum);
		session1.save(temp);
		tx.commit();
		session1.close();
	}
	public void deletelStudentwashByID(int stuID)
	{
		String str="from StudentWash where stuID="+stuID;
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list();
		StudentWash temp = (StudentWash) list.get(0);
		session1.delete(temp);
		tx.commit();
		session1.close();
	}
	public void delete(int apartnum,String dorminum)//删除整个宿舍的代洗信息
	{
		String str="from StudentWash";
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list();
		
		for(int i = 0; i < list.size(); i++)
		{
			StudentWash temp = (StudentWash)(list.get(i));
			
			if(getStudentByID(temp.getStuId()).getApartment() == apartnum &&getStudentByID(temp.getStuId()).getDorminum().equals(dorminum))
			{
				session1.delete(temp);
			}
		}
		tx.commit();
		session1.close();
		
	}
	public Washing getWashByName(String name)
	{
		String str="from Washing where name='"+name+"'";
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1=sf.openSession();
		org.hibernate.Transaction tx= session1.beginTransaction();
		org.hibernate.Query query=session1.createQuery(str); 
		java.util.List list=query.list(); 
		tx.commit();
		session1.close();
		Washing temp = null;
		if(!list.isEmpty())
		{
			temp = (Washing) list.get(0);
		}
		return temp;
	}

}
