package org.covert.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double levelVegetation;

    public District(String name, double levelVegetation, List<Solutions> solutions) {
        this.name = name;
        this.levelVegetation = levelVegetation;
        this.solutions = solutions;
    }

    public District(String name, double levelVegetation) {
        this.name = name;
        this.levelVegetation = levelVegetation;
    }

    @ManyToMany
    @JoinTable(
            name = "district_solutions",
            joinColumns = @JoinColumn(name = "district_id"),
            inverseJoinColumns = @JoinColumn(name = "solution_id"))
    private List<Solutions> solutions;
}
