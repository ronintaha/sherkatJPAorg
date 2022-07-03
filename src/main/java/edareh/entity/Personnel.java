package edareh.entity;

import jakarta.persistence.*;
@NamedQueries({
        @NamedQuery(
                name = "findByNationalCode",
                query = "select personnel from Personnel personnel where personnel.nationalCode=:nationalCode"
        ),
        @NamedQuery(
                name = "showAll",
                query = "select personnel from Personnel personnel"
        )
})
@Entity
@Table(name = "PERSONEL1")
public class Personnel {
    private  String name ;
    private  String lasteName;
    private  String age;
    private  String nationalCode;
    private Long id;


    public Personnel(){}

    public Personnel(String name,String lasteName,String nationalCode,String age){
        this.name=name;
        this.lasteName=lasteName;
        this.nationalCode=nationalCode;
        this.age=age;
    }

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "FirstName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "LastName")
    public String getLasteName() {
        return lasteName;
    }
    public void setLasteName(String lasteName) {
        this.lasteName = lasteName;
    }
    @Column(name = "Age")
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    @Column(name = "NationalCode")
    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }



}
