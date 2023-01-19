package service.bill.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Custumer {
    private Long id;
    private String name;
    private String adresse;
    private String contact;
    private String email;
}
