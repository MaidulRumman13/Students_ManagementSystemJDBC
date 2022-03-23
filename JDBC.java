package Final_SE_410;

import java.sql.*;
import java.util.Scanner;

public class JDBC {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");

            try (
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost/javatest", "root", "")) {
                Statement stmt = con.createStatement();
                System.out.println("How many Students?: ");
                int n = scan.nextInt();
                scan.nextLine();
                String name = "";
                String id = "";
                String batch = "";
                String query1 = "";
                for (int i = 0; i < n; i++) {
                    System.out.println("Enter ID: ");
                    id = scan.nextLine();
                    System.out.println("Enter Name: ");
                    name = scan.nextLine();
                    System.out.println("Enter Batch: ");
                    batch = scan.nextLine();
                    query1 = "INSERT INTO `table1`(`uni_id`, `name`, `batch`) VALUES ( '" + id + "1', '" + name + "', '" + batch + "')";
                    stmt.executeUpdate(query1);
                }

                ResultSet rs = stmt.executeQuery("select * from table1");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  ID: " + rs.getString(2) + "  Name: " + rs.getString(3) + "  Batch: " + rs.getString(4));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
