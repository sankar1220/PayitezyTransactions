/**
 *
 */
package com.payitezy.dao;

import com.payitezy.domain.Users;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface UsersRepository extends PagingAndSortingRepository<Users, Serializable> {

    @Query("select u from Users u where u.userType='CUSTOMER'")
    List<Users> findAllUsers();

    @Query("select u from Users u where u.emailId=?1")
    Users findByEmailId(String emailId);

    /**
     * @param e
     * @return
     */
    @Query("select u from Users u where u.emailId=?1")
    Users findByEmailIdAndPassword(String e);

    /**
     * @param username
     * @return
     */
    @Query("select distinct u from Users u where u.emailId=?1 and u.status='ACTIVE'")
    Users findByEmailIdStatus(String username);

    @Query("select u from Users u where u.mobileNo=?1")
    Users findByMobileNo(String mobileNo);

    @Query("select distinct u from Users u where u.id=?1")
    Users findByUserId(String usersId);

    @Query("select Count(*) from Users u where u.userType=?1")
    Integer getActiveCust(String ust);

    @Query("select Count(*) from Users u where u.userType='Customer'")
    Integer getActiveCustomers();

    @Query("select u from Users u where u.userType=?1 and u.status=?2")
    List<Users> getByActiveUserType(String userType, String status);

    @Query("select u from Users u where u.userType=?1")
    List<Users> getByUserType(String userType);

    @Query("select Count(*) from Users u where u.status=?1")
    Integer getInactiveCust(String sts);

    @Query("select MAX(userCount) from Users u")
    Integer getMaxCode();

    @Query("select Count(*) from Users u where u.userType=?1")
    Integer getSurityUsers(String userTy);

}
