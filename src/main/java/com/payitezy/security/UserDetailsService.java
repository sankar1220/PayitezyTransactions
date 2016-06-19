/**
 *
 */
package com.payitezy.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author varma
 *
 */
public interface UserDetailsService {
    UserDetails loadUserByUsernameAndPassword(String username, String password) throws UsernameNotFoundException;
}
