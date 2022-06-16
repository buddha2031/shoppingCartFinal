package com.shoppingCartFinal.controller;

import com.shoppingCartFinal.DTO.CustomerDTO;
import com.shoppingCartFinal.entity.Customer;
import com.shoppingCartFinal.service.ShoppingCartService;
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

    @PostMapping("/saveData")
    public Boolean saveData(@RequestBody List<CustomerDTO> customerDTOs) {
       shoppingCartService.saveDatas(customerDTOs);
        return true;
    }

   /* @PostMapping("/saveRecords")
    public Boolean saveRecords(@RequestBody List<CustomerDTO> customerDetails) {
        shoppingCartService.saveDatas(customerDetails);
        return true;
    }*/



    @GetMapping("/getData")
    public List<CustomerDTO> getData(){
        return shoppingCartService.getData() ;
    }

    @GetMapping(value="/fetchRecords", produces=MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO fetchData(@RequestParam("custId")Integer custId){
        System.out.println(custId);
        return  shoppingCartService.fetchRecords(custId);
    }


@GetMapping("/gethi")
public String getmessage(){
        return "hi";
}
    // updating a customer record


    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
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
    /*@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)

    public Boolean updateCustomerInformation(@RequestParam("custId")Integer custId) {

        return shoppingCartService.updateCustomerInformation(new CustomerDTO());
}*/


    @DeleteMapping(value="/deleteData",produces=MediaType.APPLICATION_JSON_VALUE)
public Customer deleteData(@RequestParam("custId") Integer custId){

        return shoppingCartService.deleteData(custId);
    }
}
