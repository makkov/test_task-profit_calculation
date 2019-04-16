package ru.makkov.profitCalculation.repository.repositoryImpl;

import org.junit.Test;
import ru.makkov.profitCalculation.pojo.Category;
import ru.makkov.profitCalculation.repository.CategoryRepository;

import static org.junit.Assert.assertEquals;

public class CategoryRepositoryImplTest {

  private CategoryRepository categoryRepository = new CategoryRepositoryImpl();

  @Test
  public void getCategoryByName() {

    String categoryIphoneName = "iphone";
    Category iphone = new Category(categoryIphoneName);
    categoryRepository.addCategory(iphone);
    assertEquals(iphone, categoryRepository.getCategoryByName(categoryIphoneName));
  }

  @Test
  public void addCategory() {

    Category iphone = new Category("iphone");
    categoryRepository.addCategory(iphone);
    assert categoryRepository.getAllCategories().contains(iphone);
    assert !categoryRepository.addCategory(iphone);
  }
}