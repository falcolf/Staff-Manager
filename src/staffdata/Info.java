package staffdata;
import java.util.Date;
public class Info {
    private int id;
    private String name;
    private String gender;
    private Date dob;
    private Date doj;
    private int sal;
    private String no;
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public void setDob(Date dob){
        this.dob=dob;
    }
    public void setDoj(Date doj){
        this.doj=doj;
    }
    public void setSal(int sal){
        this.sal=sal;
    }
    public void setNo(String no){
        this.no=no;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public Date getDob(){
        return dob;
    }
    public Date getDoj(){
        return doj;
    }
    public int getSal(){
        return sal;
    }
    public String getNo(){
        return no;
    }
}