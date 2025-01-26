package Daolmp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import Model.TblProductot1;


public class TblProductoImp implements IProducto {

	@Override
	public void RegistrarProducto(TblProductot1 tblproducto) {
		// Conexión con unidad de persistencia para registrar datos
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		try {
			// Iniciar transacción
			em.getTransaction().begin();
			// Invocar registrar
			em.persist(tblproducto);
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
	public void ActualizarProducto(TblProductot1 tblproducto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();
			em.merge(tblproducto);
			em.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
		} finally {

			em.close();

		}

	}

	@Override
	public void EliminarProducto(TblProductot1 tblproducto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		try {

			em.getTransaction().begin();
			TblProductot1 paraEliminar = em.find(TblProductot1.class, tblproducto.getIdproductot1());

			if (tblproducto != null) {
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
	public TblProductot1 BuscarProducto(TblProductot1 tblproducto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		TblProductot1 pro = null;

		try {

			em.getTransaction().begin();
			pro = em.find(TblProductot1.class, tblproducto.getIdproductot1());
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
	public List<TblProductot1> ListadoProductos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		List<TblProductot1> listado = null;

		try {
			em.getTransaction().begin();
			// Consulta JPQL
			listado = em.createQuery("select c from TblProductot1 c", TblProductot1.class).getResultList();
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
