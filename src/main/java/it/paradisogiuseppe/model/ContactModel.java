package it.paradisogiuseppe.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "findAllContacts", query = "SELECT c FROM ContactModel c"),
	@NamedQuery(name = "findByName", query = "SELECT c FROM ContactModel c where c.nome =:nome "
			+ "and c.cognome =:cognome") })

@Entity
public class ContactModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String cognome;

	@Column(nullable=false)
	private String telefono;

	private String email;
	
	
//	public ContactModel(){
////		setId(0);
//		nome="Sample";
//		cognome="Sample";
//		telefono="Sample";
//		email="Sample";
//	}
//	
//	
//	public ContactModel(int id, String nome, String cognome, String telefono, String email) {
//		super();
////		this.setId(id);
//		this.nome = nome;
//		this.cognome = cognome;
//		this.telefono = telefono;
//		this.email = email;
//	}

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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactModel other = (ContactModel) obj;
		if(other.getNome()==null)
			return false;
		else {
			if(other.getNome() != null && other.getNome().equals(getNome())){
				if(other.getCognome() != null && other.getCognome().equals(getCognome())){
					if(other.getTelefono() != null && other.getTelefono().equals(getTelefono())){
						if(other.getEmail() != null && other.getEmail().equals(getEmail())){
							return true;
						}
						else
							return false;
					}
					else
						return false;
				}
				else
					return false;
			}else
				return false;
		}
			
	}
	
	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}
}
