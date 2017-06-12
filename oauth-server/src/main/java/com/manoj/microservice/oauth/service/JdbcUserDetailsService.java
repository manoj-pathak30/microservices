package com.manoj.microservice.oauth.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by synerzip on 22/5/17.
 */
@Configuration
public class JdbcUserDetailsService implements UserDetailsService {

    private List<UserDetailsService> uds = new LinkedList<>();

    public JdbcUserDetailsService() {
    }

    /**
     * Add the default user detail service or any other user detail service so
     * that we can validate the user.
     *
     * @param srv
     */
    public void addService(UserDetailsService srv) {
        uds.add(srv);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (uds != null) {
            for (UserDetailsService srv : uds) {
                try {
                    final UserDetails details = srv.loadUserByUsername(userName);
                    if (details != null) {
                        return details;
                    }
                } catch (UsernameNotFoundException ex) {
                    assert ex != null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw ex;
                }
            }
        }

        throw new UsernameNotFoundException("Unknown user");
    }
}
