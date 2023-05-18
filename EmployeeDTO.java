import java.sql.*;

public class EmployeeDTO {

    DBUtils db = new DBUtils();

    public EmployeeDTO() throws SQLException {
    }

    public void deleteById(int employeeID) throws SQLException {

        String query = "DELETE FROM employee1 " + "WHERE employeeId = " + employeeID;

        // Connection to DB and Query executed
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(query);

        System.out.println("deleted");

    }

    public void getById(int employeeID) throws SQLException {
        String query = "SELECT * FROM employee1 " + "WHERE employeeId = " + employeeID;

        // Connection to DB and Query executed
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        // Displaying DB table values
        while(rs.next()) {
            int employeeId = rs.getInt("employeeId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String occupation = rs.getString("occupation");
            int yearOfJoining = rs.getInt("yearOfJoining");

            System.out.format("%s,%s,%s,%s,%s\n", employeeId, firstName, lastName, occupation, yearOfJoining);
        }

    }

    public void readAll() throws SQLException {
        String query = "SELECT * FROM employee1";

        // Connection to DB and executing query
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        // Displaying table values
        while(rs.next()) {
            int employeeId = rs.getInt("employeeId");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String occupation = rs.getString("occupation");
            int yearOfJoining = rs.getInt("yearOfJoining");

            System.out.format("%s,%s,%s,%s,%s\n", employeeId, firstName, lastName, occupation, yearOfJoining);
        }
    }

    public void save(Employee emp) throws SQLException, ClassNotFoundException {

        // Connection to DB
        Connection con = db.getConnection();
        PreparedStatement st = con.prepareStatement("insert into employee1 values(?,?,?,?,?) ");

        // Inserting values to DB
        try {
            st.setInt(1, emp.getEmployeeID());
            st.setString(2, emp.getFirstName());
            st.setString(3, emp.getLastName());
            st.setString(4, emp.getOccupation());
            st.setInt(5, emp.getYearOfJoining());
            int i= st.executeUpdate();
            System.out.println(i+" records inserted");

        } catch (SQLException e) {
                throw new RuntimeException(e);
        }

    }

    public void update(int employeeId, String firstName) throws SQLException {

        String query = "UPDATE employee1 SET firstName = '" + firstName + "' WHERE employeeId = " + employeeId;

        // Connection to DB and executing Query
        Connection con = db.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(query);

        System.out.println("Updated");

    }

}
