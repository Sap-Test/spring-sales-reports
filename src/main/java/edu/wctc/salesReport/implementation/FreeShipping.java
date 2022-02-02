package edu.wctc.salesReport.implementation;

import edu.wctc.salesReport.Sale;
import edu.wctc.salesReport.iface.ShippingPolicy;

public class FreeShipping implements ShippingPolicy {

    @Override
    public void applyShipping(Sale sale) {

        sale.setShipping(0.00);

    }


}
