package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Builder
@Data

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String emailId;
    @Column
    private String name;
    @Column
    private int age; // in case we want to check on the basis of age while issuing

    @Column
    private String country;

    public Student() {
    }

    // alter table student add foreign key constraint card references Card(id)

    @OneToOne
    @JoinColumn   // join this column to the primary key of Card table
    @JsonIgnoreProperties("student")
    private Card card;


    @Column
    @CreationTimestamp
    private Date createdOn;

    @Column
    @UpdateTimestamp
    private Date updatedOn;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }

    public Student(String emailId, String name, int age, String country) {
        this.emailId = emailId;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    //    Student(java.lang.String,java.lang.String,int,java.lang.String)

}
