package com.turkcell.rentACar.business.abstracts;

import com.turkcell.rentACar.business.dtos.paymentDtos.PaymentDto;
import com.turkcell.rentACar.business.dtos.paymentDtos.PaymentListDto;
import com.turkcell.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.turkcell.rentACar.business.requests.paymentRequests.UpdatePaymentRequest;
import com.turkcell.rentACar.core.utilities.businessException.BusinessException;
import com.turkcell.rentACar.core.utilities.results.DataResult;
import com.turkcell.rentACar.core.utilities.results.Result;

import java.util.List;

public interface PaymentService {

    Result update(int id, UpdatePaymentRequest updatePaymentRequest) throws BusinessException;

    DataResult<List<PaymentListDto>> getAll() throws BusinessException;

    Result add(CreatePaymentRequest createPaymentRequest) throws BusinessException;

    DataResult<PaymentDto> getById(int id) throws BusinessException;

    Result delete(int id) throws BusinessException;

}
