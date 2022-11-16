package com.example.Booking.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    private Long tourId;
    private String tourName;
    private Long tourCost;
    private Long tourDays;
}
