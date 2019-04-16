package ru.makkov.profitCalculation.repository;

import ru.makkov.profitCalculation.pojo.Category;

import java.util.List;

public interface CategoryRepository {

  Category getCategoryByName(String name);
  boolean addCategory(Category category);
  List<Category> getAllCategories();
}
