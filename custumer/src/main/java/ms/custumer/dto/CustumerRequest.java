package ms.custumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CustumerRequest {
    private Long id;
    private String name;
    private String adresse;
    private String contact;
    private String email;
}
