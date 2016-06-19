
/**
 *
 */
package com.payitezy.model.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.apiobjects.PrepaidMobileRecharge;

import com.payitezy.model.PrepaidMobileRechargeModel;

/**
 * Class to convert address model domain to address
 *
 * @author naveen
 *
 */
@Component("prepaidMobileRechargeToPrepaidMobileRechargeModel")
public class PrepaidMobileRechargeToPrepaidMobileRechargeModel implements
		Converter<PrepaidMobileRecharge, PrepaidMobileRechargeModel> {
	@Autowired
	private ObjectFactory<PrepaidMobileRechargeModel> prepaidMobileRechargeModelFactory;
	@Autowired
	private ConversionService conversionService;

	@Override
	public PrepaidMobileRechargeModel convert(final PrepaidMobileRecharge source) {
		PrepaidMobileRechargeModel prepaidMobileRechargeModel = prepaidMobileRechargeModelFactory.getObject();
		BeanUtils.copyProperties(source, prepaidMobileRechargeModel);

		return prepaidMobileRechargeModel;
	}

	@Autowired
	public void setPrepaidMobileRechargeModelFactory(final ObjectFactory<PrepaidMobileRechargeModel> prepaidMobileRechargeFactory) {
		this.prepaidMobileRechargeModelFactory = prepaidMobileRechargeModelFactory;
	}

}
