package ru.makkov.profitCalculation;

import ru.makkov.profitCalculation.service.serviceImpl.CategoryServiceImpl;
import ru.makkov.profitCalculation.service.serviceImpl.ProductServiceImpl;
import ru.makkov.profitCalculation.service.serviceImpl.ReportServiceImpl;

import java.util.Scanner;

public class ProfitCalculation {

  public static void main(String[] args) {
    System.out.println("PROGRAM STARTED");
    Scanner scanner = new Scanner(System.in);
    label:
    while (true) {
      String inputString = scanner.nextLine();
      String[] inputArrayString = inputString.split(" ");
      try {
        switch (inputArrayString[0]) {
          case "NEWPRODUCT":
            if (inputArrayString.length != 2) {
              System.out.println("INPUT ERROR");
              break;
            }
            CategoryServiceImpl categoryService = new CategoryServiceImpl();
            if (categoryService.addCategory(inputArrayString[1])) {
              System.out.println("OK");
            } else {
              System.out.println("ERROR");
            }
            break;
          case "PURCHASE": {
            if (inputArrayString.length != 5) {
              System.out.println("INPUT ERROR");
              break;
            }
            ProductServiceImpl productService = new ProductServiceImpl();
            if (productService.purchaseProducts(
                inputArrayString[1],
                inputArrayString[2],
                inputArrayString[3],
                inputArrayString[4]
            )) {
              System.out.println("OK");
            } else {
              System.out.println("ERROR");
            }
            break;
          }
          case "DEMAND": {
            if (inputArrayString.length != 5) {
              System.out.println("INPUT ERROR");
              break;
            }
            ProductServiceImpl productService = new ProductServiceImpl();
            if (productService.demandProducts(
                inputArrayString[1],
                inputArrayString[2],
                inputArrayString[3],
                inputArrayString[4]
            )) {
              System.out.println("OK");
            } else {
              System.out.println("ERROR");
            }
            break;
          }
          case "SALESREPORT":
            if (inputArrayString.length != 3) {
              System.out.println("INPUT ERROR");
              break;
            }
            ReportServiceImpl reportService = new ReportServiceImpl();
            reportService.getSalesReportByProductOnDate(inputArrayString[1], inputArrayString[2]);
            break;
          case "QUIT":
            if (inputArrayString.length != 1) {
              System.out.println("INPUT ERROR");
              break;
            }
            System.out.println("PROGRAM COMPLETED");
            break label;
          default:
            System.out.println("INPUT ERROR");
            break;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("INPUT ERROR");
      }
    }
  }
}
