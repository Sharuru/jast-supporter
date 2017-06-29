package self.srr.jast.common.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import self.srr.jast.entity.TblTracerUser;
import self.srr.jast.repository.TblTracerUserRepository;

/**
 * Created by Sharuru on 2017/06/29.
 */
@Service
@Slf4j
public class TracerUserDetailService implements UserDetailsService {

    @Autowired
    private TblTracerUserRepository tblTracerUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TblTracerUser user = tblTracerUserRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        log.info("User '" + user.getUsername() + "' queried : " + user.toString());
        return new TracerUserPrincipal(user);
    }
}