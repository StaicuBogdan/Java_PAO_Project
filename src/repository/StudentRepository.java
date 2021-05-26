package repository;

import config.*;
import model.*;

import java.sql.*;
import java.util.*;

public class StudentRepository {
    /*
    *   Statement
    *   PreparedStatement
    *   CallableStatement
    *
    * */

    public void addStudent(Student student) {
        String sql = "insert into students values (null, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {//try with resources
          statement.setString(1, student.getName());
          statement.setInt(2, student.getAge());
          statement.setDouble(3, student.getMedie());
          statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Student> getStudentById(int id) {
        String sql = "select * from students ba where ba.id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                //i have at least one record in the result set
                int studentId = result.getInt(1);
                String name = result.getString("name");
                int age = result.getInt("age");
                double medie = result.getDouble("medie");
                return Optional.of(new Student(studentId, name, age, medie));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
