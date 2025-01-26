package Test;

import Daolmp.TblUsuarioImp;
import Model.TblUsuariot1;

public class TestUsuario {

	public static void main(String[] args) {
		
		// Objetos
		TblUsuariot1 tblusu = new TblUsuariot1();
		TblUsuarioImp tblusuimp = new TblUsuarioImp();
				
		// Setear para buscar tblprod.setIdproducto(1); // enviar id
		tblusu.setUsuariot1("pepe");
		tblusu.setPasswordt1("123");
		TblUsuariot1 tblusuario = tblusuimp.Logueo(tblusu);
		
		if(tblusuario !=  null){
			System.out.println(" codigo " + tblusuario.getIdusuariot1() +
					" nombre del usuario " + tblusuario.getUsuariot1() + " contraseña " +
					tblusuario.getPasswordt1());
					 
					System.out.println("Usuario logueado exitosamente");
		}else{
			System.out.println("El usuario no existe");
		}

	}
}
