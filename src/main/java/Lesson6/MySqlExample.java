package Lesson6;

import java.sql.*;

public class MySqlExample {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //Connection url:
        //jdbc:<database vendor>://<ip>:<port>/<database_name>
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeers?serverTimezone=UTC", "root", "root");
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("select * from employee");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int departmentId = resultSet.getInt("department_id");
                String login = resultSet.getString("login");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                System.out.println("ID = " + id + "; Department Id = " + departmentId + "; Login = " + login + "; Name = " + name
                        + "; Last name = " + lastName + "; Email = " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
