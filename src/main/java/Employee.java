import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employee {

    private String name,surname,address;
    private Calendar date;
    private Gender sex;
    private double salary;


    public Employee(String name, String surname,Gender sex, byte day, byte month, int year, String address, double salary) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.sex = sex;
        this.salary = salary;
        date = new GregorianCalendar(year,--month,day);
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public Gender getSex() {
        return sex;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getAddress(){
        return this.address;
    }
    public String getDateStringFormat(){
        return String.format("%s.%s.%s",date.get(Calendar.DAY_OF_MONTH),
                (date.get(Calendar.MONTH) +1),date.get(Calendar.YEAR));
    }

    
    public String toString() {
        return "Name: " + name + "\r\nSurname: " + surname + "\r\nSex: " + sex.toString() + "\r\nAddress: " + address + "\r\nSalary: " + salary +
               "\r\nДень: " +  date.get(Calendar.DAY_OF_MONTH) + " Месяц: " + (date.get(Calendar.MONTH) +1) + " Год: " + date.get(Calendar.YEAR);
    }


    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Employee)) return false;

        Employee temp = (Employee) obj;

        return this.name.equals(temp.getName())
            && this.surname.equals(temp.getSurname())
            && this.sex == temp.getSex();
    }
    @Override
    public int hashCode() {
        int result = 22;
        result = 228 * result + name.hashCode();
        result = 228 * result + surname.hashCode();
        result = 228 * result + sex.hashCode();
        return result;
    }

   
}