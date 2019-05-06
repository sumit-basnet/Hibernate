/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.app;

import com.itn.model.Student;
import java.util.List;
//import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sumit
 */
public class HbmApp {
    public static void main(String[] args) {
        SessionFactory sf= new Configuration().configure("com/itn/util/hibernate.cfg.xml").buildSessionFactory();
        //add student information
        //yesma sesson vaneko chai database ma acid propoerty handle gaarne  ho it is deifferent from web app session
        
        //add Student information
        Student s = new Student();
        s.setName("shyamya");
        s.setAddress("bahri");
        s.setPhone(98333336L);
        s.setGender("male");
        s.setSemester("8th semester");
        
        // save this object using orm
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
        session.close();
        
       // fetch this object using orm
         session = sf.openSession();
         tx = session.beginTransaction();
         List<Student> sl = session.createCriteria(Student.class).list();
        tx.commit();
        session.close();
        for(Student sm:sl){
            System.out.println(sm.toString());
        }
        
        //fetch single object
         session = sf.openSession();
         session.beginTransaction();
//         Student sm = (Student) session.get(Student.class, 1);
        List <Student> sm = session.createCriteria(Student.class).add(Restrictions.eq("name", "shyamya")).list();
        
         session.getTransaction().commit();
         session.close();
         for(Student o:sm){
         System.out.println(sm.toString());
         }
         //update record with id 5 
         s.setId(4);
         s.setName("Hari");
         s.setAddress("kirtipur");
         s.setPhone(234546678);
         s.setGender("male");
         s.setSemester("3rd semester");
         
         session= sf.openSession();
         session.beginTransaction();
         session.update(s);
         session.getTransaction().commit();
         session.close();
         
         //delete object using primary key
         s.setId(3);
         session = sf.openSession();
         session.beginTransaction();
         session.delete(s);
         session.getTransaction().commit();
         session.close();
         
         //fetch object using orm
         session = sf.openSession();
         tx= session.beginTransaction();
         List<Student> s1 = session.createCriteria(Student.class).list();
         tx.commit();
         session.close();
         for(Student o:s1){
             System.out.println(o.toString());
         }
         
    }
 
}
