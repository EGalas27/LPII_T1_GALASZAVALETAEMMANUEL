package Test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Daolmp.TblProductoImp;
import Model.TblProductot1;

public class TestProducto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TblProductot1 tblprod = new TblProductot1();
        TblProductoImp tblproimp = new TblProductoImp();
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE PRUEBAS ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Editar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Buscar producto");
            System.out.println("5. Listar todos los productos");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // CREAR PRODUCTO
                    tblprod.setNombret1("Desodorante en Barra");
                    tblprod.setPreciot1(1.50);
                    tblprod.setDescripciont1("Producto fresco");
                    tblprod.setEstadot1("Repuesto");
                    Date fecha = new Date();
                    tblprod.setFechafabrit1(new Date(fecha.getTime()));
                    tblprod.setFechavencimt1(new Date(fecha.getTime()));
                    tblproimp.RegistrarProducto(tblprod);
                    System.out.println("Datos registrados exitosamente");
                    break;

                case 2:
                    // EDITAR PRODUCTO
                    tblprod.setIdproductot1(3);
                    tblprod.setNombret1("PAPAYA");
                    tblprod.setPreciot1(52);
                    tblprod.setEstadot1("Fresco");
                    tblproimp.ActualizarProducto(tblprod);
                    System.out.println("Datos editados exitosamente");
                    break;

                case 3:
                    // ELIMINAR PRODUCTO
                    tblprod.setIdproductot1(4);
                    tblproimp.EliminarProducto(tblprod);
                    System.out.println("Datos eliminados exitosamente");
                    break;

                case 4:
                    // BUSCAR PRODUCTO
                    tblprod.setIdproductot1(5);
                    TblProductot1 tblproducto = tblproimp.BuscarProducto(tblprod);
                    System.out.println("Código: " + tblproducto.getIdproductot1()
                            + ", Nombre: " + tblproducto.getNombret1()
                            + ", Precio: " + tblproducto.getPreciot1()
                            + ", Descripción: " + tblproducto.getDescripciont1()
                            + ", Estado: " + tblproducto.getEstadot1()
                            + ", Fecha de Fabricación: " + tblproducto.getFechafabrit1()
                            + ", Fecha de Vencimiento: " + tblproducto.getFechavencimt1());
                    System.out.println("Datos encontrados exitosamente");
                    break;

                case 5:
                    // LISTAR TODOS LOS PRODUCTOS
                    List<TblProductot1> listado = tblproimp.ListadoProductos();
                    for (TblProductot1 lis : listado) {
                        System.out.println("Código: " + lis.getIdproductot1()
                                + ", Nombre: " + lis.getNombret1()
                                + ", Precio: " + lis.getPreciot1()
                                + ", Descripción: " + lis.getDescripciont1()
                                + ", Estado: " + lis.getEstadot1()
                                + ", Fecha de Fabricación: " + lis.getFechafabrit1()
                                + ", Fecha de Vencimiento: " + lis.getFechavencimt1());
                    }
                    break;

                case 6:
                    // SALIR
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}
