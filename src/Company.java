/**
 * Created by Duc.Nguyen on 6/5/2018.
 */
public class Company {
    private String departmentName = "";
    public Company(){}

    public Company(String dptName) {
        setName(dptName);
    }

    public Company setName(String dptName) {
        this.departmentName = dptName;
        return this;
    }

    public String getName(){
        return departmentName;
    }

}
