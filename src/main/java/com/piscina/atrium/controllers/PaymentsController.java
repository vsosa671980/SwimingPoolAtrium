package com.piscina.atrium.controllers;


import com.piscina.atrium.dao.services.IPayments;
import com.piscina.atrium.dao.services.PaymentsService;
import com.piscina.atrium.dao.services.UserService;
import com.piscina.atrium.dao.services.bonosService;
import com.piscina.atrium.models.Bonos;
import com.piscina.atrium.models.Payments;
import com.piscina.atrium.models.Users;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments")
public class PaymentsController {


    @Autowired
    private PaymentsService service;
    
    @Autowired 
    private UserService user;

    @Autowired
    private bonosService bonoservice;


 

    @PostMapping("/save")
    public String payDo(@ModelAttribute("paymentForm") Payments payment,Bonos bono){

        service.createPayment(payment);
        
        LocalDate dateInit =payment.getDatePay();
        long id =payment.getIdu().getIdusers();
        String nameSub =payment.getIdSubscription().getTypeSubscription();
        Long timeSubs =  (long) payment.getIdSubscription().getDuration();
        
        LocalDate dayFinish =(dateInit.plusDays(timeSubs));
        System.out.println(payment.getIdSubscription().getDuration());
        
        user.foundUserByid(id);
        
        bono.setBonoName(nameSub);
        bono.setDateFinish(dayFinish);
        bono.setDateInit(dateInit);
        bono.setUser(user.foundUserByid(id));
        bono.setState();
        
        
        bonoservice.insertBonos(bono);
        
        
        
        
        
        


    return "/Congratulations/payCorrect";

    }
}
