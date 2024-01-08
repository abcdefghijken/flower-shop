package com.ken.flowershop.dao;

import com.ken.flowershop.entity.Customer;

public interface CustomerDAO {
    Customer retrieve(int id);
    Customer add(Customer customerToAdd);
    Customer update(Customer customerToUpdate);
    void delete(int id);
}
