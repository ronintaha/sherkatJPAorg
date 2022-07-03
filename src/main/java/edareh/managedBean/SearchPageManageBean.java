package edareh.managedBean;

import edareh.entity.Personnel;
import edareh.service.PersonnelService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SearchPageManageBean {

    @Inject
    PersonnelService personnelService;

    private Personnel personnel;

    private String nationalCode;

    @PostConstruct
    public void init() {
        personnel = new Personnel();
    }

    public void getInformation() {
        personnel = personnelService.getInformation(nationalCode);
    }

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
}
