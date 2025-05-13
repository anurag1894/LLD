package StudentExample;

public class Student implements  protoClone{
    private
    int id;
    public
    String name;
    String address;

    Student(int roll,String name,String  address){
        this.id =roll;
        this.name = name;
        this.address = address;
    }
    @Override
    public protoClone clone(){
        return new Student(this.id,this.name,this.address);
    }

}
