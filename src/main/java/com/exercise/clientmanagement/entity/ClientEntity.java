package com.exercise.clientmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientEntity {
	
	@Id
	@Column(name = "id_client")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
	
	@Column(name = "nom_client")
	private String nomClient;
	
	@Column(name = "prenom_client")
	private String prenomClient;
	
	@Column(name = "addresse_client")
	private String adresseClient;
	
	@Column(name = "code_postal_client")
	private Integer codePostalClient;
	
	@Column(name = "ville_client")
	private String villeClient;
	
	@Column(name = "email_client")
	private String emailClient;
	
	

	@Column(name = "telephone1_client")
	private Integer telephone1Client;
	
	@Column(name = "telephone2_client")
	private Integer telephone2Client;

	
	public ClientEntity() {
		
	}

	
	public ClientEntity(String nomClient, String prenomClient, String addresseClient,
			Integer codePostalClient, String villeClient, String emailClient, Integer telephone1Client) {
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresseClient = addresseClient;
		this.codePostalClient = codePostalClient;
		this.villeClient = villeClient;
		this.emailClient = emailClient;
		this.telephone1Client = telephone1Client;
	}


	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String addresseClient) {
		this.adresseClient = addresseClient;
	}

	public Integer getCodePostalClient() {
		return codePostalClient;
	}

	public void setCodePostalClient(Integer codePostalClient) {
		this.codePostalClient = codePostalClient;
	}

	public String getVilleClient() {
		return villeClient;
	}

	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}
	
	public String getEmailClient() {
		return emailClient;
	}


	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	
	public Integer getTelephone1Client() {
		return telephone1Client;
	}

	public void setTelephone1Client(Integer telephone1Client) {
		this.telephone1Client = telephone1Client;
	}

	public Integer getTelephone2Client() {
		return telephone2Client;
	}

	public void setTelephone2Client(Integer telephone2Client) {
		this.telephone2Client = telephone2Client;
	}
	
	
}
