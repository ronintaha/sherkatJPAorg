package edareh.managedBean;

import edareh.entity.Personnel;
import edareh.entity.Vacation;
import edareh.service.PersonnelService;
import edareh.service.VacationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class VacationReqManageBean {
    @Inject
    PersonnelService personnelService;
    @Inject
    VacationService vacationService;


    private Personnel personnel;
    private Vacation vacation;

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    @PostConstruct
    public void init(){
        personnel = new Personnel();
        vacation = new Vacation();
    }

    private String  massage;

    private String nationalCode;

    private int dayLeave;

    public int getDayLeave() {
        return dayLeave;
    }

    public void setDayLeave(int dayLeave) {
        this.dayLeave = dayLeave;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    private String  massage1;

    public String getMassage1() {
        return massage1;
    }

    public void setMassage1(String massage1) {
        this.massage1 = massage1;
    }

    public void getInformationForVacation(){
       vacation = vacationService.getInformationForVacation(nationalCode);
    }
    public void doVacation(){
         massage =  "Mr "+ vacation.getlName()+" welcome , please chose the day of month you want to leave : ";

    }
    public void doDay(){
       massage1 = " you want to leave in "+ dayLeave + " om";

    }
    public void insertVacation(){
     vacation =  vacationService.getInformationForVacation(nationalCode);
      vacation.setDayOfLeave(dayLeave);
        vacationService.insertVacation(vacation);
    }

    public void createTableVacation() {
        vacationService.creatTableVacation();
    }
}
