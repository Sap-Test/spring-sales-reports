package edu.wctc.salesReport.iface;

import edu.wctc.salesReport.Sale;

import java.util.List;

public interface SalesReport {
    void generateReport(List<Sale> salesList);
}
