package com.payitezy.service;

import com.payitezy.dao.PayitezyCircleRepository;
import com.payitezy.domain.PayitezyCircle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayitezyCircleService implements IPayitezyCircleService {

    @Autowired
    private PayitezyCircleRepository payitezyCircleRepository;

    @Override
    public PayitezyCircle create(final PayitezyCircle pc) {
        // TODO Auto-generated method stub
        return payitezyCircleRepository.save(pc);

    }

    @Override
    public List<PayitezyCircle> getAll() {
        // TODO Auto-generated method stub
        return (List<PayitezyCircle>) payitezyCircleRepository.findAll();
    }

    @Override
    public PayitezyCircle getPayitezyCircle(final String circleId) {
        // TODO Auto-generated method stub
        return payitezyCircleRepository.findOne(circleId);
    }

    @Override
    public PayitezyCircle getPayitezyCircleByApiCircle(final String circle) {
        // TODO Auto-generated method stub
        return payitezyCircleRepository.findPayitezyCircleByApiCircle(circle);
    }

}
