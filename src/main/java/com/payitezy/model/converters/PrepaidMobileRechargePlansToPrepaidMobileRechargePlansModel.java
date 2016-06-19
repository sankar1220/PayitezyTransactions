package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.PrepaidMobileRechargePlans;
import com.payitezy.model.PrepaidMobileRechargePlansModel;

@Component("prepaidMobileRechargePlansToPrepaidMobileRechargePlansModel")
public class PrepaidMobileRechargePlansToPrepaidMobileRechargePlansModel implements Converter<PrepaidMobileRechargePlans, PrepaidMobileRechargePlansModel> {

	@Autowired
	private ObjectFactory<PrepaidMobileRechargePlansModel> prepaidMobileRechargePlansModelFactory;
	@Override
	public PrepaidMobileRechargePlansModel convert(
			PrepaidMobileRechargePlans source) {
		// TODO Auto-generated method stub
		PrepaidMobileRechargePlansModel prepaidMobileRechargePlansModel=prepaidMobileRechargePlansModelFactory.getObject();
		 BeanUtils.copyProperties(source, prepaidMobileRechargePlansModel);
		 prepaidMobileRechargePlansModel.setCircleId(source.getCircleid());
		 prepaidMobileRechargePlansModel.setOperatorId(source.getOperatorid());
		return prepaidMobileRechargePlansModel;
	}
	@Autowired
public void setPrepaidMobileRechargePlansModel(final ObjectFactory<PrepaidMobileRechargePlansModel> prepaidMobileRechargePlansFactory){
	this.prepaidMobileRechargePlansModelFactory=prepaidMobileRechargePlansFactory;
}
	
}
