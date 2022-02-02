package edu.wctc.salesReport;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sale {

    private String name;
    private String country;
    private double amount;
    private double tax;
    private double shipping;
}
