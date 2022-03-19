package com.turkcell.rentACar.business.dtos.paymentDtos;

import com.turkcell.rentACar.business.dtos.invoiceDtos.InvoiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private int paymentId;

    private boolean paymentStatus;

    private LocalDate paymentDate;

    private InvoiceDto invoiceDto;
}
