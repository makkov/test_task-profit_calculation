package ru.makkov.profitCalculation.service.serviceImpl;

import org.junit.Test;
import ru.makkov.profitCalculation.service.CategoryService;
import ru.makkov.profitCalculation.service.ProductService;

public class ProductServiceImplTest {


  private ProductService productService = new ProductServiceImpl();
  private CategoryService categoryService = new CategoryServiceImpl();

  @Test
  public void purchaseProducts() {

    String categoryIphone = "iphone";
    categoryService.addCategory(categoryIphone);
    String numberProducts = "2";
    String purchaseDate = "25.10.2017";
    String purchasePrice = "7000";
    assert productService.purchaseProducts(categoryIphone, numberProducts, purchasePrice, purchaseDate);
    String nonExistCategory = "yotaPhone";
    assert !productService.purchaseProducts(nonExistCategory, numberProducts, purchasePrice, purchaseDate);
    String incorrectNumberProducts = "seven phones";
    assert !productService.purchaseProducts(categoryIphone, incorrectNumberProducts, purchasePrice, purchaseDate);
    String negativeNumver = "-4";
    assert !productService.purchaseProducts(categoryIphone, negativeNumver, purchasePrice, purchaseDate);
    String incorrectPurchasePrice = "-7000";
    assert !productService.purchaseProducts(categoryIphone, numberProducts, incorrectPurchasePrice, purchaseDate);
    String incorrectPurchaseDate = "2510.2017";
    assert !productService.purchaseProducts(categoryIphone,numberProducts, purchasePrice, incorrectPurchaseDate);
  }

  @Test
  public void demandProducts() {

    String categoryMeizu = "Meizu";
    categoryService.addCategory(categoryMeizu);
    String numberProducts = "5";
    String purchaseDate = "25.10.2017";
    String purchasePrice = "7000";
    productService.purchaseProducts(categoryMeizu, numberProducts, purchasePrice, purchaseDate);
    String numberDemandProducts = "2";
    String demandDate = "27.10.2017";
    String demandPrice = "10000";
    assert productService.demandProducts(categoryMeizu, numberDemandProducts, demandPrice, demandDate);
    String nonExistCategory = "yotaPhone";
    assert !productService.demandProducts(nonExistCategory,  numberDemandProducts, demandPrice, demandDate);
    String overStockDemandNumber = "15";
    assert !productService.demandProducts(categoryMeizu, overStockDemandNumber, demandPrice, demandDate);
    String dateDemandBeforeDatePurchase = "24.05.1993";
    assert !productService.demandProducts(categoryMeizu, numberDemandProducts, demandPrice, dateDemandBeforeDatePurchase);
    String incorrectNumberProducts = "seven phones";
    assert !productService.purchaseProducts(categoryMeizu, incorrectNumberProducts, purchasePrice, purchaseDate);
    String negativeNumver = "-4";
    assert !productService.purchaseProducts(categoryMeizu, negativeNumver, purchasePrice, purchaseDate);
    String incorrectPurchasePrice = "-7000";
    assert !productService.purchaseProducts(categoryMeizu, numberProducts, incorrectPurchasePrice, purchaseDate);
    String incorrectPurchaseDate = "2510.2017";
    assert !productService.purchaseProducts(categoryMeizu,numberProducts, purchasePrice, incorrectPurchaseDate);

  }
}