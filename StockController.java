package com.jsp.WebApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.WebApplication.model.Stock;
import com.jsp.WebApplication.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService service;

	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String getStockList(Model model) {
		model.addAttribute("stockList",service.getStockList());
		return "index";
	}


	@RequestMapping("/newstockform")
	public String addstockform(Model model) {
		Stock stock =  new Stock();
		model.addAttribute("stock", stock);
		
		return "addstock";
	}
	
	
	@RequestMapping(value = "/savestocks", method = RequestMethod.POST)
	public String addStock(@ModelAttribute("stock")  Stock stock) {

		service.addStock(stock);
		return "redirect:/";
	}
	
	@RequestMapping("/updatestockform/{id}")
	public String addstockform(@PathVariable String id, Model model) {
		Stock stock = service.getStock(id);
		model.addAttribute("stock", stock);
		
		return "Updatestock";
	}

	@RequestMapping(value = "/stocks/{id}", method = RequestMethod.PUT)
	public void updateStock(@RequestBody Stock stock, @PathVariable String id) {

		service.updateStock(stock, id);
	}

	@RequestMapping(value = "/stocks/{id}", method = RequestMethod.DELETE)
	public void deleteStock(@PathVariable String id) {

		service.deleteStock(id);
	}
}

//@RequestMapping("/stocks/{id}")
//public Stock getStock(@PathVariable String id) {
//
//	return service.getStock(id);
//}