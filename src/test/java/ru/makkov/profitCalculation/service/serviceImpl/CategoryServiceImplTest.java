package ru.makkov.profitCalculation.service.serviceImpl;

import org.junit.Test;
import ru.makkov.profitCalculation.service.CategoryService;

public class CategoryServiceImplTest {

  private CategoryService categoryService = new CategoryServiceImpl();

  @Test
  public void addCategory() {

    String categoryName = "Meizu";
    assert categoryService.addCategory(categoryName);
    assert !categoryService.addCategory(categoryName);
  }
}