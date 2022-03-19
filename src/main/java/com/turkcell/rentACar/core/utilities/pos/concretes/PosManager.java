package com.turkcell.rentACar.core.utilities.pos.concretes;

import com.turkcell.rentACar.core.utilities.pos.abstracts.PosService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PosManager implements PosService {

    @Override
    public boolean payment(String cardHolder, int cardNo, LocalDate expirationDate, int cvv) {
        return true;
    }
}
