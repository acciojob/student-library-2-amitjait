package com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String transactionId = UUID.randomUUID().toString(); // externalId

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("books")
    private Card card;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactions")
    private Book book;

    @Column
    private int fineAmount;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean isIssueOperation;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;
}

