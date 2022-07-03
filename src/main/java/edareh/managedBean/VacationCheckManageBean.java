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
public class VacationCheckManageBean {
    @Inject
    VacationService vacationService;


    private Personnel personnel;
    private Vacation vacation;

    private String nationalCode;

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    private String massageCheck;

    public String getMassageCheck() {
        return massageCheck;
    }

    public void setMassageCheck(String massageCheck) {
        this.massageCheck = massageCheck;
    }

    @PostConstruct
    public void init(){
        personnel = new Personnel();
        vacation = new Vacation();
    }

    public void getInformationForVacation(){

         vacation = vacationService.getVacationDao(nationalCode);
    }
    public void doCheck(){
         massageCheck = "Mr "+ vacation.getlName()+" your vacation request has "+ vacation.getConfirm();

    }
}
