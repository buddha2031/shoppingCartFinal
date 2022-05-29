package com.shoppingCart.DTO;

import java.util.List;

public class CustomerDTO {
    private String custName;
    private Integer mobNumber;
    private String country;
    private List<ItemDTO> items;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(Integer mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }



}
