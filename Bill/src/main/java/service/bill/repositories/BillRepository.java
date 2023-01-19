package service.bill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.bill.dto.BillRequest;
import service.bill.models.Bill;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill,Long> {
    List<Bill> getBillByCustumerID(Long id);
}
