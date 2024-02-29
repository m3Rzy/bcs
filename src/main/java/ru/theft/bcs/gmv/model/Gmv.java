package ru.theft.bcs.gmv.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gmv")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Gmv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", unique = true)
    private String title;
    @Column(name = "amount", nullable = false)
    private double amount;
}
