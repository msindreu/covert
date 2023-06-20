package org.covert.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solutions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;
    private String title;
    private String description;
    private int investment;

    public Solutions(Type type, String title, String description, int investment) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.investment = investment;
    }
}
