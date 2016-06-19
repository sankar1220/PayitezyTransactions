package com.payitezy.service;

import com.payitezy.domain.UserAddress;
import com.payitezy.domain.Users;

import java.util.List;
import java.util.Set;

public interface IUsersService {

    Users addUserAddress(Users users, Set<UserAddress> userAddress);

    /**
     * @param branchId
     * @return
     */
    //List<UserDetails> findByBranch(String branchId);

    Users create(Users users);

    /**
     * @param city
     * @return
     */
    //List<UserDetails> findBycity(String city);

    void deleteUsers(String usersId);

    /**
     * @param userId
     * @param confirmPassword
     * @param newPassword
     * @param changePassword
     * @param currentPassword
     * @return
     */
    Users findByChangePassword(String userId, String confirmPassword, String newPassword, String changePassword, String currentPassword);

    Users findByChangePassword(String userId, String password, String confirmPassword, String changePassword, String string,
            String currentPassword);

    Users findByEmailIdAndForgotPassword(String emailId, String forgotPasswordStatus);

    Users findByEmailIdAndPassword(String emailId, String password);

    /* Users findByUser(String id);*/

    Users findByMobileNoAndPassword(String mobileNo, String password);

    Users findByUser(String id);

    List<Users> getAll();

    /**
     * @param userRole
     * @return
     */
    List<Users> getAllUsers(String userRole);

    List<Users> getByForgotPasswordEmail(String emailId, String forgotPasswordStatus);

    List<Users> getByUserType(String userType);

    List<Users> getByUserTypeOnlyActiveUsers(String userType);

    List<Users> getByUserTypeOnlyUsers(String userType);

    Integer getInactiveCust(String sts);

    Integer getMaxCode();

    Integer getSurityUser(String userTy);

    Integer getUserCustActive(String ust);

    Integer getUserCustomers();

    /**
     * @param string
     * @return
     */
    Users getUsers(String usersId);

    Users updateUsers(Users users);

}
