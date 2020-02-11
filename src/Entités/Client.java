package Entités;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FechType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
	private Client(Long code, Collection<Compte> comptes) {
		super();
		this.code = code;
		this.comptes = comptes;
	}



	@Id @GeneratedValue
	private Long code;
	private String nom;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	
	public Client(Long code) {
		super();
		this.code = code;
	}

	public Client(String nom, Collection<Compte> comptes) {
		super();
		this.nom = nom;
		this.comptes = comptes;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	private Long getCode() {
		return code;
	}

	private void setCode(Long code) {
		this.code = code;
	}

	private String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	private Collection<Compte> getComptes() {
		return comptes;
	}

	private void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}


}
