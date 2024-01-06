package com.shop.flower.dao;

import com.shop.flower.entity.Customer;

public interface CustomerDAO {
    Customer retrieve(int id);
    Customer add(Customer customerToAdd);
    Customer update(Customer customerToUpdate);
    void delete(int id);
}
