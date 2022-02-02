package edu.wctc.salesReport.implementation;

import edu.wctc.salesReport.Sale;
import edu.wctc.salesReport.iface.SalesReport;

import java.util.List;

public class DetailedSalesReport implements SalesReport {


    @Override
    public void generateReport(List<Sale> salesList) {

        StringBuilder sb;

        final int formatWidth = -20;
        final String format = " %" + formatWidth + "s  %" + formatWidth + "s  %" + formatWidth + "s  %" + formatWidth + "s  %" + formatWidth + "s \n";

        System.out.println("SALES DETAIL REPORT");
        sb = new StringBuilder(String.format(format,"Name","Country","Amount","Tax","Shipping"));
        sb.append(String.format(format,"----------","----------","-----------","----------","----------"));

        for(Sale sale : salesList) {
            sb.append(String.format(format, sale.getName(), sale.getCountry(), sale.getAmount(), sale.getTax(), sale.getShipping()));
        }

        System.out.println(sb);
    }
}
