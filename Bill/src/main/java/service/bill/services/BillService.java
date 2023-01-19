package service.bill.services;

import service.bill.dto.BillRequest;
import service.bill.dto.BillResponse;

import java.util.List;

public interface BillService {
    BillResponse save(BillRequest billRequest);
    BillResponse update(BillRequest billRequest);
    List<BillResponse> getAll();
    BillResponse get(Long id);
    List<BillResponse> getByCustumerID(Long id);
    void delete(Long id );
}
