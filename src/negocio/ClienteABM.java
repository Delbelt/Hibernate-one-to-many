package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();
	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception
	{		
		if(dao.traer(dni) != null)
		throw new Exception("Error: No se puede agregar el cliente, ya se encuentra en la bd: " + dni);
		
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		
		return dao.agregar(c);
	}

	public void modificar(Cliente cliente) throws Exception
	{		
		Cliente objeto = dao.traerId(cliente.getIdCliente());
		
		if(objeto != null && objeto.getIdCliente() != dao.traer(cliente.getDni()).getIdCliente())
		throw new Exception("No se puede actualizar el cliente debido a que ese dni " + cliente.getDni() + " ya se encuentra registrado");
		
		dao.actualizar(cliente);
	}

	public void eliminar(long idCliente) throws Exception
	{
		if(dao.traerId(idCliente) == null) throw new Exception("Error: No se puede borrar el cliente, no existe");
		//Si se intenta eliminar una entidad nula: "attempt to create delete event with null entity"

		dao.eliminar(dao.traerId(idCliente));
	}	

	public Cliente traerId(long idCliente)
	{		
		return dao.traerId(idCliente);
	}

	public Cliente traer(int dni)
	{		
		Cliente c = dao.traer(dni);
		return c;
	}

	public List<Cliente> traer() throws Exception
	{		
		if(dao.traer() == null) 
		throw new Exception("¡Error! No existe el cliente");
		
		return dao.traer();
	}
	
	public Cliente traerClienteYPrestamos(long idCliente) throws Exception
	{		
		if(dao.traerId(idCliente) == null) 
		throw new Exception("No existe el cliente con id: " + idCliente);
		
		return dao.traerClienteYPrestamos(idCliente);
	}	

}
