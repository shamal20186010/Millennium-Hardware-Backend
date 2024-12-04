package org.millennium_hardware.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long itemID;
    private String name;
    private String rentalPerDay;
    private String findPerDay;
    private String availability;
}
