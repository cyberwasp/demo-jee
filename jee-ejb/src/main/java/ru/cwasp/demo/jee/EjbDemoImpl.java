package ru.cwasp.demo.jee;


import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.Principal;
import java.util.logging.Logger;

@Stateless
@Remote(EjbDemo.class)
public class EjbDemoImpl implements EjbDemo {

    private static final Logger LOG = Logger.getLogger(EjbDemo.class.getName());

    @Inject
    Principal principal;

    @RolesAllowed("user")
    public void test() {
        LOG.severe("Method test called by " + principal.getName());
    }
}
