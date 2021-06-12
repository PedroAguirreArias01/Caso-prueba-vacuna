/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.List;
import models.Enfermedad;
import models.Vacuna;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
public class EnfermedadDAO {
    
    public void crearEnfermedad(Enfermedad enfermedad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(enfermedad);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void actualizarEnfermedad(Enfermedad enfermedad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(enfermedad);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void eliminarEnfermedad(Enfermedad enfermedad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(enfermedad);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Enfermedad consultarEnfermedadPorID(Integer idEnfermedad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Enfermedad enfermedad = session.get(Enfermedad.class, idEnfermedad);
        session.close();
        return enfermedad;
    }

    public List<Enfermedad> consultarTodasEnfermedades() {
        Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
        List<Enfermedad> listEnfermedades = session.createQuery("from Enfermedad").list();
        session.close();
        return listEnfermedades;
    }
}
