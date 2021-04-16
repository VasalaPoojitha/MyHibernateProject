import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.StudentPGP;

public class CompositionDemo {
	public static void main(String arg[]) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		model.Marks regular=new model.Marks();
		regular.setModule1(60);
		regular.setModule2(65);
		regular.setModule3(70);
		
		model.Marks supply=new model.Marks();
		supply.setModule1(65);
		supply.setModule2(73);
		supply.setModule3(75);
					
		StudentPGP studentPGPObj=new StudentPGP();
		studentPGPObj.setStudentId(101);
		studentPGPObj.setStudentName("sneha");
		studentPGPObj.setEmailId("sneha2@gmail.com");
		studentPGPObj.setRegular(regular);
		studentPGPObj.setSupply(supply);
			
		session.save(studentPGPObj);
		transaction.commit();
		
		System.out.println(" Object Saved into the Database");
		session.close();
	}
}
