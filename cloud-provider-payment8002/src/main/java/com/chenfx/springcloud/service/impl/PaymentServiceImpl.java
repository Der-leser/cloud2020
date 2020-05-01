package com.chenfx.springcloud.service.impl;

import com.chenfx.springcloud.dao.PaymentDao;
import com.chenfx.springcloud.entities.Payment;
import com.chenfx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao payMentDao;

    @Override
    public int create(Payment payment) {
        return payMentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return payMentDao.getPaymentById(id);
    }
}
