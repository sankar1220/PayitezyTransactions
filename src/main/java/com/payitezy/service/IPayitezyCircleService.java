package com.payitezy.service;

import com.payitezy.domain.PayitezyCircle;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface IPayitezyCircleService {

    PayitezyCircle create(PayitezyCircle pc);

    List<PayitezyCircle> getAll();

    PayitezyCircle getPayitezyCircle(String circleId);

    PayitezyCircle getPayitezyCircleByApiCircle(String circle);

}
