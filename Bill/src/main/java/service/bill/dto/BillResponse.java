package service.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import service.bill.models.Custumer;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillResponse {
    private Long id;
    private int amount;
    private LocalDate date;
    private Custumer custumer;
}

