package com.bmaster.StreamingWebUI.Models.adls;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdlsModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String ClusterName;
	private String AccountName;
	private String ClientID;
	private String Key;
	private String BaseDir;
	private String AuthEndPoint;
	
	
	public AdlsModel() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getClientID() {
		return ClientID;
	}
	public void setClientID(String clientID) {
		ClientID = clientID;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public String getBaseDir() {
		return BaseDir;
	}
	public void setBaseDir(String baseDir) {
		BaseDir = baseDir;
	}
	public String getAuthEndPoint() {
		return AuthEndPoint;
	}
	public void setAuthEndPoint(String authEndPoint) {
		AuthEndPoint = authEndPoint;
	}
	public String getClusterName() {
		return ClusterName;
	}
	public void setClusterName(String clusterName) {
		ClusterName = clusterName;
	}
	public AdlsModel(String clusterName, String accountName, String clientID, String key, String baseDir,
			String authEndPoint) {
		ClusterName = clusterName;
		AccountName = accountName;
		ClientID = clientID;
		Key = key;
		BaseDir = baseDir;
		AuthEndPoint = authEndPoint;
	}
	
	
}
