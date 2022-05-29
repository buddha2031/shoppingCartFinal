package com.shoppingCart.service;

import com.shoppingCart.DTO.CustomerDTO;
import com.shoppingCart.DTO.ItemDTO;
import com.shoppingCart.entity.Customer;
import com.shoppingCart.entity.Item;
import com.shoppingCart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    public ShoppingCartRepository shoppingCartRepository;



    public Boolean saveData(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        shoppingCartRepository.save(customer);
       return false;
    }




        // method to save all the records in the Customer DTO ( data transfer object )
        public boolean saveAllRecords(List<CustomerDTO> customerDTOList) {

            //Customer customer = new Customer(); // create a Customer object
            List<Item> foodItems = new ArrayList<>(); // Arraylist to store food items

            // save or transfer information from DTO object to Entity object
            for (CustomerDTO customerDTO : customerDTOList) {
                Customer customer = new Customer();
                customer.setCustName(customerDTO.getCustName());
                customer.setMobileNumber(customerDTO.getMobileNumber());
                customer.setCountry(customerDTO.getCountry());

                // create list of ItemsDTO to save the item list in the CustomerDTO
                List<ItemDTO> itemsDTOList = customerDTO.getItems(); // Items list retrieved from ItemDTO
                for (ItemDTO iterating : itemsDTOList) { // iterate through itemDTO list
                    Item items = new Item(); // create Item object
                    items.setItemName(iterating.getItemName()); // save item name
                    items.setQuantity(iterating.getQuantity());
                    foodItems.add(items);
                    customer.addItems(items); // invoke addItems method in Customer Entity class
                }
                customer.setItems(foodItems);

                shoppingCartRepository.save(customer); // saving the entire CustomerDTO object in to the Customer object
            }
            return true;
        }

        // fetch all customers
        public List<CustomerDTO> fetchRecords() {
            Iterable<Customer> customerList = shoppingCartRepository.findAll();
            List<CustomerDTO> customerDTOList = new ArrayList<>();
            Iterator iterator = customerList.iterator();
            while (iterator.hasNext()){
                Customer customer = (Customer) iterator.next();
                CustomerDTO customerDTO = new CustomerDTO();

                customerDTO.setCustName(customer.getCustName());
                customerDTO.setMobileNumber(customer.getMobileNumber());
                customerDTO.setCountry(customer.getCountry());
                List<ItemDTO> itemsDTOList = new ArrayList<>();
                for(Item items: customer.getItems()){
                    ItemDTO itemsDTO = new ItemDTO();
                    itemsDTO.setItemName(items.getItemName());
                    itemsDTO.setQuantity(items.getQuantity());
                    itemsDTOList.add(itemsDTO);
                }
                customerDTO.setItems(itemsDTOList);
                customerDTOList.add(customerDTO);


            }

            return customerDTOList; // return all the customer objects
        }


        public CustomerDTO fetchItemsSelectedByCustomer(Integer customerId) {
            Customer customer = new Customer();
            CustomerDTO customerDTO = new CustomerDTO();
            Optional<Customer> cust = shoppingCartRepository.findById(customerId);
            if(cust != null)
            {
                customer = cust.get();
                customerDTO.setCustName(customer.getCustName());
                customerDTO.setMobileNumber(customer.getMobileNumber());
                customerDTO.setCountry(customer.getCountry());
                List<ItemDTO> itemsDTOList = new ArrayList<>();
                for(Item items: customer.getItems()){
                    ItemDTO itemsDTO = new ItemDTO();
                    itemsDTO.setItemName(items.getItemName());
                    itemsDTO.setQuantity(items.getQuantity());
                    itemsDTOList.add(itemsDTO);
                }
                customerDTO.setItems(itemsDTOList);
            }


            return customerDTO;
        }





    // method to update the specific customer record
    /* 1. fetch a particular record
       2. do update on that record
       3. save the record (shoppingCartRepository.save(customer) )
     */
    public boolean updateCustomerInformation(CustomerDTO customerDTO, Integer custId) {
        Optional<Customer> optionalCustomer = shoppingCartRepository.findById(custId);
        if (optionalCustomer != null) {
            Customer newCustomer = optionalCustomer.get();
            newCustomer.setCustName(customerDTO.getCustName());
            newCustomer.setMobileNumber(customerDTO.getMobileNumber());
            newCustomer.setCountry(customerDTO.getCountry());
            List<ItemDTO> itemsDTOList = customerDTO.getItems();
            for (ItemDTO iterating : itemsDTOList) { // iterate through itemDTO list
                Item items = new Item(); // create Item object
                items.setItemName(iterating.getItemName()); // save item name
                items.setQuantity(iterating.getQuantity());
                //foodItems.add(items);
                newCustomer.addItems(items); // invoke addItems method in Customer Entity class
            }
            // save updated customer
            shoppingCartRepository.save(newCustomer);

        }
        return true;
    }

    public Boolean deleteCustomerData(Integer customerDTO) {
        Customer customer=new Customer();
        shoppingCartRepository.delete(customer);
        return false;
    }
}
