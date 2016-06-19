package com.payitezy.service;

import com.payitezy.domain.Users;
import com.payitezy.mail.Mail;

public interface IMailService {

    /**
     * @param mail
     */

    void sendUserActivationMail(Mail mail, Users users);

    /**
     * @param mail
     * @param users
     */

    void sendUserRegistraionMail(Mail mail, Users users);

    //Mail getMail(String string);

    /*  void getByChitMembers(String chitId, String allMembers);

    void getByChitPaymentForMembers(String chitId, String paymentMonth);

    void getByFirmBranch(String firmBranchId);

    void getByFirmUsers(String firmId, String chitPlanId);

    void getByMailSender(String chitId);

    void getByPaymentForMembers(String paymentMonth);*/

}
