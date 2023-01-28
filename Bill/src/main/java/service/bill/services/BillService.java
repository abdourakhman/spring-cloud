package service.bill.services;

import service.bill.dto.BillCustumerResponse;
import service.bill.dto.BillRequest;
import service.bill.dto.BillResponse;

import java.util.List;

public interface BillService {
    BillResponse save(BillRequest billRequest);
    BillResponse update(BillRequest billRequest);
    List<BillResponse> getAll();
    BillResponse get(Long id);
    List<BillCustumerResponse> getByCustumerID(Long id);
    void delete(Long id );
}
