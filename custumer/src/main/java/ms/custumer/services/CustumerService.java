package ms.custumer.services;

import ms.custumer.dto.CustumerRequest;
import ms.custumer.dto.CustumerResponse;

import java.util.List;

public interface CustumerService {
    CustumerResponse save(CustumerRequest custumerRequest);
    List<CustumerResponse> getCustumers();
    CustumerResponse getCustumer(Long id);
    CustumerResponse updateCustumer(CustumerRequest custumerRequest);
    void deleteCustumer(Long id);
}
