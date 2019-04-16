package ru.makkov.profitCalculation.service;

public interface ProductService {

  boolean purchaseProducts(String categoryName, String amount, String purchasePrice, String purchaseDate);
  boolean demandProducts(String categoryName, String amount, String demandPrice, String demandDate);
}
