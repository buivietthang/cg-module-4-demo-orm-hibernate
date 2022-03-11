package dao;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDao {
    @Autowired
    EntityManager entityManager;

    public List<Product> getList() {
        String queryStr = "SELECT p FROM Product p";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return (List<Product>) query.getResultList();
    }

    public void save(Product product) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(product);
        txn.commit();
    }
}
