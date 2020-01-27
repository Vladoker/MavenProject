import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class ValueDao {
    private static String DB_URL = "jdbc:postgresql://127.0.0.1:5432/EmpManager";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "postgres";

    private Connection connect() throws SQLException {
        System.out.println("Connected to postgresql server successfully.");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
    
    public ArrayList<Employee> getAll() { 
        String sql = "SELECT * FROM app.employee"; 
        try (Connection conn = connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            ArrayList<Employee> list = new ArrayList<Employee>();
            // Iterate result set
            while (rs.next()) {
                String[] date = rs.getString("date").split("\\.");
                byte day = Byte.parseByte(date[0]);
                byte month = Byte.parseByte(date[1]);
                int year = Integer.parseInt(date[2]);
                double salary = rs.getDouble("salary");
                Gender gender = rs.getString("gender").equals("Male")?Gender.MALE:Gender.FEMALE;
                
                Employee emp = new Employee(rs.getString("name"),
                rs.getString("surname"),
                gender,
                day,month,year,
                rs.getString("address"),
                salary);
                
               list.add(emp);
            }
            return list;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to get all the values");
            System.out.println(ex);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public int add(Employee emp) { // Employee emp
        String sql = "INSERT INTO app.employee(name, surname, gender, date, salary, address)" +
                " VALUES (?,?,?,?,?,?)";
         try (Connection conn = connect();
                PreparedStatement dbStatement = conn.prepareStatement(sql)) {

             
            dbStatement.setString(1, emp.getName());
            dbStatement.setString(2, emp.getSurname());
            dbStatement.setString(3, emp.getSex().toString());
            dbStatement.setString(4, emp.getDateStringFormat());
            dbStatement.setDouble(5, emp.getSalary());
            dbStatement.setString(6, emp.getAddress());
            

            int affectedRows = dbStatement.executeUpdate();
            System.out.println(String.format("Executed insert statement. Affected %d rows", affectedRows));
            return affectedRows;
        } catch (SQLException ex) {
            System.err.println("Caught an error trying to insert the values: " + ex.getMessage());
        }
        return -1;
    }
    
    public int remove(String name, String surname) {
        String sql = "DELETE FROM app.employee WHERE name=? AND surname=?";
        try (Connection conn = connect();
             PreparedStatement dbStatement = conn.prepareStatement(sql)) {

            dbStatement.setString(1, name);
            dbStatement.setString(2, surname);
            int affectedRows = dbStatement.executeUpdate();
            System.out.println(String.format("Executed delete statement. Affected %d rows", affectedRows));
            return affectedRows;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return -1;
    }
    public int edit(String oldValues, String[] nawValues){
        String[]mas = oldValues.split(" ");
        String sql = "UPDATE app.employee SET name=?, surname=?, gender=?, date=?, salary=?, address=? "
                + "WHERE name=? AND surname=?";
        
        try(Connection conn = connect();
             PreparedStatement bdStatement = conn.prepareStatement(sql)){
            
            bdStatement.setString(1, nawValues[0]);
            bdStatement.setString(2, nawValues[1]);
            bdStatement.setString(3, nawValues[2]);
            bdStatement.setString(4, nawValues[3]);
            bdStatement.setDouble(5, Double.parseDouble(nawValues[4]));
            bdStatement.setString(6, nawValues[5]);
            
            bdStatement.setString(7, mas[0]);
            bdStatement.setString(8, mas[1]);
            
            int affectedRows = bdStatement.executeUpdate();
            System.out.println(String.format("Executed delete statement. Affected %d rows", affectedRows));
            return affectedRows;
            
        } catch(SQLException ex){
            System.out.println(ex);
        }
            
        return -1;
    }
    
    
 
}
