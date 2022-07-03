package edareh.entity;

import jakarta.persistence.*;

import javax.enterprise.context.RequestScoped;
@NamedQueries({
        @NamedQuery(name = "getInfoVacationQuery",
                query = "select vacation from Vacation vacation where vacation.nCode=:nCode"
        )
})
@Entity
@Table(name = "Vacation")
public class Vacation {
    private  int dayOfLeave;
    private  String lName;
    private  String confirm;
    private  String nCode;
    private long id;

    public Vacation(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "NationalCode")
    public String getnCode() {
        return nCode;
    }

    public void setnCode(String nCode) {
        this.nCode = nCode;
    }

    @Column(name = "LastN")
    public String getlName() {
        return lName;
    }

    public  void setlName(String lName) {
        this.lName = lName;
    }

    @Column(name = "Confirm")
    public  String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    @Column(name = "VacationDay")
    public int getDayOfLeave() {
        return dayOfLeave;
    }

    public void setDayOfLeave(int dayOfLeave) {
        this.dayOfLeave = dayOfLeave;
    }
}
