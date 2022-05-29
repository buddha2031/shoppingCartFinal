package com.shoppingCart.service;

import com.shoppingCart.DTO.CustomerDTO;
import com.shoppingCart.DTO.ItemDTO;
import com.shoppingCart.entity.Customer;
import com.shoppingCart.entity.FoodItem;
import com.shoppingCart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    @Autowired
    public ShoppingCartRepository shoppingCartRepository;

    public Boolean saveData(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        shoppingCartRepository.save(customer);
       return false;
    }


    public Boolean deleteCustomerData(CustomerDTO customerDTO) {
        Customer customer=new Customer();
        shoppingCartRepository.delete(customer);
        return false;
    }
}
