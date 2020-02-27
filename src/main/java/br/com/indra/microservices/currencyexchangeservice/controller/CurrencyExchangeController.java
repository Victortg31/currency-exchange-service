package br.com.indra.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.indra.microservices.currencyexchangeservice.bean.ExchangeValue;
import br.com.indra.microservices.currencyexchangeservice.repository.CurrencyExchangeRespository;


@RestController
public class CurrencyExchangeController {
	
	//para pegar a porta pelo ambiente
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRespository respositor;
	//Utilização da URI sem o APIGETWAY, nãp é necessário passar o nome de aplicação como parametro
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	
	//@GetMapping("/currency-exchange-services/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue exchangeValue = respositor.findByFromAndTo(from, to);
		
//		passando qual a porta do serviço
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return exchangeValue;
	}
}
