
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
@Component("prepaidMobileRechargeModelToPrepaidMobileRecharge")
public class PrepaidMobileRechargeModelToPrepaidMobileRecharge implements
		Converter<PrepaidMobileRechargeModel, PrepaidMobileRecharge> {
	@Autowired
	private ObjectFactory<PrepaidMobileRecharge> prepaidMobileRechargeFactory;
	@Autowired
	private ConversionService conversionService;

	@Override
	public PrepaidMobileRecharge convert(final PrepaidMobileRechargeModel source) {
		PrepaidMobileRecharge prepaidMobileRecharge = prepaidMobileRechargeFactory.getObject();
		BeanUtils.copyProperties(source, prepaidMobileRecharge);

		return prepaidMobileRecharge;
	}

	@Autowired
	public void setPrepaidMobileRechargeFactory(final ObjectFactory<PrepaidMobileRecharge> prepaidMobileRechargeFactory) {
		this.prepaidMobileRechargeFactory = prepaidMobileRechargeFactory;
	}

}
