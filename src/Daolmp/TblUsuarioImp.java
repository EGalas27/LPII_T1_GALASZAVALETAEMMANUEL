package Daolmp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuario;
import Model.TblProductot1;
import Model.TblUsuariot1;



public class TblUsuarioImp implements IUsuario{

	@Override
	public void RegistrarUsuario(Model.TblUsuariot1 tblusuario) {
		// Conexión con unidad de persistencia para registrar datos
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
				EntityManager em = emf.createEntityManager();

				try {
					// Iniciar transacción
					em.getTransaction().begin();
					// Invocar registrar
					em.persist(tblusuario);
					// Confirmar
					em.getTransaction().commit();

				} catch (Exception e) {
					e.getMessage();
				} finally {
					// Cerrar
					em.close();

				}
		
	}

	@Override
	public void ActualizarUsuario(Model.TblUsuariot1 tblusuario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();
			em.merge(tblusuario);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
		} finally {

			em.close();

		}
		
	}

	@Override
	public void EliminarUsuario(Model.TblUsuariot1 tblusuario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();
			TblProductot1 paraEliminar = em.find(TblProductot1.class, tblusuario.getIdusuariot1());

			if (tblusuario != null) {
				em.remove(paraEliminar);
				em.getTransaction().commit();

			}

		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();
		} finally {

			em.close();

		}
		
	}

	@Override
	public Model.TblUsuariot1 BuscarUsuario(Model.TblUsuariot1 tblusuario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		TblUsuariot1 pro = null;

		try {

			em.getTransaction().begin();
			pro = em.find(TblUsuariot1.class, tblusuario.getIdusuariot1());
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();
		} finally {

			em.close();

		}

		return pro;
	
	}

	@Override
	public List<Model.TblUsuariot1> ListadoUsuarios() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		List<TblUsuariot1> listado = null;

		try {
			em.getTransaction().begin();
			// Consulta JPQL
			listado = em.createQuery("select c from TblUsuariot1 c", TblUsuariot1.class).getResultList();
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();
		} finally {
			em.close();

		}

		return listado;
	}

}