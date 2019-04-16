package ru.makkov.profitCalculation.repository.repositoryImpl;

import ru.makkov.profitCalculation.pojo.Category;
import ru.makkov.profitCalculation.pojo.Product;
import ru.makkov.profitCalculation.repository.ProductRepository;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

  private static List<Product> productList = new LinkedList<>();

  @Override
  public void purchaseProduct(Product product) {
    productList.add(product);
  }

  @Override
  public void demandProduct(Product product, Integer priceDemand, Date dateDemand) {
    product.setPriceDemand(priceDemand);
    product.setDateDemand(dateDemand);
  }

  @Override
  public List<Product> getAllProducts() {

    productList.sort(new Comparator<Product>() {
      @Override
      public int compare(Product o1, Product o2) {
        return o1.getDatePurchase().compareTo(o2.getDatePurchase());
      }
    });
    return productList;
  }

  @Override
  public Integer getTailingsProductInStock(Category category) {
    int tailings = 0;
    for (Product product : productList) {
      if (product.getCategory().equals(category) & product.getDateDemand() == null) {
        tailings += 1;
      }
    }
    return tailings;
  }

  @Override
  public Integer getSalesReport(Category category, Date date) {
    if (productList.isEmpty()) {
      return null;
    }
      int report = 0;
      for (Product product : productList) {
          if (product.getCategory().equals(category) && product.getDateDemand() != null && product.getDateDemand().before(date)) {
              report += product.getPriceDemand() - product.getPricePurchase();
          }
      }
      return report;
  }
}
