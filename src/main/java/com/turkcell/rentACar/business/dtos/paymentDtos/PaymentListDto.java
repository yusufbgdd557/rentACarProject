package com.turkcell.rentACar.business.dtos.paymentDtos;

import com.turkcell.rentACar.business.dtos.invoiceDtos.InvoiceDto;
import com.turkcell.rentACar.entities.concretes.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentListDto {

    private int paymentId;

    private boolean paymentStatus;

    private LocalDate paymentDate;

    private InvoiceDto invoiceDto;
}
