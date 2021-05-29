package com.jsp.WebApplication.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="stock_table")
	public class Stock implements Serializable{

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int stockId;
		private String companyName;
		private String stockPrice;
		private String companyStartDate;
		
		public Stock() {
		}

		public Stock(int stockId, String companyName, String stockPrice, String companyStartDate) {
			this.stockId = stockId;
			this.companyName = companyName;
			this.stockPrice = stockPrice;
			this.companyStartDate = companyStartDate;
		}


		public int getStockId() {
			return stockId;
		}

		public void setStockId(int stockId) {
			this.stockId = stockId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getStockPrice() {
			return stockPrice;
		}

		public void setStockPrice(String stockPrice) {
			this.stockPrice = stockPrice;
		}

		public String getCompanyStartDate() {
			return companyStartDate;
		}

		public void setCompanyStartDate(String companyStartDate) {
			this.companyStartDate = companyStartDate;
		}

}
