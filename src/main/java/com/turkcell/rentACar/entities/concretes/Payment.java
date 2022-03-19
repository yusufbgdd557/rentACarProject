package com.turkcell.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private int paymentId;

    @Column(name="card_holder_name")
    private String cardHolderName;

    @Column(name="card_no")
    private int cardNo;

    @Column(name="expiration_date")
    private LocalDate expirationDate;
    
    @Column(name="cvv")
    private int cvv;

    @Column(name="payment_status")
    private boolean paymentStatus;

    @Column(name="payment_date")
    private LocalDate paymentDate;

    @OneToOne
    private Invoice invoice;

}
