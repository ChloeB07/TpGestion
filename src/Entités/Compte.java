package Entités;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FechType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Compte implements Serializable {
	@Id
	private String code;
	private double solde;
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="CODE_CLIENT")
	private Client client ;
	@OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
	private List<Operation> operations;
}
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	
	public Compte(String code, double solde, Date dateCreation, Client client) {
		this.code = code;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.client = client;
	}
	public Compte(double solde, Date dateCreation, Client client) {
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.client = client;
	}
	
}