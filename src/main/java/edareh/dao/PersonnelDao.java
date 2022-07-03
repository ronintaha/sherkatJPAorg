package edareh.dao;

import edareh.entity.Personnel;
import edareh.entity.Vacation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import javax.enterprise.context.RequestScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class PersonnelDao {

    public void createTablePersonnel() {
        DBHandler dbHandler = new DBHandler();
        String cSQL = "CREATE TABLE IF NOT EXISTS PERSONEL1" + " (ID INTEGER PRIMARY KEY AUTO_INCREMENT, " + " FIRSTNAME VARCHAR(255)," + " LASTNAME VARCHAR(255)," + " AGE VARCHAR(255)," + " NATIONALCODE VARCHAR(255))";
        try (Connection connection = dbHandler.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(cSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    JPA FORM

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpa");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Personnel InsertPersonnelInformation(Personnel personnel) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(personnel);
            em.getTransaction().commit();
        } catch (Exception e) {
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return personnel;
    }


    public Personnel getInformationByJpql(String searchNationalCode) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query query = em.createNamedQuery("findByNationalCode");
            query.setParameter("nationalCode", searchNationalCode);
            Personnel personnel = (Personnel) query.getSingleResult();
            return personnel;

        } catch (Exception exception) {
            return new Personnel("no one found", "no one found", "no one found", "no one found");
        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    public List<Personnel> findAllByJpql() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query query = em.createNamedQuery("showAll");
            List<Personnel> result = query.getResultList();
            return result;

        } catch (Exception exception) {
            throw new RuntimeException();
        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    //    criteria
    public List<Personnel> criteria() {
        EntityManager em = null;
        try {
            em = getEntityManager();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Personnel> criteriaQuery = builder.createQuery(Personnel.class);

            Root<Personnel> p = criteriaQuery.from(Personnel.class);

            criteriaQuery.select(p).where(builder.equal(p.get("name"), "mohamad"));

            List<Personnel> resultList = em.createQuery(criteriaQuery).getResultList();

            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}