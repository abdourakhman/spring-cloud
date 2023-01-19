package service.bill.services;


import org.springframework.stereotype.Service;
import service.bill.dto.BillRequest;
import service.bill.dto.BillResponse;
import service.bill.mappers.BillMapper;
import service.bill.models.Bill;
import service.bill.models.Custumer;
import service.bill.openfeign.CustumerRestClient;
import service.bill.repositories.BillRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final BillMapper  billMapper;
    private final CustumerRestClient custumerRestClient;

    public BillServiceImpl(BillRepository billRepository, BillMapper billMapper, CustumerRestClient custumerRestClient){
        this.billMapper = billMapper;
        this.billRepository = billRepository;
        this.custumerRestClient = custumerRestClient;
    }
    @Override
    public BillResponse save(BillRequest billRequest) {
        Bill bill = billMapper.toEntity(billRequest);
        bill.setDate(LocalDate.now());
        Bill billCreated = billRepository.save(bill);
        return billMapper.fromEntity(billCreated);
    }

    @Override
    public BillResponse update(BillRequest billRequest) {
        Bill bill = billMapper.toEntity(billRequest);
        bill.setDate(LocalDate.now());
        Bill billUpdated = billRepository.save(bill);
        return billMapper.fromEntity(billUpdated);
    }

    @Override
    public List<BillResponse> getAll() {
        return billRepository.findAll().stream().map(billMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public BillResponse get(Long id) {
        Bill bill = billRepository.findById(id).get();
        return billMapper.fromEntity(bill);
    }

    @Override
    public List<BillResponse> getByCustumerID(Long id) {
        List<BillResponse> bills = new ArrayList<>();
        Custumer custumer = custumerRestClient.getCustumer(id);
        billRepository.getBillByCustumerID(id).forEach(bill -> {
            bill.setCustumer(custumer);
            bills.add(billMapper.fromEntity(bill));});
        return bills;
    }


    @Override
    public void delete(Long id) {
        billRepository.deleteById(id);
    }
}
