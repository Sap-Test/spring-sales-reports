package edu.wctc.salesReport.implementation;

import edu.wctc.salesReport.Sale;
import edu.wctc.salesReport.iface.SalesInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput implements SalesInput {


    @Override
    public List<Sale> getSales() {
        List<Sale> saleList = new ArrayList<>();

        File file = new File("sales.txt");
        try {
            Scanner reader = new Scanner(file);

            while(reader.hasNext()){
                String line = reader.nextLine();
                String[] contents = line.split(",");

                Sale sale = new Sale();
                sale.setName(contents[0]);
                sale.setCountry(contents[1]);
                sale.setAmount(Double.parseDouble(contents[2]));
                sale.setTax(Double.parseDouble(contents[3]));

                saleList.add(sale);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return saleList;
    }
}
