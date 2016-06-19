package com.payitezy.businessdelegate.service;

import com.payitezy.apiobjects.PrepaidMobileRechargePlans;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.merchanturls.datayuge.PrepaidMobileRechargePlanResources;
import com.payitezy.model.PrepaidMobileRechargePlansModel;
import com.payitezy.service.IPayitezyCircleService;
import com.payitezy.service.IPayitezyOperatorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

@Service
public class PrepaidMobileRechargePlansBusinessDelegate implements
IBusinessDelegate<PrepaidMobileRechargePlansModel, PrepaidMobileRechargePlansContext, IKeyBuilder<String>, String> {

    @Autowired
    private PrepaidMobileRechargePlanResources prepaidMobileRechargePlanResources;

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IPayitezyOperatorService payitezyOperatorService;
    @Autowired
    private IPayitezyCircleService payitezyCircleService;

    @Override
    public PrepaidMobileRechargePlansModel create(final PrepaidMobileRechargePlansModel model) {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final PrepaidMobileRechargePlansContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public PrepaidMobileRechargePlansModel edit(final IKeyBuilder<String> keyBuilder, final PrepaidMobileRechargePlansModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PrepaidMobileRechargePlansModel getByKey(final IKeyBuilder<String> keyBuilder, final PrepaidMobileRechargePlansContext context) {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    public Collection<PrepaidMobileRechargePlansModel> getCollection(final PrepaidMobileRechargePlansContext context) {
        // TODO Auto-generated method stub
        String operatorId = payitezyOperatorService.getPayitezyOperator(context.getOperatorId()).getPayitezyOperatorName();
        String circleId = payitezyCircleService.getPayitezyCircle(context.getCircleId()).getCircleName();
        operatorId = operatorId.replaceAll("\\s", "&");
        circleId = circleId.replaceAll("\\s", "&");
        List<PrepaidMobileRechargePlans> prepaidMobileRechargePlans = prepaidMobileRechargePlanResources
                .getPrepaidMobileRechargePlansByNumber(circleId, operatorId, context.getLimit());
        //PrepaidMobileRechargePlansModel model = conversionService.convert(prepaidMobileRechargePlans, PrepaidMobileRechargePlansModel.class);
        for (PrepaidMobileRechargePlans plan : prepaidMobileRechargePlans) {

        }

        List<PrepaidMobileRechargePlansModel> models = (List<PrepaidMobileRechargePlansModel>) conversionService.convert(
                prepaidMobileRechargePlans, TypeDescriptor.forObject(prepaidMobileRechargePlans),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PrepaidMobileRechargePlansModel.class)));

        List<PrepaidMobileRechargePlansModel> planModels = new ArrayList<PrepaidMobileRechargePlansModel>(0);
        for (PrepaidMobileRechargePlans plan : prepaidMobileRechargePlans) {
            PrepaidMobileRechargePlansModel model = new PrepaidMobileRechargePlansModel();
            model.setCircleId(plan.getCircleid());
            model.setId(plan.getId());
            model.setOperatorId(plan.getOperatorid());
            model.setRecharge_amount(plan.getRecharge_amount());
            model.setRecharge_longdesc(plan.getRecharge_longdesc());
            model.setRecharge_shortdesc(plan.getRecharge_shortdesc());
            model.setRecharge_talktime(plan.getRecharge_talktime());
            model.setRecharge_type(plan.getRecharge_type());
            model.setRecharge_validity(plan.getRecharge_validity());
            planModels.add(model);

        }

        return planModels;
    }

}
