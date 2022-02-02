package edu.wctc.salesReport.implementation;

import edu.wctc.salesReport.Sale;
import edu.wctc.salesReport.iface.SalesInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements SalesInput {
    @Override
    public List<Sale> getSales() {

        List<Sale> saleList = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        String response = "y";

        while (response.equalsIgnoreCase("y")) {
            // prompt for Name
            System.out.println("Enter Name: ");
            String name = keyboard.nextLine();

            // prompt for country
            System.out.println("Enter Country: ");
            String country = keyboard.nextLine();

            // prompt for Amount
            System.out.println("Enter Amount: ");
            double amount = Double.parseDouble(keyboard.nextLine());

            // prompt for tax
            System.out.println("Enter Tax: ");
            double tax = Double.parseDouble(keyboard.nextLine());

            // create article
            Sale sale = new Sale();
            sale.setName(name);
            sale.setCountry(country);
            sale.setAmount(amount);
            sale.setTax(tax);

            // add to list
            saleList.add(sale);

            System.out.println("More Customers? (y/n) ");
            response = keyboard.nextLine();
        }

        return saleList;
    }
}
