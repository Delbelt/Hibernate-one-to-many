package negocio;

import dao.CuotasDao;
import datos.Cuota;

public class CuotaABM {
	
	CuotasDao dao = new CuotasDao();

	public long agregar(Cuota cuota)
	{		
		return dao.agregar(cuota);
	}	

	//El atributo cancelado se encontrar� en true si el pr�stamo tiene todas sus cuotas pagas 
	//El atributo punitorios ser� calculado por un inter�s por mora en el pago de la cuota que ingresar� por par�metro, por ejemplo 2% mensual.
	
	//En el caso de que un cliente venga a pagar una cuota se invocar� al m�todo traerCuota de CuotaABM, se �setear�n� los atributos: 
	//cancelada, fechaDePago, punitorios y por �ltimo modificarCuota de CuotaABM.

	}