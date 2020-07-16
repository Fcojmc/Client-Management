package com.exercise.clientmanagement.dto;

public class ClientDto {
	
	private String nomClient;
	private String prenomClient;
	private String adresseClient;
	private Integer codePostalClient;
	private String villeClient;
	private String emailClient;
	private Integer telephone1Client;
	private Integer telephone2Client;
	
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
