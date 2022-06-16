package com.shoppingCartFinal.DTO;

import lombok.*;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CustomerDTO {
  //  private Customer customer;
    private String custName;
    private Long mobileNumber;
    private String country;
    private List<ItemsDTO> items;


}
