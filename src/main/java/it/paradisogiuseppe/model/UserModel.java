package it.paradisogiuseppe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@NamedQueries({ @NamedQuery(name = "findAllUser", query = "SELECT u FROM UserModel u"),
	@NamedQuery(name = "findByUsernameAndPassword", query = "SELECT u FROM UserModel u where u.username =:username "
			+ "and u.password =:password") })


@Entity
public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	private String nome;
	
	private String cognome;
	
	private String dataNascita;
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy="user")   //user è il campo user di contact
	private List<ContactModel> listContact=new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public List<ContactModel> getListContact() {
		return listContact;
	}

	public void setListContact(List<ContactModel> listContact) {
		this.listContact = listContact;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", nome=" + nome
				+ ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", listContact=" + listContact + "]";
	}
	
	

}
