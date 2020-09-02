//package org.example.programmingcourses.hibernateutil;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil {
//    private static SessionFactory sessionFactory;
//
//    private HibernateUtil() {
//
//    }
//
//    public static SessionFactory getSessionFactory() {
//        if(sessionFactory == null) {
//            try{
//                Configuration configuration = new Configuration().configure();
//                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//                configuration.buildSessionFactory(builder.build());
//            } catch(Exception e) {
//                System.out.println("Исключение: " + e);
//            }
//        }
//        return sessionFactory;
//    }
//}
