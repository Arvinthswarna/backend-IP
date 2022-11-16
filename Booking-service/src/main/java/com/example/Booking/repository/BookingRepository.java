package com.example.Booking.repository;

import com.example.Booking.entity.BookingOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingOne, Long> {


    BookingOne findByBookingId(Long bookingid);
}
