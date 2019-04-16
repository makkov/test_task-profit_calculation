package ru.makkov.profitCalculation.repository.repositoryImpl;

import ru.makkov.profitCalculation.pojo.Category;
import ru.makkov.profitCalculation.repository.CategoryRepository;

import java.util.LinkedList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

  private static List<Category> categoryList = new LinkedList<>();

  @Override
  public List<Category> getAllCategories() {
    return categoryList;
  }

  @Override
  public Category getCategoryByName(String name) {
    for (Category category : categoryList) {
      if (category.getName().equals(name)) {
        return category;
      }
    }
    return null;
  }

  @Override
  public boolean addCategory(Category category) {
    if (!categoryList.contains(category)) {
      categoryList.add(category);
      return true;
    }
    return false;
  }
}
