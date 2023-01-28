package service.bill.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import service.bill.dto.BillCustumerResponse;
import service.bill.dto.BillRequest;
import service.bill.dto.BillResponse;
import service.bill.services.BillService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillAPI {
    @Value("${param}")
    private String config;
    private BillService billService;

    public BillAPI(BillService billService){
        this.billService = billService;
    }

    @GetMapping( "/config")
    public String getConfig(){
        return "configuration:" + this.config;
    }

    @GetMapping("/bills")
    public List<BillResponse> getAllBill(){
        return billService.getAll();
    }

    @GetMapping("/bills/{id}")
    public List<BillCustumerResponse> getBillOfCustumer(@PathVariable Long id){
        return billService.getByCustumerID(id);
    }

    @GetMapping("/bill/{id}")
    public BillResponse getBill(@PathVariable Long id){
        return billService.get(id);
    }

    @PostMapping("/bill")
    public BillResponse createBill(@RequestBody BillRequest billRequest){
        return billService.save(billRequest);
    }

    @PutMapping("/bill")
    public BillResponse updateBill(@RequestBody BillRequest billRequest){
        return billService.update(billRequest);
    }

    @DeleteMapping("bill/{id}")
    public void deleteBill(@PathVariable Long id){
        billService.delete(id);
    }
}
