
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EmployeeManager {

    private static EmployeeManager instance;
    private Set<Employee> list;

    private EmployeeManager() {
        list = new HashSet<>();
    }

    public static EmployeeManager getInstance() {
        if (instance == null) {
            instance = new EmployeeManager();
        }
        return instance;
    }

    public int GetEmployeeCount() {
        return list.size();
    }

    public Employee addEmployee(Object[] obj) {

        try {
            String[] mas = Arrays.copyOf(obj, obj.length, String[].class);

            try {
                Gender s = mas[2].equalsIgnoreCase("Male") ? Gender.MALE : Gender.FEMALE;
                
                String[] date = mas[3].split("\\.");

                byte d = Byte.parseByte(date[0]);
                byte m = Byte.parseByte(date[1]);
                int y = Integer.parseInt(date[2]);
                double salary = Double.parseDouble(mas[4]);

                Employee emp = new Employee(mas[0], mas[1], s, d, m, y, mas[5], salary);
                list.add(emp);
                
                return emp;
                
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void showEmployee() {
        Iterator iter = list.iterator();
        for (; iter.hasNext();) {

            System.out.println(iter.next().toString());
        }
    }

    public void exportEmployee(String patch) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(patch))) {

            for (Employee emp : list) {
                bufferedWriter.write(emp.toString());
                bufferedWriter.write("\r\n************************************************\r\n");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public Employee searchEmployee(String nameAndSurname) {
        for (Employee emp : list) {
            String temp = (emp.getName() + " " + emp.getSurname()).toUpperCase();
            String temp2 = (emp.getSurname() + " " + emp.getName()).toUpperCase();
            if (nameAndSurname.equalsIgnoreCase(temp) || nameAndSurname.equalsIgnoreCase(temp2)) {
                return emp;
            }
        }
        return null;
    }

    public boolean deleteEmployee(String nameAndSurname) {
        Employee emp = this.searchEmployee(nameAndSurname);
        return list.remove(emp);
    }

}
