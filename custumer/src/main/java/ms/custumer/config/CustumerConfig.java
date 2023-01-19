package ms.custumer.config;

import ms.custumer.dto.CustumerRequest;
import ms.custumer.models.Custumer;
import ms.custumer.services.CustumerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustumerConfig {
    private CustumerService custumerService;
    public CustumerConfig(CustumerService custumerService){this.custumerService = custumerService;}

    @Bean
    public CommandLineRunner init(){
        return args -> {
            custumerService.save(new CustumerRequest(1L,"abdourahmane","gironde", "610392833","abdourakhman@gmail.com"));
            custumerService.save(new CustumerRequest(2L,"fama","rabat","610300833","fama@gmail.com"));
            custumerService.save(new CustumerRequest(3L,"sophie","derb omar","638392833","sophie@gmail.com"));
            custumerService.save( new CustumerRequest(4L,"mohamed","gironde","610392855","mohamed@gmail.com"));
            custumerService.save(new CustumerRequest(5L,"aziz","mer sultan","610902833","aziz@gmail.com"));
        };
    }
}
