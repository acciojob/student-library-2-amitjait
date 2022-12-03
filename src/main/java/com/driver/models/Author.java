package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private int age;

    @Column
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("author")
    private List<Book> booksWritten;

    public Author() {
    }

    public Author(String name, String email, int age, String country) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.country = country;
    }


}

