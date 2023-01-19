package service.bill.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.bill.dto.BillRequest;
import service.bill.services.BillService;

import java.util.Date;

@Configuration
public class BillConfig {
    private BillService billService;
    public BillConfig(BillService billService){this.billService = billService;}
    @Bean
    public CommandLineRunner init(){
        return args -> {
            billService.save(new BillRequest(1L,145000,1l));
            billService.save(new BillRequest(2L,555000,3l));
            billService.save(new BillRequest(3L,95000,2l));
            billService.save(new BillRequest(4L,15000,1l));
        };
    }
}
