package com.shoppingCart.controller;

import com.shoppingCart.DTO.CustomerDTO;
import com.shoppingCart.DTO.ItemDTO;
import com.shoppingCart.entity.Customer;
import com.shoppingCart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
http://localhost:8080/shoppingCart/saveData
http://localhost:8080/shoppingCart/getData
* */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

   /* @PostMapping("/saveData")
    public Boolean saveData(@RequestBody CustomerDTO custDTO) {
        return shoppingCartService.saveData(custDTO);

    }*/

/*

    @GetMapping("/getData")
    public CustomerDTO getData(@RequestParam(name = "custId") Integer custId){
        return new CustomerDTO();
    }
*/




        @PostMapping("/saveData")
        public Boolean saveData(@RequestBody List<CustomerDTO> customerDetails) {
           return shoppingCartService.saveAllRecords(customerDetails);

        }

        @GetMapping(value = "/getAllRecords", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<CustomerDTO> getAllRecords(){
            return shoppingCartService.fetchRecords();

        }


        @GetMapping(value = "/fetchData", produces = MediaType.APPLICATION_JSON_VALUE)
        public CustomerDTO fetchRecords(@RequestParam(name = "custId") Integer custId) {
            CustomerDTO customer = shoppingCartService.fetchItemsSelectedByCustomer(custId);
            return customer;
        }

        @DeleteMapping(value = "/deleteData")
        public void deleteCustomerData(@RequestParam(name = "custId") Integer custId) {
            shoppingCartService.deleteCustomerData(custId);
        }

    // updating a customer record
    @PutMapping(value = "/updateCustomerRecord", consumes = "application/json", produces = "application/json")
    public String updateCustomerRecord(@RequestBody CustomerDTO customerDTO, @RequestParam ("custId") Integer custId) {
        String status = "";
        System.out.println(custId);
        try {
            if(shoppingCartService.updateCustomerInformation(customerDTO, custId)){
                status = "record update successful!!!";
            }
            else
            {
                status = "failure, cannot update record!!!";
            }

        } catch (Exception e) {
            status = e.getMessage();
        }
        return status;
    }

    }
