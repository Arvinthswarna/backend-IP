package com.example.Booking.service;


import com.example.Booking.VO.Customer;
import com.example.Booking.VO.ResponseTemplateVO;
import com.example.Booking.VO.Tour;
import com.example.Booking.entity.BookingOne;
import com.example.Booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private  BookingRepository bookingRepository;
    @Autowired
    private RestTemplate restTemplate;

    public BookingOne saveBooking(BookingOne booking) {
        return bookingRepository.save(booking);
    }

    public  List<BookingOne> getAllBooking() {
        return bookingRepository.findAll();
    }



    public ResponseTemplateVO getBookingById(Long bookingid) {
        ResponseTemplateVO rtVO = new ResponseTemplateVO();
        BookingOne booking = bookingRepository.findByBookingId(bookingid);
        Customer customer= restTemplate.getForObject("http://localhost:4000/customers/"+booking.getCustId(),Customer.class);
        Tour tour = restTemplate.getForObject("http://localhost:4001/tour/"+booking.getTourId(), Tour.class);
        rtVO.setBooking(booking);
        rtVO.setCustomer(customer);
        rtVO.setTour(tour);
        return rtVO;
    }

}
