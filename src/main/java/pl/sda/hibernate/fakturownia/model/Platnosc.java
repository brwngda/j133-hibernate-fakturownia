package pl.sda.hibernate.fakturownia.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platnosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataRealizacji;

    @Enumerated(EnumType.STRING)
    private FormaPlatnosci formaPlatnosci;

    private Double kwota;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Faktura faktura;

}
