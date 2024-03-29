package ru.theft.bcs.waste.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.theft.bcs.gmv.model.Gmv;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "waste")
public class Waste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "amount", nullable = false)
    private double amount;
    @ManyToOne
    @JoinColumn(name = "gmv_id", referencedColumnName = "id")
    private Gmv gmv;
}
