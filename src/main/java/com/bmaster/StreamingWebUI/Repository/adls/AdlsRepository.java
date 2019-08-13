package com.bmaster.StreamingWebUI.Repository.adls;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bmaster.StreamingWebUI.Models.adls.AdlsModel;

public interface AdlsRepository extends CrudRepository<AdlsModel,Integer> {
	public List<AdlsModel> findAll();
}
