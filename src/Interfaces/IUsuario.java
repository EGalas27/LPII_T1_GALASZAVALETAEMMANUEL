package Interfaces;

import java.util.List;


import Model.TblUsuariot1;

public interface IUsuario {
	
	void RegistrarUsuario (TblUsuariot1 tblusuario);
	void ActualizarUsuario (TblUsuariot1 tblusuario);
	void EliminarUsuario (TblUsuariot1 tblusuario);
	TblUsuariot1 BuscarUsuario (TblUsuariot1 tblusuario);
	List <TblUsuariot1> ListadoUsuarios();
	
}
