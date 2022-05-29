package com.shoppingCart.repository;

import com.shoppingCart.DTO.CustomerDTO;
import com.shoppingCart.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<Customer, Integer>{

}
