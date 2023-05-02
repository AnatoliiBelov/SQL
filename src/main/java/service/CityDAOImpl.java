package service;

import config.HibernateSessionFactoryUtil;
import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void addCity(City city){
        try (Session session= HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }
    @Override
    public City getCityForId(int id) {
        try (Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> getAllCity() {
        try (Session session=HibernateSessionFactoryUtil
                .getSessionFactory().openSession()){
            return (List<City>)session.createQuery(String.valueOf(City.class)).list();
        }
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();

        }

    }
    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();

        }
    }
}