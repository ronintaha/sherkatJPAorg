package edareh.service;

import edareh.dao.PersonnelDao;
import edareh.entity.Personnel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class PersonnelService {
    @Inject
    private PersonnelDao personnelDao;
    @Inject
    private Personnel personnel;

//    public void create(Personnel personnel) {
//        personnelDao.create(personnel);
//    }

//    public void edit(Personnel personnel) {
//        personnelDao.create(personnel);
//    }

//    public void delete(Personnel personnel) {
//        personnelDao.create(personnel);
//    }

//    public List<Personnel> findAll() {
//        return personnelDao.findAll();
//    }

//    public void findById(Personnel personnel) {
//        personelDao.create(personnel);
//    }

    public void creatTablePersonnel() {
        personnelDao.createTablePersonnel();
    }

    public void InsertInfo(Personnel personnel){
        personnelDao.InsertPersonnelInformation(personnel);
    }

    public Personnel getInformation(String national) {
        return personnelDao.getInformationByJpql(national);
    }

    public List<Personnel> findAll(){
       return personnelDao.findAllByJpql();
    }
}
