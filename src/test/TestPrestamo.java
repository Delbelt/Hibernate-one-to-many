package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestPrestamo {

	public static void main(String[] args) {
		
		ClienteABM sistemaC = new ClienteABM();
		PrestamoABM sistemaP = new PrestamoABM();
		
		//Test *******************************
	
		try {					
				System.out.println("");
				
				System.out.println("Test 1: Traer Prestamo por id");
				System.out.println(sistemaP.traerPrestamo(2));
				
				System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {					
				System.out.println("");
				
				System.out.println("Test 2: Traer Prestamo por objeto (Cliente)");
				Cliente objeto = sistemaC.traer(1111);
				System.out.println(sistemaP.traerPrestamo(objeto));
				
				System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {					
				System.out.println("");
				
				System.out.println("Test 3: Agregar Prestamo");
				Cliente objeto = sistemaC.traer(2222);
				sistemaP.agregar(LocalDate.of(2022, 1, 12), 50000, 10, 24, objeto);
				
				System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {
			
				System.out.println("");
				
				System.out.println("Test 4: Traer prestamo Agregado CU 3");
				Cliente objeto = sistemaC.traer(2222);
				System.out.println(sistemaP.traerPrestamo(objeto));
				
				System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {					
				System.out.println("");
				
				System.out.println("Test 5: Intentar eliminar prestamo (Salta Excepcion)");
				sistemaP.eliminar(4);					
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
				System.out.println("OK");	
			}
		
		//Test *******************************
		
		try {					
				System.out.println("");
				
				System.out.println("Test 6: Traer Prestamo y sus cuotas");
				Prestamo objeto = sistemaP.traerPrestamoYCuotas( sistemaP.traerPrestamo(2));
				
				System.out.println(objeto);
				
				for (Cuota cuotas : objeto.getCuotas())
				{
					System.out.println(cuotas);
				}					
				
				System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test *******************************
		
		try {					
				System.out.println("");
				
				System.out.println("Test 7: Traer Cliente, Prestamo y sus cuotas");
				Cliente cliente = sistemaC.traer(1111);
				Prestamo prestamo = sistemaP.traerPrestamoYCuotas(sistemaP.traerPrestamo(2));
				
				System.out.println("");
				System.out.println(cliente);
				System.out.println("");
				System.out.println(prestamo);
				System.out.println("");
				
				for (Cuota cuotas : prestamo.getCuotas())
				{
					System.out.println(cuotas);
				}					
				
				System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}

	}

}
