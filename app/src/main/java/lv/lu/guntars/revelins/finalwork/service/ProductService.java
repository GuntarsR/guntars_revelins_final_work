package lv.lu.guntars.revelins.finalwork.service;

import lv.lu.guntars.revelins.finalwork.domain.Product;
import lv.lu.guntars.revelins.finalwork.domain.ProductCategory;
import lv.lu.guntars.revelins.finalwork.model.ProductData;
import lv.lu.guntars.revelins.finalwork.model.ProductInputData;
import lv.lu.guntars.revelins.finalwork.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final Repository<Product> productRepository;

    @Autowired
    public ProductService(Repository<Product> productOrmRepository) {
        this.productRepository = productOrmRepository;
    }

    public void save(ProductInputData productInputData) {
        Product product = convertFrom(productInputData);
        productRepository.save(product);
    }

    public List<ProductData> findAll() {
        List<ProductData> result = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            result.add(convertFrom(product));
        }
        return result;
    }

    private ProductData convertFrom(Product product) {
        return new ProductData(
                product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString());
    }

    private Product convertFrom(ProductInputData productInputData) {
        Product product = new Product();
        product.setName(productInputData.getName());
        product.setPrice(BigDecimal.valueOf(productInputData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productInputData.getCategory()));
        if (productInputData.getDiscount() != null) {
            product.setDiscount(BigDecimal.valueOf(productInputData.getDiscount()));
        }
        if (productInputData.getDescription() != null) {
            product.setDescription(productInputData.getDescription());
        }
        return product;
    }

}
