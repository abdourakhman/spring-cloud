package service.bill.mappers;

import org.mapstruct.Mapper;
import service.bill.dto.BillCustumerResponse;
import service.bill.dto.BillRequest;
import service.bill.dto.BillResponse;
import service.bill.models.Bill;

@Mapper(componentModel = "spring")
public interface BillMapper {
    BillResponse fromEntity(Bill bill);
    Bill toEntity(BillRequest billRequest);
    BillCustumerResponse fromBill(Bill bill);
}
