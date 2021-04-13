package lv.lu.guntars.revelins.finalwork;

import lv.lu.guntars.revelins.finalwork.model.Product;
import lv.lu.guntars.revelins.finalwork.repository.ProductRepository;
import lv.lu.guntars.revelins.finalwork.service.ProductService;
import lv.lu.guntars.revelins.finalwork.ui.ConsoleUi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
         Map<Long, Product> repository = new HashMap<>();
        ProductRepository productRepository = new ProductRepository(repository);
        ProductService productService = new ProductService(productRepository);
        Scanner scanner = new Scanner(System.in);

        new ConsoleUi(productService, scanner).run();
    }
}
