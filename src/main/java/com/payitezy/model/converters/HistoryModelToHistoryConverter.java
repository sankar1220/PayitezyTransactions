package com.payitezy.model.converters;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.payitezy.domain.Address;
import com.payitezy.domain.ClickTransaction;
import com.payitezy.domain.History;
import com.payitezy.domain.UserAddress;
import com.payitezy.model.AddressModel;
import com.payitezy.model.HistoryModel;
import com.payitezy.util.CollectionTypeDescriptor;


@Component("historyModelToHistoryConverter")
public class HistoryModelToHistoryConverter implements Converter<HistoryModel, History> {
    @Autowired
    private ObjectFactory<History> historyFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public History convert(final HistoryModel source) {
    	History history= historyFactory.getObject();
        BeanUtils.copyProperties(source, history);

        if (CollectionUtils.isNotEmpty(source.getClickTransactionModels())) {
            List<ClickTransaction> converted = (List<ClickTransaction>) conversionService.convert(source.getClickTransactionModels(),
                    TypeDescriptor.forObject(source.getClickTransactionModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ClickTransaction.class));
            history.getClickTransactions().addAll(converted);
        }

        return history;
    }

    @Autowired
    public void setHistoryFactory(final ObjectFactory<History> historyFactory) {
        this.historyFactory = historyFactory;
    }

}
