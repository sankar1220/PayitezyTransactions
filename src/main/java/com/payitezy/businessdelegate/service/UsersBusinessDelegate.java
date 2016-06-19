package com.payitezy.businessdelegate.service;

import com.payitezy.DBSequences;
import com.payitezy.businessdelegate.domain.IKeyBuilder;
import com.payitezy.dao.UsersRepository;
import com.payitezy.domain.*;
import com.payitezy.mail.Mail;
import com.payitezy.model.UserAddressModel;
import com.payitezy.model.UsersModel;
import com.payitezy.service.*;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

/**
 * @author Mohan
 *
 */
@Service
@PropertySource("classpath:mail.properties")
//@ImportResource("classpath:spring-beans.xml")
public class UsersBusinessDelegate implements IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> {

    Logger LOGGER = Logger.getLogger(UsersBusinessDelegate.class);
    @Autowired
    private IAddressService addressService;

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IMailConfigService mailConfigService;
    /*  @Autowired
      private AddressRepository addressRepository;*/
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private IMailService mailService;
    @Autowired
    private IRolesService rolesService;
    @Value("${mail.from}")
    private String mailFrom;
    @Value("${mail.username}")
    private String mailUserName;
    @Value("${url}")
    private String url;

    public boolean checkEmailExists(final String email) {
        return usersRepository.findByEmailId(email) != null;
    }

    public boolean checkMobileExists(final String mobile) {
        return usersRepository.findByMobileNo(mobile) != null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitezy.businessdelegate.service.IBusinessDelegate#create(com.payitezy.businessdelegate.domain.IModel)
     */
    @Override
    public UsersModel create(UsersModel model) {

        Users users = new Users();
        users.setEmailId(model.getEmailId());
        users.setUserName(model.getUserName());
        users.setMobileNo(model.getMobileNo());
        users.setPassword(model.getPassword());
        users.setUserType(model.getUserType());
        users.setStatus(model.getStatus());
        users.setAlternateMobileNo(model.getAlternateMobileNo());
        users.setAge(model.getAge());

        Integer i = usersService.getMaxCode();
        if (i == null) {
            i = 0;
            users.setUserCount(1);
        }
        else {
            users.setUserCount(i + 1);
        }
        Integer co = i + 1;
        String m = DBSequences.USERS.getSequenceName();
        String mc = m.concat(co.toString());
        users.setUserCode(mc);
        users.setCreatedDate(new Date());

        if (model.getPassword() != null && model.getConfirmPassword() != null) {
            if (model.getPassword().equals(model.getConfirmPassword())) {
                model.setEmailStatus("SUCCESS");

                users = usersService.create(users);
                if (users.getId() != null) {
                    Roles r = new Roles();
                    r.setRoleDetails("role created");
                    r.setEnable("true");
                    if (model.getUserType().equals("CUSTOMER")) {
                        r.setRoleName("ROLE_USER");

                    }
                    /*if (model.getUserType().equals("EMPLOYEE")) {
                        r.setRoleName("ROLE_EMPLOYEE");
                    }*/
                    if (model.getUserType().equals("ADMINUSER")) {
                        r.setRoleName("ROLE_ADMIN");
                    }
                    r.setUsers(users);
                    r = rolesService.create(r);
                }
            }
            else {
                model.setEmailStatus("Password and ConfirmPassword Not Match");
            }
        }
        if (users.getId() != null) {
            if (model.getUserAddressModels() != null) {
                Set<UserAddress> userAddress = new HashSet<UserAddress>();
                for (UserAddressModel userAddressModel : model.getUserAddressModels()) {
                    UserAddress uadd = new UserAddress();
                    Address address = new Address();
                    address.setLine1(userAddressModel.getLine1());
                    address.setCity(userAddressModel.getCity());
                    address.setDistrict(userAddressModel.getDistrict());
                    address.setState(userAddressModel.getState());
                    address.setCountry(userAddressModel.getCountry());
                    address.setPincode(userAddressModel.getPincode());
                    address.setType(userAddressModel.getType());
                    address.setArea(userAddressModel.getArea());
                    address = addressService.create(address);
                    uadd.setAddress(address);
                    uadd.setUsers(users);
                    uadd.setStatus(userAddressModel.getStatus());
                    userAddress.add(uadd);
                }
                //  users.setUserAddress(userAddress);
                users = usersService.addUserAddress(users, userAddress);
            }
        }
        if (users.getEmailStatus() != null) {
            if (users.getEmailStatus().equals("Duplicate")) {
                model.setEmailStatus("DUPLICATE");
                model.setUserEmailIdStatus("You are Already Registered. Please Login !");
            }
            if (users.getEmailStatus().equals("Duplicatem")) {
                model.setEmailStatus("DUPLICATE");
                model.setUserEmailIdStatus("Mobile No Already Exists,  Please Login !");
            }
        }
        /* if (users.getId() != null) {
             if (model.getUserImagesModel() != null) {
                 List<UserImages> userImag = new ArrayList<UserImages>();
                 for (UserImagesModel userImagesModel : model.getUserImagesModel()) {
                     UserImages userImages = new UserImages();
                     userImages.setUsers(users);
                     userImages.setImageName(userImagesModel.getImageName());
                     userImages.setImageType(userImagesModel.getImageType());
                     userImages.setImageLocation(userImagesModel.getImageLocation());
                     userImag.add(userImages);
                 }

                 users = usersService.addUserImages(users, userImag);
             }/
         }*/

        if (users.getId() != null) {
            MailConfig mcfgs = mailConfigService.getUserRegistrationMailConfig();
            /* if (mcfgs != null) {*/
            Mail mail = new Mail();
            mail.setMailFrom(mailFrom);
            mail.setMailTo(users.getEmailId());
            mail.setMailSubject("Account Activation Request");
            mailService.sendUserRegistraionMail(mail, users);
            /* }*/
        }
        model = conversionService.convert(users, UsersModel.class);
        model.setId(users.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitezy.businessdelegate.service.IBusinessDelegate#delete(com.payitezy.businessdelegate.domain.IKeyBuilder,
     *      com.payitezy.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UsersContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitezy.businessdelegate.service.IBusinessDelegate#edit(com.payitezy.businessdelegate.domain.IKeyBuilder,
     *      com.payitezy.businessdelegate.domain.IModel)
     */
    @Override
    public UsersModel edit(final IKeyBuilder<String> keyBuilder, final UsersModel usersModel) {
        Users user = usersService.getUsers(keyBuilder.build().toString());

        if (usersModel.getUserType() != null) {
            user.setUserType(usersModel.getUserType());
        }
        else {
            user.setUserType(user.getUserType());
        }

        user.setEmailId(user.getEmailId());
        user.setMobileNo(user.getMobileNo());

        if (usersModel.getConfirmPassword() != null && usersModel.getNewPassword() != null) {
            if (usersModel.getPassword().equals(user.getPassword())) {
                if (usersModel.getConfirmPassword().equals(usersModel.getNewPassword())) {
                    user.setPassword(usersModel.getConfirmPassword());
                }
            }
        }
        else {
            user.setPassword(user.getPassword());
        }
        if (usersModel.getStatus() != null) {
            user.setStatus(usersModel.getStatus());
        }
        else {
            user.setStatus(user.getStatus());
        }

        if (usersModel.getAlternateMobileNo() != null) {
            user.setAlternateMobileNo(usersModel.getAlternateMobileNo());
        }
        else {
            user.setAlternateMobileNo(user.getAlternateMobileNo());
        }

        if (checkEmailExists(user.getEmailId())) {
            user.setEmailStatus("Duplicate");
        }
        if (checkMobileExists(user.getMobileNo())) {
            user.setAuthenticateStatus("DuplicateM");
            user.setEmailStatus("DuplicateM");
        }
        user.setAuthenticateStatus("Success");
        user.setEmailStatus("Success");
        user = usersService.updateUsers(user);

        return usersModel;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitezy.businessdelegate.service.IBusinessDelegate#getByKey(com.payitezy.businessdelegate.domain.IKeyBuilder,
     *      com.payitezy.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UsersModel getByKey(final IKeyBuilder<String> keyBuilder, final UsersContext context) {
        Users users = usersService.getUsers(keyBuilder.build().toString());
        UsersModel userModel = conversionService.convert(users, UsersModel.class);

        return userModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.payitezy.businessdelegate.service.IBusinessDelegate#getCollection(com.payitezy.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UsersModel> getCollection(final UsersContext context) {

        List<Users> users = new ArrayList<Users>();
        if (context.getUserType() != null) {
            users = usersService.getByUserType(context.getUserType());
        }
        if (context.getAll() != null) {
            users = usersService.getAll();
        }
        /*  if (context.getUserType() != null && context.getOnlyUsers() != null) {
              users = usersService.getByUserTypeOnlyUsers(context.getUserType());
          }

          if (context.getUserType() != null && context.getOnlyActiveUsers() != null) {
              users = usersService.getByUserTypeOnlyActiveUsers(context.getUserType());
          }

          if (context.getEmailId() != null && context.getForgotPasswordStatus() != null) {
              users = usersService.getByForgotPasswordEmail(context.getEmailId(), context.getForgotPasswordStatus());
          }

          if (context.getUserId() != null && context.getConfirmPassword() != null && context.getNewPassword() != null
                  && context.getChangePassword() != null && context.getCurrentPassword() != null) {
              Users user = usersService.findByChangePassword(context.getUserId(), context.getConfirmPassword(), context.getNewPassword(),
                      context.getChangePassword(), context.getCurrentPassword());
              users.add(user);
          }

          if (context.getEmailId() != null && context.getPassword() != null) {
              Users usr = usersService.findByEmailIdAndPassword(context.getEmailId(), context.getPassword());
              if (usr == null || usr.equals(null)) {
                  //throw new ResourceNotFoundException("EmailId " + context.getEmailId() + " not found");
                  Users u = new Users();
                  u.setAuthenticateStatus("Please Enter Valid UserName!");
                  users.add(u);
              }
              else {

                  if (usr.getId() != null) {
                      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                      String hashedPassword = passwordEncoder.encode(context.getPassword());
                      if ((usr.getEmailId().equals(context.getEmailId().toLowerCase()) && (usr.getPassword()
                              .equals(hashedPasswordcontext.getPassword())))) {
                          usr.setAuthenticateStatus("Success");
                          if (usr.getStatus() != null) {
                              if (usr.getStatus().equals("ACTIVE")) {
                                  users.add(usr);
                              }
                              else {
                                  Users u = new Users();
                                  u.setAuthenticateStatus("Sorry User Not Activated,Please Check Your Mail!");
                                  // user.setStatus("User Not Activated");
                                  u.setEmailId(usr.getEmailId());
                                  users.add(u);
                              }
                          }
                          else {
                              Users u = new Users();
                              u.setAuthenticateStatus("Sorry User Not Activated,Please Check Your Mail!");
                              // user.setStatus("User Not Activated");
                              u.setEmailId(usr.getEmailId());
                              users.add(u);
                          }
                      }
                      else {
                          Users u = new Users();
                          u.setAuthenticateStatus("Please Enter Valid Password!");
                          u.setEmailId(usr.getEmailId());
                          users.add(u);
                      }
                  }
                  else {
                      Users u = new Users();
                      u.setAuthenticateStatus("Please Enter Valid EmailId!");
                      users.add(u);
                  }
              }

          }*/

        /* if (context.getMobileNo() != null && context.getPassword() != null) {
             Users user = usersService.findByMobileNoAndPassword(context.getMobileNo(), context.getPassword());
             if (user == null || user.equals(null)) {
                 Users u = new Users();
                 u.setAuthenticateStatus("Please Enter Valid MobileNo!");
                 users.add(u);
             }
             if (user.getId() != null) {
                 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                 String hashedPassword = passwordEncoder.encode(context.getPassword());
                 if ((user.getEmailId().equals(context.getEmailId().toLowerCase()) && (user.getPassword()
                         .equals(hashedPasswordcontext.getPassword())))) {
                     user.setAuthenticateStatus("Success");
                     if (user.getStatus() != null) {
                         if (user.getStatus().equals("ACTIVE")) {
                             users.add(user);
                         }
                         else {
                             Users u = new Users();
                             u.setAuthenticateStatus("Sorry User Not Activated,Please Check Your Mail!");
                             // user.setStatus("User Not Activated");
                             u.setEmailId(user.getEmailId());
                             users.add(u);
                         }
                     }
                     else {
                         Users u = new Users();
                         u.setAuthenticateStatus("Sorry User Not Activated,Please Check Your Mail!");
                         // user.setStatus("User Not Activated");
                         u.setEmailId(user.getEmailId());
                         users.add(u);
                     }
                 }
                 else {
                     Users u = new Users();
                     u.setAuthenticateStatus("Please Enter Valid Password!");
                     u.setEmailId(user.getEmailId());
                     users.add(u);
                 }
             }
             else {
                 Users u = new Users();
                 u.setAuthenticateStatus("Please Enter Valid PhoneNo!");
                 users.add(u);
             }
         }*/
        // }
        List<UsersModel> usersModels = (List<UsersModel>) conversionService.convert(users, TypeDescriptor.forObject(users),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UsersModel.class)));
        return usersModels;

    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        conversionService = conversionService;
    }

}
