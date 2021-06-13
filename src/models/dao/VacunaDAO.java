/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.List;
import models.Vacuna;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
public class VacunaDAO {
    
    public void crearVacuna(Vacuna vacuna) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(vacuna);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void actualizarVacuna(Vacuna vacuna) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(vacuna);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void eliminarVacuna(Vacuna vacuna) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(vacuna);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Vacuna consultarVacunaPorID(Integer idVacuna) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Vacuna vacuna = session.get(Vacuna.class, idVacuna);
        session.close();
        return vacuna;
    }

    public List<Vacuna> consultarTodasVacunas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Vacuna> listVacunas = session.createQuery("from Vacuna").list();
        session.close();
        return listVacunas;
    }

}
