package com.example.Booking.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long custId;
    private String custName;
    private String custEmail;
    private String custPhone;
    private String custCity;
    private String custState;
    private String custCountry;
}
