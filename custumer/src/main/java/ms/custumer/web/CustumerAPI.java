package ms.custumer.web;

import ms.custumer.dto.CustumerRequest;
import ms.custumer.dto.CustumerResponse;
import ms.custumer.services.CustumerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CustumerAPI {
    @Value("${param}")
    private String config;
    private CustumerService custumerService;
    public CustumerAPI(CustumerService custumerService){this.custumerService = custumerService;}

    @GetMapping( "/config")
    public String getConfig(){
        return "configuration:" + this.config;
    }
    @GetMapping( "/custumers")
    public List<CustumerResponse> getAllCustumers(){
        return  custumerService.getCustumers();
    }

    @GetMapping("/custumer/{id}")
    public CustumerResponse getOneCustumer(@PathVariable Long id){
        return custumerService.getCustumer(id);
    }

    @PostMapping( "/custumer")
    public CustumerResponse saveCustumer(@RequestBody CustumerRequest custumerRequest){
        return custumerService.save(custumerRequest);
    }
    @PutMapping( "/custumer")
    public CustumerResponse editCustumer(@RequestBody CustumerRequest custumerRequest){
        return custumerService.updateCustumer(custumerRequest);
    }

    @DeleteMapping("/custumer/{id}")
    public void removeCustumer(@PathVariable Long id){custumerService.deleteCustumer(id);}

}
