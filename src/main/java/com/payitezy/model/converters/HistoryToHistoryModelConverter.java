package com.payitezy.model.converters;

import com.payitezy.domain.History;
import com.payitezy.model.ClickTransactionModel;
import com.payitezy.model.HistoryModel;
import com.payitezy.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("historyToHistoryModelConverter")
public class HistoryToHistoryModelConverter implements Converter<History, HistoryModel> {
    @Autowired
    private ObjectFactory<HistoryModel> historyModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public HistoryModel convert(final History source) {
        HistoryModel historyModel = historyModelFactory.getObject();
        BeanUtils.copyProperties(source, historyModel);

        if (CollectionUtils.isNotEmpty(source.getClickTransactions())) {
            List<ClickTransactionModel> converted = (List<ClickTransactionModel>) conversionService.convert(source.getClickTransactions(),
                    TypeDescriptor.forObject(source.getClickTransactions()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ClickTransactionModel.class));
            historyModel.getClickTransactionModels().addAll(converted);
        }

        return historyModel;
    }

    @Autowired
    public void setHistoryModelFactory(final ObjectFactory<HistoryModel> historyModelFactory) {
        this.historyModelFactory = historyModelFactory;
    }

}
