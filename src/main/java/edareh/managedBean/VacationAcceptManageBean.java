package edareh.managedBean;

import edareh.entity.Personnel;
import edareh.entity.Vacation;
import edareh.service.VacationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class VacationAcceptManageBean {
    @Inject
    VacationService vacationService;


    private Personnel personnel;
    private Vacation vacation;

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    @PostConstruct
    public void init(){
        personnel = new Personnel();
        vacation = new Vacation();
    }

    public int getManID() {
        return manID;
    }

    public void setManID(int manID) {
        this.manID = manID;
    }

    private int manID;

    public String getMassage2() {
        return massage2;
    }

    public void setMassage2(String massage2) {
        this.massage2 = massage2;
    }

    private String massage2;
    private String massageLeave;

    private String massageConfirm;

    private String nationalCode;

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getMassageConfirm() {
        return massageConfirm;
    }

    public void setMassageConfirm(String massageConfirm) {
        this.massageConfirm = massageConfirm;
    }

    public String getMassageLeave() {
        return massageLeave;
    }

    public void setMassageLeave(String massageLeave) {
        this.massageLeave = massageLeave;
    }

    public void confirmData(){
        vacation.setnCode(nationalCode);
        vacationService.confirmData(vacation);
    }
    public void doConfirm(){
        massageConfirm = "saved";

    }
    public void getVacationDao(){
       vacation = vacationService.getVacationDao(nationalCode);
    }
    public void doManager(){

        if (manID==1234){
            massage2 = "Welcome manager, Enter national code of person for check his vacation request :  ";
        }else {
            massage2 = " You are not the manager";
        }

    }
    public void doLeave(){
        vacationService.getVacationDao(nationalCode);
       massageLeave =  "Mr "+ vacation.getlName()+ " want to leave in "+ vacation.getDayOfLeave()+ " om , Do you confirm it ? ";
    }

}
