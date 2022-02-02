package edu.wctc.salesReport;


import edu.wctc.salesReport.iface.SalesInput;
import edu.wctc.salesReport.iface.SalesReport;
import edu.wctc.salesReport.iface.ShippingPolicy;
import edu.wctc.salesReport.implementation.DetailedSalesReport;
import edu.wctc.salesReport.implementation.FileInput;
import edu.wctc.salesReport.implementation.FlatRateDomesticShipping;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.wctc.salesReport")
public class MyApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyApp.class);
        context.refresh();

        ((SalesGeneration)context.getBean("salesGeneration")).generateReport();
    }

    @Bean
    public SalesInput salesInput() {
        return new FileInput();
    }

    @Bean
    public SalesReport salesReport() {
        return new DetailedSalesReport();
    }

    @Bean
    public ShippingPolicy shippingPolicy()
    {
        return new FlatRateDomesticShipping();
    }

}

