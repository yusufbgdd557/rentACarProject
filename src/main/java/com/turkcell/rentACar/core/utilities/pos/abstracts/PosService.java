package com.turkcell.rentACar.core.utilities.pos.abstracts;


import java.time.LocalDate;

public interface PosService {

     boolean payment(String cardHolder, int cardNo, LocalDate expirationDate, int cvv);

}
