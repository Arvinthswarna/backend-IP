package com.example.Booking.VO;

import com.example.Booking.entity.BookingOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private BookingOne booking;
    private Tour tour;
    private Customer customer;
}
