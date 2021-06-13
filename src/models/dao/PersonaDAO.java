/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.io.Serializable;
import java.util.List;
import models.Persona;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author Pedro
 */
public class PersonaDAO implements Serializable {

    public void crearPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(persona);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void actualizarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(persona);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void eliminarPersona(Persona persona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(persona.getHistorial());
            session.delete(persona);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Persona consultarPersonaPorID(Integer idPersona) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Persona persona = session.get(Persona.class, idPersona);
        session.close();
        return persona;
    }

    public List<Persona> consultarTodasPersonas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Persona> listPersona = session.createQuery("from Persona").list();
        session.close();
        return listPersona;
    }
}
