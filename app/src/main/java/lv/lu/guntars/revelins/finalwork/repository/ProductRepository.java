package lv.lu.guntars.revelins.finalwork.repository;


import lv.lu.guntars.revelins.finalwork.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class ProductRepository implements Repository<Product> {

    private Long idCounter = 0L;

    private Map<Long, Product> repository = new HashMap<>();

    @Override
    public Long save(Product product) {
        idCounter++;
        repository.put(idCounter, product);
        product.setId(idCounter);
        return idCounter;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Product findById(Long id) {
        return repository.get(id);
    }

    @Override
    public void delete(Long id) {
        repository.remove(id);
    }
}
