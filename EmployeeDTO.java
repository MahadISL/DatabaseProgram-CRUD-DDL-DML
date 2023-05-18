import java.sql.*;

public class EmployeeDTO {

    DBUtils db = new DBUtils();

    public EmployeeDTO() throws SQLException {
    }

    public void deleteById(int employeeID) throws SQLException {

        String query = "DELETE FROM employee1 " + "WHERE employeeId = " + employeeID;

        Connection con = db.getConnection();

        Statement st = con.createStatement();
        st.executeUpdate(query);

        System.out.println("deleted");

    }

    public void getById(int employeeID) throws SQLException {
        String query = "SELECT * FROM employee1 " + "WHERE employeeId = " + employeeID;

        Connection con = db.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

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

        Connection con = db.getConnection();
        //System.out.println(con.hashCode());

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

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

        //Statement st = con.createStatement();
        Connection con = db.getConnection();
        PreparedStatement st = con.prepareStatement("insert into employee1 values(?,?,?,?,?) ");

        //  Loop through Employee Array and insert its values into Database

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

        Connection con = db.getConnection();
        System.out.println(con.hashCode());

        Statement st = con.createStatement();

        String query = "UPDATE employee1 SET firstName = '" + firstName + "' WHERE employeeId = " + employeeId;

        st.executeUpdate(query);
        System.out.println("Updated");

    }

}
