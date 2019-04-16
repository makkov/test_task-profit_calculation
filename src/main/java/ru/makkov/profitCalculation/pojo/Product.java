package ru.makkov.profitCalculation.pojo;

import java.util.Date;
import java.util.Objects;

public class Product {

  private Category category;
  private Integer pricePurchase;
  private Date datePurchase;
  private Integer priceDemand;
  private Date dateDemand;

  public Product(Category category, Integer pricePurchase, Date datePurchase) {
    this.category = category;
    this.pricePurchase = pricePurchase;
    this.datePurchase = datePurchase;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Integer getPricePurchase() {
    return pricePurchase;
  }

  public void setPricePurchase(Integer pricePurchase) {
    this.pricePurchase = pricePurchase;
  }

  public Date getDatePurchase() {
    return datePurchase;
  }

  public void setDatePurchase(Date datePurchase) {
    this.datePurchase = datePurchase;
  }

  public Integer getPriceDemand() {
    return priceDemand;
  }

  public void setPriceDemand(Integer priceDemand) {
    this.priceDemand = priceDemand;
  }

  public Date getDateDemand() {
    return dateDemand;
  }

  public void setDateDemand(Date dateDemand) {
    this.dateDemand = dateDemand;
  }

  @Override
  public String toString() {
    return "Product{" +
        "category=" + category +
        ", pricePurchase=" + pricePurchase +
        ", datePurchase=" + datePurchase +
        ", priceDemand=" + priceDemand +
        ", dateDemand=" + dateDemand + "\n" +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return category.equals(product.category) &&
        pricePurchase.equals(product.pricePurchase) &&
        datePurchase.equals(product.datePurchase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, pricePurchase, datePurchase);
  }
}
