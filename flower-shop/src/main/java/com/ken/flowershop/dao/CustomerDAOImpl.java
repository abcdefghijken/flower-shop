package com.ken.flowershop.dao;

import com.ken.flowershop.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager em;

    public CustomerDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Customer retrieve(int id) {
        return em.find(Customer.class, id);
    }

    @Override
    @Transactional
    public Customer add(Customer customerToAdd) {
        em.persist(customerToAdd);
        Customer updatedCustomer = em.find(Customer.class, customerToAdd.getId());
        return updatedCustomer;
    }

    @Override
    @Transactional
    public Customer update(Customer customerToUpdate) {
        Customer updatedCustomer = em.merge(customerToUpdate);
        em.refresh(updatedCustomer);
        return updatedCustomer;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Customer customerToDelete = em.find(Customer.class, id);
        em.remove(customerToDelete);
    }
}
