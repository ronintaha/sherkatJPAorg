package edareh.service;

import edareh.dao.PersonnelDao;
import edareh.dao.VacationDao;
import edareh.entity.Personnel;
import edareh.entity.Vacation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class VacationService {
    @Inject
    VacationDao vacationDao;
    @Inject
    PersonnelService personnelService;


    public void creatTableVacation(){

        vacationDao.creatTableVacation();

    }
    public void confirmData(Vacation vacation){
        vacationDao.confirmData(vacation);
    }
    public Vacation getVacationDao(String nationalCode){
       return vacationDao.getVacationDaoByJpa(nationalCode);
    }
    public void insertVacation(Vacation vacation){
        vacationDao.insertVacationByJpa(vacation);
    }
    public Vacation getInformationForVacation(String nationalCode){

       Personnel personnel = personnelService.getInformation(nationalCode);
       Vacation vacation = new Vacation();
       vacation.setnCode(personnel.getNationalCode());
       vacation.setlName(personnel.getLasteName());
        return vacation;
//       return vacationDao.getInformationForVacation(nationalCode);
    }
}
