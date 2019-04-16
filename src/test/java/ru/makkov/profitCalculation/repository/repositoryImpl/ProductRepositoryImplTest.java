package ru.makkov.profitCalculation.repository.repositoryImpl;

import org.junit.Test;
import ru.makkov.profitCalculation.pojo.Category;
import ru.makkov.profitCalculation.pojo.Product;
import ru.makkov.profitCalculation.repository.ProductRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ProductRepositoryImplTest {

  private ProductRepository productRepository = new ProductRepositoryImpl();

  @Test
  public void purchaseProduct() throws ParseException {
    Category categoryMeizu = new Category("Meizu");
    Date purchaseDate = new SimpleDateFormat("dd.MM.yyyy").parse("25.10.2017");
    Integer purchasePrice = 10000;
    Product meizuProduct = new Product(categoryMeizu, purchasePrice, purchaseDate);
    productRepository.purchaseProduct(meizuProduct);
    assert productRepository.getAllProducts().contains(meizuProduct);
  }

  @Test
  public void demandProduct() throws ParseException {

    Category categoryIphone = new Category("iphone");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date purchaseDate = simpleDateFormat.parse("25.10.2017");
    Integer pricePurchase = 500;
    Product newProduc = new Product(categoryIphone, pricePurchase, purchaseDate);
    assert (newProduc.getDateDemand() == null & newProduc.getPriceDemand() == null);
    Date dateDemand = simpleDateFormat.parse("30.10.2017");
    Integer priceDemand = 3000;
    productRepository.demandProduct(newProduc, priceDemand, dateDemand);
    assertEquals(newProduc.getDateDemand(), dateDemand);
    assertEquals(newProduc.getPriceDemand(), priceDemand);
  }

  @Test
  public void getTailingsProductInStock() throws ParseException {

    Category categoryMeizu = new Category("Meizu");
    Date purchaseDate = new SimpleDateFormat("dd.MM.yyyy").parse("25.10.2017");
    Integer purchasePrice = 10000;
    Product newProduct = new Product(categoryMeizu, purchasePrice, purchaseDate);
    productRepository.purchaseProduct(newProduct);
    productRepository.purchaseProduct(newProduct);
    assert productRepository.getTailingsProductInStock(categoryMeizu) == 2;
  }
}