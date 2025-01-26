package Daolmp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuario;
import Model.TblUsuariot1;


public class TblUsuarioImp implements IUsuario{

	@Override
	public TblUsuariot1 Logueo(TblUsuariot1 tblusuario) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_T1_GALASZAVALETAEMMANUEL");
		EntityManager em = emf.createEntityManager();

		TblUsuariot1 usu = null;

		try {

			em.getTransaction().begin();
			//usu = em.find(TblUsuariot1.class, tblusuario.getUsuariot1());
			String jpql = "SELECT u FROM TblUsuariot1 u WHERE u.usuariot1 = :usuario AND u.passwordt1 = :password";
	        usu = em.createQuery(jpql, TblUsuariot1.class)
	                 .setParameter("usuario", tblusuario.getUsuariot1())
	                 .setParameter("password", tblusuario.getPasswordt1())
	                 .getSingleResult();
			//em.getTransaction().commit();

		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();
		} finally {

			em.close();

		}
		return usu;
	}

}
