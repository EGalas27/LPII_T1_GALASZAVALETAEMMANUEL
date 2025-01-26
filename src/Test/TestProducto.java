package Test;


import java.util.Date;
import java.util.List;

import Daolmp.TblProductoImp;
import Model.TblProductot1;



public class TestProducto {
	
	public static void main(String[] args) {
		
		TblProductot1 tblprod = new TblProductot1();
		TblProductoImp tblproimp = new TblProductoImp();
		
		/*// CREAR PRODUCTO
		tblprod.setNombret1("Desodorante en Barra");
		tblprod.setPreciot1(1.50); 
		tblprod.setDescripciont1("Producto fresco");
		tblprod.setEstadot1("Repuesto"); 
		
		Date fecha = new Date(); Date
		fechasql = new Date(fecha.getTime()); tblprod.setFechafabrit1(fechasql);
		fechasql = new Date(fecha.getTime()); tblprod.setFechavencimt1(fechasql);
				 
		// 
		tblproimp.RegistrarProducto(tblprod); 
		System.out.println("Datos registrados exitosamente");
		
		
		//--------//
		
	     // EDITAR 
		 tblprod.setIdproductot1(3); 
		 tblprod.setNombret1("PAPAYA"); 
		 tblprod.setPreciot1(52);
		 tblprod.setEstadot1("Fresco"); 

		 
		 // Llamar método y enviarle objeto seteado
		 tblproimp.ActualizarProducto(tblprod); System.out.println(
		 "Datos editados exitosamente");*/
		 
		 
		 
	/*	 //ELIMINAR
		tblprod.setIdproductot1(4); 
		tblproimp.EliminarProducto(tblprod); 
		System.out.println("Datos Eliminados exitosamente");*/
		 
		
		/*//BUSCAR
		tblprod.setIdproductot1(5); 
		TblProductot1 tblproducto = tblproimp.BuscarProducto(tblprod);
		
		System.out.println("codigo " + tblproducto.getIdproductot1() +" nombre del producto " + tblproducto.getNombret1() + " Precio " +tblproducto.getPreciot1() + " Descripcion " + tblproducto.getDescripciont1() +
		" Estado " + tblproducto.getEstadot1() + " Fecha de Vencimiento " +tblproducto.getFechavencimt1()+ " Fecha de Fabricacion " +tblproducto.getFechafabrit1());

		System.out.println("Datos encontrados exitosamente");*/
		
		
		//LISTAR TODO
		List<TblProductot1> listado = tblproimp.ListadoProductos();
		for (TblProductot1 lis : listado) {
			System.out.println("codigo " + lis.getIdproductot1()  
					+ " nombre del producto " + lis.getNombret1()
					+ " Precio " + lis.getPreciot1() 
					+ " Descripcion " + lis.getDescripciont1() 
					+ " Estado " + lis.getEstadot1()
					+ " Fecha Vencimiento " + lis.getFechavencimt1()
					+ " Fecha Fabricacion " + lis.getFechafabrit1());

		
		}
	}

}
