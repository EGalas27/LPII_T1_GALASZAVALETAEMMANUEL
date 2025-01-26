package Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_usuariot1 database table.
 * 
 */
@Entity
@Table(name="tbl_usuariot1")
@NamedQuery(name="TblUsuariot1.findAll", query="SELECT t FROM TblUsuariot1 t")
public class TblUsuariot1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuariot1;

	private String passwordt1;

	private String usuariot1;

	public TblUsuariot1() {
	}

	public int getIdusuariot1() {
		return this.idusuariot1;
	}

	public void setIdusuariot1(int idusuariot1) {
		this.idusuariot1 = idusuariot1;
	}

	public String getPasswordt1() {
		return this.passwordt1;
	}

	public void setPasswordt1(String passwordt1) {
		this.passwordt1 = passwordt1;
	}

	public String getUsuariot1() {
		return this.usuariot1;
	}

	public void setUsuariot1(String usuariot1) {
		this.usuariot1 = usuariot1;
	}

}