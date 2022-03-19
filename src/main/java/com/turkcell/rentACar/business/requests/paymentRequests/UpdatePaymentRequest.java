package com.turkcell.rentACar.business.requests.paymentRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {

    private int invoiceId;

    private String cardHolderName;

    private int cardNo;

    private LocalDate expirationDate;

    private int cvv;
}
