package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {
		
		ClienteABM sistema = new ClienteABM();
		
		//Test *******************************
		
		try {
			
				System.out.println("");
				
				System.out.println("Test 1: Intentar agregar cliente (Salta Excepcion)");	
				sistema.agregar("Dominguez", "Arturo", 1111, LocalDate.of(1990, 01,01));
					
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
				System.out.println("OK");
			}
		
		//Test *******************************
		
		try {
			
				System.out.println("");
				
				System.out.println("Test 2: Traer Cliente");	
				System.out.println(sistema.traer(1111));
				System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {
			
				System.out.println("");
				
				System.out.println("Test 3: Traer Actualizar Cliente");	
				
				Cliente objeto;
				objeto = sistema.traer(1111);
				objeto.setNombre("Arturo");
				objeto.setApellido("Domingo");
				sistema.modificar(objeto);
				
				System.out.println(sistema.traer(1111));
				System.out.println("OK");	
				
				}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {
			
				System.out.println("");
				
				System.out.println("Test 4: Intentar eliminar cliente id invalido (Salta Excepcion)");	
				sistema.eliminar(15);		
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
				System.out.println("OK");
			}
		
		//Test *******************************
		
		try {			
				System.out.println("");
				
				System.out.println("Test 5: Traer Cliente y Prestamo");	
				Cliente objeto = sistema.traerClienteYPrestamos(1);	
				
				System.out.println(objeto);
				
				for (Prestamo prestamos : objeto.getPrestamos())
				{
					System.out.println(prestamos);					
				}
					System.out.println("OK");
				}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
				
			}
	}

}
