package Test;

import java.util.List;
import java.util.Scanner;
import Daolmp.TblUsuarioImp;
import Model.TblUsuariot1;

public class TestUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TblUsuariot1 tblusu = new TblUsuariot1();
        TblUsuarioImp tblusuimp = new TblUsuarioImp();
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE PRUEBAS DE USUARIOS ---");
            System.out.println("1. Crear usuario");
            System.out.println("2. Editar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Buscar usuario");
            System.out.println("5. Listar todos los usuarios");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // CREAR USUARIO
                    tblusu.setUsuariot1("JuanCarlos");
                    tblusu.setPasswordt1("5555");
                    tblusuimp.RegistrarUsuario(tblusu);
                    System.out.println("Usuario registrado exitosamente");
                    break;

                case 2:
                    // EDITAR USUARIO
                    tblusu.setIdusuariot1(3); // Aquí puedes personalizar el ID
                    tblusu.setUsuariot1("Miguel");
                    tblusu.setPasswordt1("134");
                    tblusuimp.ActualizarUsuario(tblusu);
                    System.out.println("Datos del usuario editados exitosamente");
                    break;

                case 3:
                    // ELIMINAR USUARIO
                    System.out.print("Ingresa el ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    tblusu.setIdusuariot1(idEliminar);
                    tblusuimp.EliminarUsuario(tblusu);
                    System.out.println("Usuario eliminado exitosamente");
                    break;

                case 4:
                    // BUSCAR USUARIO
                    System.out.print("Ingresa el ID del usuario a buscar: ");
                    int idBuscar = scanner.nextInt();
                    tblusu.setIdusuariot1(idBuscar);
                    TblUsuariot1 tblusuario = tblusuimp.BuscarUsuario(tblusu);
                    if (tblusuario != null) {
                        System.out.println("Código de Usuario: " + tblusuario.getIdusuariot1()
                                + ", Nombre de Usuario: " + tblusuario.getUsuariot1()
                                + ", Clave: " + tblusuario.getPasswordt1());
                        System.out.println("Datos encontrados exitosamente");
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                    break;

                case 5:
                    // LISTAR TODOS LOS USUARIOS
                    List<TblUsuariot1> listado = tblusuimp.ListadoUsuarios();
                    if (listado.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        for (TblUsuariot1 lis : listado) {
                            System.out.println("Código de Usuario: " + lis.getIdusuariot1()
                                    + ", Nombre de Usuario: " + lis.getUsuariot1()
                                    + ", Clave: " + lis.getPasswordt1());
                        }
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
