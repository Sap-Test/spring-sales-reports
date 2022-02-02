package edu.wctc.salesReport.implementation;

import edu.wctc.salesReport.Sale;
import edu.wctc.salesReport.iface.ShippingPolicy;

public class FlatRateDomesticShipping implements ShippingPolicy {

    @Override
    public void applyShipping(Sale sale) {


        if(sale.getCountry().equalsIgnoreCase("united states"))
            sale.setShipping(5.99);
        if(sale.getCountry().equalsIgnoreCase("india"))
            sale.setShipping(11.79);
        if(sale.getCountry().equalsIgnoreCase("scotland"))
            sale.setShipping(7.54);
        if(sale.getCountry().equalsIgnoreCase("japan"))
            sale.setShipping(14.50);
    }
}
