package Organisation;

import java.sql.*;

public class Database {
    private Connection connection;

    public Database() {
        // Establish connection to NeonDB
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/unitygives_db", "postgres", "Dali123;");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean addUser(User user) {
        String SQL = "INSERT INTO users(name, email, password, role) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getRole());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int login(String email, String password) {
        String SQL = "SELECT * FROM users WHERE email = ? and password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public User getUser(int id) {
        String SQL = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(SQL)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role").equals("Admin") ? new Admin(rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("role")) : new NormalUser(rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//    public void AddEvent(Event event){
//        events.add(event);
//        eventNames.add(event.getName());
//    }
//}
