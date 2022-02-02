package edu.wctc.salesReport.implementation;

import edu.wctc.salesReport.Sale;
import edu.wctc.salesReport.iface.SalesReport;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountrySummaryReport implements SalesReport {
    @Override
    public void generateReport(List<Sale> salesList) {

        StringBuilder sb;

        final int formatWidth = -20;
        final String format = " %" + formatWidth + "s  %" + formatWidth + "s  %" + formatWidth + "s  %" + formatWidth + "s \n";

        System.out.println("SALES SUMMARY REPORT");
        sb = new StringBuilder(String.format(format, "Country", "Amount", "Tax", "Shipping"));
        sb.append(String.format(format, "----------", "-----------", "----------", "----------"));

        List<Sale> sortedList = salesList.stream().sorted(Comparator.comparing(Sale::getCountry)).collect(Collectors.toList());

        String country = null;
        double amountTotal = 0.0, taxTotal = 0.0, shippingTotal = 0.0;

        for (Sale sale : sortedList) {
            if (!Objects.equals(country, sale.getCountry())) {

                if (country != null) {
                    sb.append(String.format(format, country, amountTotal, taxTotal, shippingTotal));
                }

                shippingTotal = sale.getShipping();
                amountTotal = sale.getAmount();
                taxTotal = sale.getTax();
                country = sale.getCountry();

            } else {
                shippingTotal += sale.getShipping();
                amountTotal += sale.getAmount();
                taxTotal += sale.getTax();
            }
        }

        sb.append(String.format(format, country, amountTotal, taxTotal, shippingTotal));
        System.out.println(sb);
    }
}
