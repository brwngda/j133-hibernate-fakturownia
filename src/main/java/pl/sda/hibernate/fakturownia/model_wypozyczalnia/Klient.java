package pl.sda.hibernate.fakturownia.model_wypozyczalnia;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;
    private String nazwisko;
    private String nip;

    @OneToMany(mappedBy = "klientY")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Wypozyczenie> wypozyczenia;
}
