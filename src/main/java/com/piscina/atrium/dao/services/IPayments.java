package com.piscina.atrium.dao.services;

import com.piscina.atrium.dao.PaymentsDao;
import com.piscina.atrium.models.Payments;

public interface IPayments  {


    public void createPayment(Payments payment);

    public void deletePayment(Long id);


}
