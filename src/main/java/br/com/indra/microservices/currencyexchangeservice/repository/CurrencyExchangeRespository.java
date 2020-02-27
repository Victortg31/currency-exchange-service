package br.com.indra.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.indra.microservices.currencyexchangeservice.bean.ExchangeValue;

public interface CurrencyExchangeRespository extends JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from , String to);
	
}
