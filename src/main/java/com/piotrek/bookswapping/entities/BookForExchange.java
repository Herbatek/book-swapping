package com.piotrek.bookswapping.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BookForExchange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotBlank
    @NonNull
    @Size(min = 1, max = 200)
    private String title;

    //@NotBlank
    private String description;

    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private User user;

}