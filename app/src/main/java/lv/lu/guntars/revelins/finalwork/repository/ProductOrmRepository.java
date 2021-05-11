package lv.lu.guntars.revelins.finalwork.repository;

import lv.lu.guntars.revelins.finalwork.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Transactional
@org.springframework.stereotype.Repository
public class ProductOrmRepository implements Repository<Product> {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductOrmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Product entity) {
        return (Long) this.sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public List<Product> findAll() {
//        return this.sessionFactory.getCurrentSession().createQuery("FROM PRODUCTS").list();
//        return this.sessionFactory.getCurrentSession().createQuery("FROM PRODUCTS P", Product.class).getResultList();
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Product> criteriaQuery = session.getCriteriaBuilder().createQuery(Product.class);
        criteriaQuery.from(Product.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
