/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.List;
import models.Dosis;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
public class DosisDAO {

    public void crearDosis(Dosis dosis) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(dosis);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void actualizarDosis(Dosis dosis) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(dosis);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void eliminarDosis(Dosis dosis) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(dosis);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Dosis consultarDosisPorID(Integer idDosis) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Dosis Dosis = session.get(Dosis.class, idDosis);
        session.close();
        return Dosis;
    }

    public List<Dosis> consultarTodasDosises() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Dosis> listDosis = session.createQuery("from Dosis").list();
        session.close();
        return listDosis;
    }
}
