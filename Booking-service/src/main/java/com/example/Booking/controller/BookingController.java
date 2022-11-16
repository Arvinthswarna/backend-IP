package com.example.Booking.controller;

import com.example.Booking.VO.ResponseTemplateVO;
import com.example.Booking.entity.BookingOne;
import com.example.Booking.repository.BookingRepository;
import com.example.Booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins="*")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingService bookingService;

    @PostMapping("/")
    public BookingOne saveBooking(@RequestBody BookingOne booking){
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getBookingById(@PathVariable("id") Long bookingid){
        return bookingService.getBookingById(bookingid);
    }

    @GetMapping("/fetch")
    public List<BookingOne> getAllbookings(){
        List<BookingOne> bookingOnes = new ArrayList<>();
        return bookingService.getAllBooking();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookingOne> updateBooking(@PathVariable("id") Long id, @RequestBody BookingOne booking){
        Optional<BookingOne> bookingData = bookingRepository.findById(id);
        if(bookingData.isPresent()){
            BookingOne _booking = bookingData.get();
            _booking.setBookingNumber(booking.getBookingNumber());
            _booking.setBookingStatus(booking.getBookingStatus());

            return new ResponseEntity<>(bookingRepository.save(_booking), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") Long id){
        try{
            bookingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
