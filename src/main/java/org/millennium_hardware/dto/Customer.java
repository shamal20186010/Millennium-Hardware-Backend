package org.millennium_hardware.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long customerID;
    private String name;
    private String city;
    private String contact;
}
