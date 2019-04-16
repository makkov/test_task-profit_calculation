package ru.makkov.profitCalculation.service.serviceImpl;

import ru.makkov.profitCalculation.pojo.Category;
import ru.makkov.profitCalculation.pojo.Product;
import ru.makkov.profitCalculation.repository.CategoryRepository;
import ru.makkov.profitCalculation.repository.ProductRepository;
import ru.makkov.profitCalculation.repository.repositoryImpl.CategoryRepositoryImpl;
import ru.makkov.profitCalculation.repository.repositoryImpl.ProductRepositoryImpl;
import ru.makkov.profitCalculation.service.ProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductServiceImpl implements ProductService {

  private CategoryRepository categoryRepository = new CategoryRepositoryImpl();
  private ProductRepository productRepository = new ProductRepositoryImpl();

  @Override
  public boolean purchaseProducts(String categoryName, String amount, String purchasePrice, String date) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
      Date purchaseDate = simpleDateFormat.parse(date);
      Category category = categoryRepository.getCategoryByName(categoryName);
      if (categoryName != null & amount != null & purchasePrice != null & purchaseDate != null & category != null) {
        try {
          Integer amountProducts = Integer.parseInt(amount);
          Integer price = Integer.parseInt(purchasePrice);
          if (amountProducts <= 0 | price < 0) {
            return false;
          }
        } catch (NumberFormatException e) {
          return false;
        }
        for (int i = 0; i < Integer.parseInt(amount); i++) {
          Product newProduct = new Product(category, Integer.parseInt(purchasePrice), purchaseDate);
          productRepository.purchaseProduct(newProduct);
        }
        return true;
      }
    } catch (ParseException e) {
      return false;
    }
    return false;
  }

  @Override
  public boolean demandProducts(String categoryName, String amount, String demandPrice, String date) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
      Date demandDate = simpleDateFormat.parse(date);
      if (categoryName != null && amount != null && demandPrice != null && date != null) {
        try {
          Integer amountProducts = Integer.parseInt(amount);
          Integer price = Integer.parseInt(demandPrice);
          if (amountProducts <= 0 | price < 0) {
            return false;
          }
        } catch (NumberFormatException e) {
          return false;
        }
        Category category = categoryRepository.getCategoryByName(categoryName);
        Integer tailsInStock = productRepository.getTailingsProductInStock(category);
        Integer amountProducts = Integer.parseInt(amount);
        if (amountProducts <= 0) {
          return false;
        }
        if (tailsInStock >= amountProducts) {
          for (Product product : productRepository.getAllProducts()) {
            if (product.getCategory() == category & product.getDateDemand() == null) {
              if (product.getDatePurchase().after(demandDate)) {
                return false;
              }
              productRepository.demandProduct(product, Integer.parseInt(demandPrice), demandDate);
              amountProducts -= 1;
            }
            if (amountProducts == 0) {
              break;
            }
          }
          return true;
        }
      }
    } catch (ParseException e) {
      return false;
    }
    return false;
  }
}
