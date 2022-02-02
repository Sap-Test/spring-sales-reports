package edu.wctc.salesReport;

import edu.wctc.salesReport.iface.SalesInput;
import edu.wctc.salesReport.iface.SalesReport;
import edu.wctc.salesReport.iface.ShippingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SalesGeneration {

    @Autowired
    private SalesInput salesInput;
    @Autowired
    private SalesReport salesReport;
    @Autowired
    private ShippingPolicy shippingPolicy;

    public void generateReport(){
        List<Sale> allSales = salesInput.getSales();
        for(Sale sale : allSales)
            shippingPolicy.applyShipping(sale);
        salesReport.generateReport(allSales);
    }
}
