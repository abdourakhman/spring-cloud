package service.bill.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor @Entity
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amount;
    private LocalDate date;
    private Long custumerID;
    @Transient
    private Custumer custumer;
}
