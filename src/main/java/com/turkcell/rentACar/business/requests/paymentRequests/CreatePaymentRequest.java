package com.turkcell.rentACar.business.requests.paymentRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

    private int invoiceId;

    private String cardHolderName;

    private int cardNo;

    private LocalDate expirationDate;

    private int cvv;


}
