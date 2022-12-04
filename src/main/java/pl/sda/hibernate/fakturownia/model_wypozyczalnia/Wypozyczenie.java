package pl.sda.hibernate.fakturownia.model_wypozyczalnia;

import jakarta.persistence.*;
import lombok.*;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataWypozyczenia;
    private LocalDate dataKoncowa;
    private String numerUmowy;
    private Double cenaNajmu;



    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Klient klientY;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Samochod samochodX;

    @OneToOne (mappedBy = "wypozyczenieZ")
    @EqualsAndHashCode.Exclude
    private Zwrot zwrot;
}
