package com.project.DB;

import java.util.Properties;

import com.project.models.Pays;
import com.project.models.Worker;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
public class HibernateUtil {
 
    private static SessionFactory sessionFactory;
 
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
 
                Properties settings = new Properties();
 
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/payments?useSSL=false&serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
 
                configuration.setProperties(settings);
 
                configuration.addAnnotatedClass(Worker.class);
                configuration.addAnnotatedClass(Pays.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(settings);
                sessionFactory = configuration.buildSessionFactory(builder.build());
 
 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
