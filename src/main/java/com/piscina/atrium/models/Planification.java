package com.piscina.atrium.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planification")
public class Planification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanification;

    @Column(name = "planing_name")
    private String planingName;
    @Column(name = "plannind_day")
    private LocalDate planningDay;
    @Column(name = "init_time")
    private LocalTime initTime;
    @Column(name = "finish_time")
    private LocalTime finishtime;


    @ManyToMany
    private List<Street> street = new ArrayList<>();

    public Planification() {
    }

}
