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
            billService.save(new BillRequest(145000,1L));
            billService.save(new BillRequest(555000,3L));
            billService.save(new BillRequest(95000,2L));
            billService.save(new BillRequest(15000,1L));
        };
    }
}
