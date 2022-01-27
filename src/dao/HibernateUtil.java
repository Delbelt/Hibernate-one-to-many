package dao;

//Util se conecta con todas las librerias exportadas de Hibernate para configurar la Session
//CREA LA SESSION PARA CONECTAR LA BD Y JAVA

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory; //Esta clase contiene métodos para leer, guardar o borrar entidades sobre la base de datos CRUD
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory()
	{		
		try 
		{
			if (sessionFactory == null)
			{
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();		
				Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				sessionFactory = metaData.getSessionFactoryBuilder().build();		
			}
		} 
		
		catch (HibernateException he)
		{
			System.err.println("ERROR en la inicializacion de la SessionFactory: " + he);

			throw new ExceptionInInitializerError(he);
		}
		
		return sessionFactory;
	}
}

//Se realiza una única vez en la aplicación - CONECTA CON LA BASE DE DATOS
//Se guarda la referencia a SessionFactory para su posterior uso, durante toda la vida de la aplicación.