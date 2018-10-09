package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "module")
public class Module {
    private String module_no;
    private String module_name;
    private String lecturer_name;
    private int credit;

    public Module(String module_no, String module_name, String lecturer_name, int credit) {
        super();
        this.module_no = module_no;
        this.module_name = module_name;
        this.lecturer_name = lecturer_name;
        this.credit = credit;
    }

    public Module() {

    }

    @Id
    @Column(name = "module_no")
    public String getModule_no() {
        return module_no;
    }

    public void setModule_no(String module_no) {
        this.module_no = module_no;
    }

    @Column(name = "module_name")
    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    @Column(name = "lecturer_name")
    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    @Column(name = "credit")
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

}
