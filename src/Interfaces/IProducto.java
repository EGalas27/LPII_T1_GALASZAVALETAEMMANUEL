package Interfaces;

import java.util.List;

import Model.TblProductot1;

public interface IProducto {

	void RegistrarProducto (TblProductot1 tblproducto);
	void ActualizarProducto (TblProductot1 tblproducto);
	void EliminarProducto (TblProductot1 tblproducto);
	TblProductot1 BuscarProducto (TblProductot1 tblproducto);
	List <TblProductot1> ListadoProductos();
}
