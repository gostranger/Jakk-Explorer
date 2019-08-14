package com.bmaster.StreamingWebUI.Util.adls;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bmaster.StreamingWebUI.Models.adls.AdlsModel;
import com.microsoft.azure.datalake.store.ADLStoreClient;
import com.microsoft.azure.datalake.store.DirectoryEntry;
import com.microsoft.azure.datalake.store.oauth2.AccessTokenProvider;
import com.microsoft.azure.datalake.store.oauth2.ClientCredsTokenProvider;


public class AdlsClientProvider {
	private AccessTokenProvider provider;
	private ADLStoreClient client;
	
	public AdlsClientProvider(AdlsModel data) {
		provider = new ClientCredsTokenProvider(data.getAuthEndPoint(), data.getClientID(), data.getKey());
		client = ADLStoreClient.createClient(data.getAccountName()+".azuredatalakestore.net",provider);
	}
	public ADLStoreClient getClient() {
		return client;
	}
	public void setClient(ADLStoreClient client) {
		this.client = client;
	}
	public List<DirectoryEntry> commandDir(String path){
		try {
			return client.enumerateDirectory(path);
		} catch (IOException e) {
			return null;
		}
	}
}
