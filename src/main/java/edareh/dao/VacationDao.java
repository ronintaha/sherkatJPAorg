package edareh.dao;

//import edareh.entity.ManagerData;

import edareh.entity.Personnel;
import edareh.entity.Vacation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import javax.enterprise.context.RequestScoped;
import java.sql.*;

@RequestScoped
public class VacationDao {

    public  void creatTableVacation() {
        DBHandler dbHandler = new DBHandler();
        String vSQL = "CREATE TABLE IF NOT EXISTS VACATION" + "(ID INTEGER PRIMARY KEY AUTO_INCREMENT," + "LastN VARCHAR (255)," + "VacationDay VARCHAR(255)," + "Confirm VARCHAR(255)," + "NationalCode VARCHAR (255))";
        try (Connection connection = dbHandler.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(vSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpa");
    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    public void insertVacationByJpa(Vacation vacation){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vacation);
            em.getTransaction().commit();
        }catch (Exception e){
            return;
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Vacation getVacationDaoByJpa(String nCode){
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query query = em.createNamedQuery("getInfoVacationQuery");
            query.setParameter("nCode",nCode);
            Vacation vacation = (Vacation) query.getSingleResult();
            return vacation;
        }catch (Exception e){
            return new Vacation();
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void confirmData(Vacation vacation) {
        DBHandler dbHandler = new DBHandler();

        String cSQL = "UPDATE VACATION SET Confirm = ? WHERE NATIONALCODE = ?";
        try (Connection connection = dbHandler.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(cSQL);
            preparedStatement.setString(1, vacation.getConfirm());
            preparedStatement.setString(2, vacation.getnCode());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
