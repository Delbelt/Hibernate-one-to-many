package negocio;

import dao.CuotasDao;
import datos.Cuota;

public class CuotaABM {
	
	CuotasDao dao = new CuotasDao();

	public long agregar(Cuota cuota)
	{		
		return dao.agregar(cuota);
	}	

	//El atributo cancelado se encontrará en true si el préstamo tiene todas sus cuotas pagas 
	//El atributo punitorios será calculado por un interés por mora en el pago de la cuota que ingresará por parámetro, por ejemplo 2% mensual.
	
	//En el caso de que un cliente venga a pagar una cuota se invocará al método traerCuota de CuotaABM, se “setearán” los atributos: 
	//cancelada, fechaDePago, punitorios y por último modificarCuota de CuotaABM.

	}