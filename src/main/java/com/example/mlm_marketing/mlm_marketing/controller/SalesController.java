package com.example.mlm_marketing.mlm_marketing.controller;

import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mlm_marketing.mlm_marketing.model.SalesPerson;
import com.example.mlm_marketing.mlm_marketing.repo.SalesPersonRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SalesController {

	@Autowired
	SalesPersonRepository salesPersonRepository;

	@RequestMapping(value = "/itemSold/{personId}/{sellAmount}", method = RequestMethod.POST, produces = "application/json")
	public String goodsSold(@PathVariable("personId") Integer salesPersonId,
			@PathVariable("sellAmount") Double sellAmount) {

		SalesPerson person = salesPersonRepository.findById(Integer
				.valueOf(salesPersonId));
		Double parentShare = creditSalesPersonBalance(person, sellAmount);

		if (parentShare != 0) {
			String[] salesPersonRefIds = person.getReferencePath().split("/");

			for (int i = salesPersonRefIds.length - 1; i >= 0; i--) {
				person = salesPersonRepository.findById(Integer.valueOf(salesPersonRefIds[i]));
				parentShare = creditSalesPersonBalance(person, parentShare);

			}
		}
		return "{\"result\":\"Balance Updated Check Database\"}";
	}

	private Double creditSalesPersonBalance(SalesPerson person, Double sellAmount) {
		Double parentsShare = sellAmount * person.getRefrencedShare() / 100;
		Double amountToCredit = sellAmount - parentsShare;

		person.setBalance(person.getBalance() + amountToCredit);

		salesPersonRepository.save(person);
		return parentsShare;
	}
	
}