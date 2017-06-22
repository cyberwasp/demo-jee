package ru.cwasp.demo.jee;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EjbDemoClient {

    public static void main(String[] args) throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://192.168.1.6:8080");
        //jndiProperties.put(Context.SECURITY_PRINCIPAL, "wasp11");
        //jndiProperties.put(Context.SECURITY_CREDENTIALS, "1");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        Context ctx = new InitialContext(jndiProperties);
        EjbDemo ejbDemo = (EjbDemo) ctx.lookup("jee-demo-ear-1.0-SNAPSHOT/jee-demo-ejb-1.0-SNAPSHOT/EjbDemoImpl!ru.cwasp.demo.jee.EjbDemo");
        ejbDemo.test();
    }
}
