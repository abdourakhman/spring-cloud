package ms.custumer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** @noinspection SpellCheckingInspection*/
@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Custumer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adresse;
    private String contact;
    private String email;
}
