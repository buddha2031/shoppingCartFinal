package com.shoppingCart.controller;

import com.shoppingCart.DTO.CustomerDTO;
import com.shoppingCart.DTO.ItemDTO;
import com.shoppingCart.entity.Customer;
import com.shoppingCart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/*
http://localhost:8080/shoppingCart/saveData
http://localhost:8080/shoppingCart/getData
* */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/saveData")
    public Boolean saveData(@RequestBody CustomerDTO custDTO) {
        return shoppingCartService.saveData(custDTO);

    }


    @GetMapping("/getData")
    public CustomerDTO getData(@RequestParam(name = "custId") Integer custId){
        return new CustomerDTO();
    }

    @DeleteMapping(value="/deletedate")
public Boolean deleteData(@RequestParam CustomerDTO custDTO){
    return shoppingCartService.deleteCustomerData(custDTO);
    }
}
