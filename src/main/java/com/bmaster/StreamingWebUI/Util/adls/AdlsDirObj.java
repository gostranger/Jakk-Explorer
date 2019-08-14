package com.bmaster.StreamingWebUI.Util.adls;

import java.util.Date;

import org.apache.tomcat.jni.Directory;

import com.microsoft.azure.datalake.store.DirectoryEntry;
import com.microsoft.azure.datalake.store.DirectoryEntryType;

public class AdlsDirObj {
	public String name;
	public String permission;
	public long length;
	public int replicationFactor;
	public String user;
	public boolean file;
	public Date expire;
	

	
	public AdlsDirObj(DirectoryEntry de) {
		super();
		this.name = de.name;
		this.permission = de.permission;
		this.length = de.length;
		this.replicationFactor = de.replicationFactor;
		this.user = de.user;
		this.file = (de.type.toString().equals("FILE"))?true:false;
		this.expire = de.expiryTime;
	}
	public Date getExpire() {
		return expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public int getReplicationFactor() {
		return replicationFactor;
	}
	public void setReplicationFactor(int replicationFactor) {
		this.replicationFactor = replicationFactor;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public boolean isFile() {
		return file;
	}
	public void setFile(boolean file) {
		this.file = file;
	}
}
