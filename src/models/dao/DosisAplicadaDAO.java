/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.List;
import models.DosisAplicada;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
public class DosisAplicadaDAO {

    public void crearDosisAplicada(DosisAplicada dosisAplicada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(dosisAplicada);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void actualizarDosisAplicada(DosisAplicada dosisAplicada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(dosisAplicada);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void eliminarDosisAplicada(DosisAplicada dosisAplicada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(dosisAplicada);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public DosisAplicada consultarDosisAplicadaPorID(Integer idDosisAplicada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        DosisAplicada DosisAplicada = session.get(DosisAplicada.class, idDosisAplicada);
        session.close();
        return DosisAplicada;
    }

    public List<DosisAplicada> consultarTodasDosisAplicadaes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<DosisAplicada> listDosisAplicadaes = session.createQuery("from DosisAplicada").list();
        session.close();
        return listDosisAplicadaes;
    }
}
