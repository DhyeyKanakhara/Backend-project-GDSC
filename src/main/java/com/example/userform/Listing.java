package com.example.userform;

import javax.persistence.*;

@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @JsonView(View.Private.class)
    private long id;

    @JsonView(View.Public.class)
    @NotNull(message = "Listing name cannot be empty")
    private String name;

    @JsonView(View.Public.class)
    private String address;



}
