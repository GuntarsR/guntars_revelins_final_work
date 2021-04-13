package lv.lu.guntars.revelins.finalwork.repository;


import java.util.List;
import java.util.Map;
import lv.lu.guntars.revelins.finalwork.model.Product;

public class ProductRepository implements Repository<Product> {

    private Long idCounter = 0L;
    private final Map<Long, Product> repository;

    public ProductRepository(Map<Long, Product> repository) {
        this.repository = repository;
    }

    @Override
    public Long save(Product entity) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
