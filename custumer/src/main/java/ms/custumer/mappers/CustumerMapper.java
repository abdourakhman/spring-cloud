package ms.custumer.mappers;

import ms.custumer.dto.CustumerRequest;
import ms.custumer.dto.CustumerResponse;
import ms.custumer.models.Custumer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustumerMapper {
    CustumerResponse fromEntity(Custumer custumer);
    Custumer toEntity(CustumerRequest custumerRequest);
}
