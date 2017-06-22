package ru.cwasp.demo.jee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EjbDemoClient2 {

    public static void main(String[] args) throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context ctx = new InitialContext(jndiProperties);
        EjbDemo ejbDemo = (EjbDemo) ctx.lookup("ejb:jee-demo-ear-1.0-SNAPSHOT/jee-demo-ejb-1.0-SNAPSHOT//EjbDemoImpl!ru.cwasp.demo.jee.EjbDemo");
        ejbDemo.test();
    }

 }
