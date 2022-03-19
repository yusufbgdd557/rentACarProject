package com.turkcell.rentACar.business.concretes;

import com.turkcell.rentACar.business.abstracts.PaymentService;
import com.turkcell.rentACar.business.dtos.brandDtos.BrandDto;
import com.turkcell.rentACar.business.dtos.brandDtos.BrandListDto;
import com.turkcell.rentACar.business.dtos.paymentDtos.PaymentDto;
import com.turkcell.rentACar.business.dtos.paymentDtos.PaymentListDto;
import com.turkcell.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.turkcell.rentACar.business.requests.paymentRequests.UpdatePaymentRequest;
import com.turkcell.rentACar.core.utilities.businessException.BusinessException;
import com.turkcell.rentACar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACar.core.utilities.pos.abstracts.PosService;
import com.turkcell.rentACar.core.utilities.results.DataResult;
import com.turkcell.rentACar.core.utilities.results.Result;
import com.turkcell.rentACar.core.utilities.results.SuccessDataResult;
import com.turkcell.rentACar.dataAccess.abstracts.PaymentDao;
import com.turkcell.rentACar.entities.concretes.Payment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentManager implements PaymentService {

    private PaymentDao paymentDao;
    private ModelMapperService modelMapperService;
    private PosService posService;

    public PaymentManager(PaymentDao paymentDao, ModelMapperService modelMapperService, PosService posService) {
        this.paymentDao = paymentDao;
        this.modelMapperService = modelMapperService;
        this.posService = posService;
    }

    @Override
    public Result update(int id, UpdatePaymentRequest updatePaymentRequest) throws BusinessException {
        return null;
    }

    @Override
    public DataResult<List<PaymentListDto>> getAll() throws BusinessException {

        List<Payment> payments = this.paymentDao.findAll();

        List<PaymentListDto> paymentListDtos = payments.stream()
                .map(payment -> this.modelMapperService.forDto().map(payment, PaymentListDto.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(paymentListDtos, "Data listed Successfully: ");
    }

    @Override
    public Result add(CreatePaymentRequest createPaymentRequest) throws BusinessException {

        Payment payment = this.modelMapperService.forRequest().map(createPaymentRequest,Payment.class);
        payment.setPaymentDate(LocalDate.now());
        this.paymentDao.save(payment);

        return new SuccessDataResult(createPaymentRequest, "Data added : ");

    }

    @Override
    public DataResult<PaymentDto> getById(int id) throws BusinessException {

        Payment payment = this.paymentDao.getById(id);
        PaymentDto paymentDto = this.modelMapperService.forDto().map(payment,PaymentDto.class);
        return new SuccessDataResult<>(paymentDto,"Data brought successfully");
    }

    @Override
    public Result delete(int id) throws BusinessException {

        PaymentDto paymentDto = this.modelMapperService.forDto().map(this.paymentDao.getById(id), PaymentDto.class);

        this.paymentDao.deleteById(id);

        return new SuccessDataResult<>(paymentDto,"Data deleted");
    }
}
