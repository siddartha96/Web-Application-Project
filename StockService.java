package com.jsp.WebApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.WebApplication.dao.StockDao;
import com.jsp.WebApplication.model.Stock;

@Service
public class StockService {
	
	
	@Autowired
	private StockDao dao;

	public List<Stock> getStockList() {
		List<Stock> stockList = new ArrayList<Stock>();
		dao.findAll().forEach(stockList::add);
		return stockList;
	}

	public Stock getStock(String id) {
		Optional<Stock> stock =null;
		
		if(!id.isEmpty() && Integer.parseInt(id)>0) {
		  stock = dao.findById(Integer.parseInt(id));
		}
		return stock.get();
	
	}

	public void addStock(Stock stock) {
		if(null!=stock && !stock.getCompanyName().isEmpty() && !stock.getCompanyStartDate().isEmpty() && !stock.getStockPrice().isEmpty() ) {
			dao.save(stock);
		}
	}

	public void updateStock(Stock stock, String id) {
		dao.save(stock);
		
	}

	public void deleteStock(String id) {
		
		dao.deleteById(Integer.parseInt(id));
	}

	
	public void deleteStockAll() {
		
		dao.deleteAll();
	}
}


