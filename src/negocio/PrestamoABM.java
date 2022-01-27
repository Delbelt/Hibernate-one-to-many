package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;

public class PrestamoABM {
	
	PrestamoDao dao = new PrestamoDao();
	
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) throws Exception
	{		
		Prestamo objeto = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		
		objeto.calcularCuotas(objeto);
		
		Set<Cuota> cuotas= objeto.getCuotas();	
			
		return dao.agregar(objeto, cuotas);		
	}

	public void modificar(Prestamo objeto) throws Exception
	{		
		if(dao.traer(objeto.getIdPrestamo()) != null)	
		throw new Exception("No se puede actualizar");
		
		dao.actualizar(objeto);
	}

	public void eliminar(long idPrestamo) throws Exception
	{
		if(dao.traer(idPrestamo) == null) 
		throw new Exception("No existe el prestamo con el id: " + idPrestamo);	

		dao.eliminar(dao.traer(idPrestamo));
	}

	public List<Prestamo> traerPrestamo(Cliente objeto) throws Exception
	{		
		if(dao.traer(objeto) == null) 
		throw new Exception("No existe el cliente");
		
		return dao.traer(objeto);		
	}
	
	public Prestamo traerPrestamo(long idPrestamo) throws Exception
	{		
		if(dao.traer(idPrestamo) == null)
		throw new Exception("No existe el prestamo con el id: " + idPrestamo);
		
		return dao.traer(idPrestamo);
	}
	
	public Prestamo traerPrestamoYCuotas(Prestamo objeto)
	{		
		return dao.traerPrestamoYCuotas(objeto.getIdPrestamo());		
	}	
}
