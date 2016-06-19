package com.payitezy.businessdelegate.service;
/*package com.chitfund.businessdelegate.service;

import com.chitfund.businessdelegate.domain.IKeyBuilder;
import com.chitfund.domain.OccupationType;
import com.chitfund.model.MailModel;
import com.chitfund.service.IFirmBranchDocumentsService;
import com.chitfund.service.IMailService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

@Service
public class MailBusinessDelegate implements IBusinessDelegate<MailModel, MailContext, IKeyBuilder<String>, String> {
    Logger LOGGER = Logger.getLogger(MailBusinessDelegate.class);
    @Autowired
    private IMailService mailService;
    @Autowired
    private IFirmBranchDocumentsService firmBranchDocumentsService;
    @Autowired
    private ConversionService conversionService;

 *//**
 * {@inheritDoc}
 *
 * @see com.chitfund.businessdelegate.service.IBusinessDelegate#create(com.chitfund.businessdelegate.domain.IModel)
 */
/*
@Override
public MailModel create(final MailModel model) {

   OccupationType occupationType = new OccupationType();
   occupationType.setId(model.getId());
   occupationType.setOccupationType(model.getOccupationType());
   FirmBranch firmBranch = new FirmBranch();
   firmBranch.setId(model.getFirmBranchId());
   occupationType.setFirmBranch(firmBranch);
   occupationType.setDocumentFor(model.getDocumentFor());

   if (model.getId() != null) {

       List<FirmBranchDocuments> firmBranchDocumentses = new ArrayList<FirmBranchDocuments>();
       if (model.getFirmBranchDocumentsModels() != null) {

           for (FirmBranchDocumentsModel fbdM : model.getFirmBranchDocumentsModels()) {
               FirmBranchDocuments firmBranchDocuments = new FirmBranchDocuments();
               occupationType.setId(occupationType.getId());
               firmBranchDocuments.setDocumentName(fbdM.getDocumentName());
               firmBranchDocuments.setOccupationType(occupationType);
               firmBranchDocumentses.add(firmBranchDocuments);

               firmBranchDocuments = firmBranchDocumentsService.create(firmBranchDocuments);
               fbdM.setId(firmBranchDocuments.getId());
           }
       }
   }
   else {
       occupationType = occupationTypeService.create(occupationType);
   }
   model.setId(occupationType.getId());
 return model;
}

*//**
 * {@inheritDoc}
 *
 * @see com.chitfund.businessdelegate.service.IBusinessDelegate#delete(com.chitfund.businessdelegate.domain.IKeyBuilder,
 *      com.chitfund.businessdelegate.service.IBusinessDelegateContext)
 */
/*
@Override
public void delete(final IKeyBuilder<String> keyBuilder, final MailContext context) {
 // TODO Auto-generated method stub

}

*//**
 * {@inheritDoc}
 *
 * @see com.chitfund.businessdelegate.service.IBusinessDelegate#edit(com.chitfund.businessdelegate.domain.IKeyBuilder,
 *      com.chitfund.businessdelegate.domain.IModel)
 */
/*
@Override
public MailModel edit(final IKeyBuilder<String> keyBuilder, final MailModel model) {
  OccupationType occupationType = occupationTypeService.getOccupationType(keyBuilder.build().toString());
  occupationType.setOccupationType(model.getOccupationType());

  FirmBranch firmBranch = new FirmBranch();
  firmBranch.setId(model.getFirmBranchId());
  occupationType.setFirmBranch(firmBranch);
  occupationType.setDocumentFor(model.getDocumentFor());
  occupationType = occupationTypeService.create(occupationType);
 return model;
}

*//**
 * {@inheritDoc}
 *
 * @see com.chitfund.businessdelegate.service.IBusinessDelegate#getByKey(com.chitfund.businessdelegate.domain.IKeyBuilder,
 *      com.chitfund.businessdelegate.service.IBusinessDelegateContext)
 */
/*
@Override
public MailModel getByKey(final IKeyBuilder<String> keyBuilder, final MailContext context) {
   Mail chit = mailService.getMail(keyBuilder.build().toString());
 MailModel chitModel = conversionService.convert(chit, MailModel.class);
  
 return null;
}

*//**
 * {@inheritDoc}
 *
 * @see com.chitfund.businessdelegate.service.IBusinessDelegate#getCollection(com.chitfund.businessdelegate.service.IBusinessDelegateContext)
 */
/*
@Override
public Collection<MailModel> getCollection(final MailContext context) {
 List<OccupationType> cModels = new ArrayList<OccupationType>();

 if (context.getFirmId() != null && context.getChitPlanId() != null && context.getAllUsers() != null) {
     mailService.getByFirmUsers(context.getFirmId(), context.getChitPlanId());
 }
 if (context.getChitId() != null && context.getAllMembers() != null) {
     mailService.getByChitMembers(context.getChitId(), context.getAllMembers());
 }
 if (context.getChitId() != null && context.getPaymentMonth() != null) {
     mailService.getByChitPaymentForMembers(context.getChitId(), context.getPaymentMonth());
 }
 if (context.getPaymentMonth() != null) {
     mailService.getByPaymentForMembers(context.getPaymentMonth());
 }

 if (context.getChitId() != null) {
     mailService.getByMailSender(context.getChitId());
 }
  if (context.getFirmBranchId() != null && context.getDocumentFor()!=null) {
      cModels = occupationTypeService.getByFirmBranchDocumentFor(context.getFirmBranchId(),context.getDocumentFor());
  }
 List<MailModel> occupationTypeModels = (List<MailModel>) conversionService.convert(cModels, TypeDescriptor.forObject(cModels),
         TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(MailModel.class)));
 return occupationTypeModels;
}

}
      */