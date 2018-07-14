package com.example.mlm_marketing.mlm_marketing.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.mlm_marketing.mlm_marketing.model.SalesPerson;

@Repository
public interface SalesPersonRepository extends CrudRepository<SalesPerson, Long>{
	
	public SalesPerson findById(@Param("id") int id);

}