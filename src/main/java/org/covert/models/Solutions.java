package org.covert.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String title;
    private String description;
    private int investment;
    @ManyToMany(mappedBy = "solutions")
    private List<District> districts;

    public Solutions(Type type, String title, String description, int investment) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.investment = investment;
    }
}
