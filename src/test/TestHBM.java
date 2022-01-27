package test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class TestHBM {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession(); //Crea la Session
		session.beginTransaction();//Crea una nueva transacción
		session.close(); //Una vez finalizado se deberá cerrar la sesión con el método
		System.out.println("OK");
	}
}
