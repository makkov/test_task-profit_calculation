package ru.makkov.profitCalculation.service.serviceImpl;

import ru.makkov.profitCalculation.repository.CategoryRepository;
import ru.makkov.profitCalculation.repository.ProductRepository;
import ru.makkov.profitCalculation.repository.repositoryImpl.CategoryRepositoryImpl;
import ru.makkov.profitCalculation.repository.repositoryImpl.ProductRepositoryImpl;
import ru.makkov.profitCalculation.service.ReportService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportServiceImpl implements ReportService {

  private ProductRepository productRepository = new ProductRepositoryImpl();
  private CategoryRepository categoryRepository = new CategoryRepositoryImpl();

  @Override
  public void getSalesReportByProductOnDate(String categoryName, String date) {
    if (categoryRepository.getCategoryByName(categoryName) == null) {
      System.out.println("CHECK THE CATEGORY");
    } else {
      try {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date reportDate = simpleDateFormat.parse(date);
        Integer report = productRepository.getSalesReport(categoryRepository.getCategoryByName(categoryName), reportDate);
        if (report == null) {
          System.out.println("AT THIS MOMENT THERE ARE NO TRANSACTIONS");
        }
        System.out.println(report);
      } catch (ParseException e) {
        System.out.println("ERROR - INCORRECT DATA");
      }
    }
  }
}
