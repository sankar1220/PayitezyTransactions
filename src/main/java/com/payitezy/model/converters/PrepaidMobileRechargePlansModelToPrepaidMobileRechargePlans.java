package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.PrepaidMobileRechargePlans;
import com.payitezy.model.PrepaidMobileRechargePlansModel;


@Component("prepaidMobileRechargePlansModelToPrepaidMobileRechargePlans")
public class PrepaidMobileRechargePlansModelToPrepaidMobileRechargePlans implements Converter<PrepaidMobileRechargePlansModel, PrepaidMobileRechargePlans>{

	@Autowired
	private ObjectFactory<PrepaidMobileRechargePlans> prepaidMobileRechargePlansFactory;
	@Override
	public PrepaidMobileRechargePlans convert(final
			PrepaidMobileRechargePlansModel source) {
		// TODO Auto-generated method stub
		PrepaidMobileRechargePlans prepaidMobileRechargePlans = prepaidMobileRechargePlansFactory.getObject();
		BeanUtils.copyProperties(source, prepaidMobileRechargePlans);
		
		return prepaidMobileRechargePlans;
	}

	@Autowired
	public void setPrepaidMobileRechargePlansFactory(final ObjectFactory<PrepaidMobileRechargePlans> prepaidMobileRechargePlansFactory){
		this.prepaidMobileRechargePlansFactory=prepaidMobileRechargePlansFactory;
	}
	
	
	
}
