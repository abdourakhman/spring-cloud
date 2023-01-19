package service.bill.openfeign;


import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.bill.models.Custumer;

import java.util.List;

@FeignClient(name="CUSTUMER-SERVICE")
public interface CustumerRestClient {
    @GetMapping("/api/custumer/{id}")
    Custumer getCustumer(@PathVariable Long id);

    @GetMapping("/api/custumers")
    List<Custumer> allCustomers();
}
