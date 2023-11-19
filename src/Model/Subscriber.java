package Model;

public class Subscriber extends User{
    public String reference;
    public Subscriber(int id, String userName, String password,String sex, String reference) {
        super(id, userName, password, sex);
         this.reference = reference;
    }
}
