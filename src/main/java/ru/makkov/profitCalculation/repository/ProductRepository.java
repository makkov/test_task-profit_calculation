package ru.makkov.profitCalculation.repository;

import ru.makkov.profitCalculation.pojo.Category;
import ru.makkov.profitCalculation.pojo.Product;

import java.util.Date;
import java.util.List;

public interface ProductRepository {

  void purchaseProduct(Product product);
  void demandProduct(Product product, Integer priceDemand, Date dateDemand);
  List<Product> getAllProducts();
  Integer getTailingsProductInStock(Category category);
  Integer getSalesReport(Category category, Date date);
}
