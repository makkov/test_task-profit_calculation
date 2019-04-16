package ru.makkov.profitCalculation.service.serviceImpl;


import ru.makkov.profitCalculation.pojo.Category;
import ru.makkov.profitCalculation.repository.CategoryRepository;
import ru.makkov.profitCalculation.repository.repositoryImpl.CategoryRepositoryImpl;
import ru.makkov.profitCalculation.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository = new CategoryRepositoryImpl();

  @Override
  public boolean addCategory(String categoryName) {
    if (categoryName != null) {
      Category newCategory = new Category(categoryName);
      return categoryRepository.addCategory(newCategory);
    }
    return false;
  }
}
