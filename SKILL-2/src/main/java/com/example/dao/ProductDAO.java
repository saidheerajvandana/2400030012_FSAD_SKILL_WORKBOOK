package com.example.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Product;
import com.example.main.HibernateUtil;

public class ProductDAO {

    public void addProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(product);

        tx.commit();
        session.close();
    }

    public Product getProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();

        return product;
    }

    public void updateProduct(int id, double price) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);
        if (product != null) {
            product.setPrice(price);
            session.update(product);
        }

        tx.commit();
        session.close();
    }

    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }

        tx.commit();
        session.close();
    }
}