package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cuota;

public class CuotasDao {
	
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException
	{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException
	{		
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	// C R U D //
	
	public int agregar(Cuota objeto)
	{		
		int id = 0;

		try 
		{
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}
		
		catch (HibernateException he) 
		{
			manejaExcepcion(he);
			throw he;
		}
		
		finally 
		{
			session.close();
		}
		
		return id;
	}
	
	public Cuota traer(long idCuota) throws HibernateException
	{		
		Cuota objeto = null;
		
		try
		{
			iniciaOperacion();
			String hql = "from Cuota c inner join fetch c.prestamo p where c.idCuota=" + idCuota;
			objeto = (Cuota) session.createQuery(hql).uniqueResult();
		}
		
		finally
		{
			session.close();
		}		
		
		return objeto;		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuota> traer(Cuota c) throws HibernateException
	{		
		List<Cuota> lista = null;
		
		try
		{
			iniciaOperacion();
			String hql = "from Cuota cu inner join fetch cu.prestamo p where cu.idCuota=" + c.getIdCuota();
			lista = session.createQuery(hql).list();
		}
		
		finally
		{
			session.close();
		}		
		
		return lista;		
	}

}
