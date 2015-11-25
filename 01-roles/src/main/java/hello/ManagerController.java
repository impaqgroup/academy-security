package hello;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Collections;

@Controller
public class ManagerController {

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()") //TODO check manager role
    public String manager() {
        System.out.println(String.format("Logged user has following roles" + getRoles(getUserDetails())));
        return "manager";
    }

    private Collection<? extends GrantedAuthority> getRoles(UserDetails userDetails) {
        return userDetails != null ? userDetails.getAuthorities() : Collections.emptyList();
    }

    private UserDetails getUserDetails() {
        return null; //TODO finish
    }
}