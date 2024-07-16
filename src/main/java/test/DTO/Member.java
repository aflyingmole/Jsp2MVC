package test.DTO;

import java.sql.Date;

public class Member {
    private String id;
    private String pwd;
    private String email;
    private int age;
    private Date regDate;

    public Member() {
    }

    public Member(String id, String pwd, String email, int age, Date regDate) {
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.age = age;
        this.regDate = regDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Date getRegDate() {
        return regDate;
    }
}
