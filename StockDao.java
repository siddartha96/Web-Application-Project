package com.jsp.WebApplication.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jsp.WebApplication.model.Stock;

@Repository
public interface StockDao extends CrudRepository<Stock, Integer>{

}
