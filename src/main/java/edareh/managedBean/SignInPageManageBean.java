package edareh.managedBean;

import edareh.entity.Personnel;
import edareh.service.PersonnelService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class SignInPageManageBean {
    @Inject
    private PersonnelService personnelService;
    private Personnel personnel;
    private String message;

    private List<Personnel> personnelList;

    @PostConstruct
    public void init() {
        personnel = new Personnel();
        findAll();
    }

    public void doInfo(){
        message = "Mr "+ personnel.getLasteName()+" your iformations are saved";
    }

    public void InsertInfo(){
        personnelService.InsertInfo(personnel);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void createTablePersonnel() {
        personnelService.creatTablePersonnel();
    }

    private void findAll(){
        personnelList = personnelService.findAll();
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }
}
