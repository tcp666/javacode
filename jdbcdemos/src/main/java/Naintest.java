import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Naintest {
    public static void main(String[] args) {
        Connection connection=C3P0Utils.getConnection();
        System.out.println(connection);
        try {
            PreparedStatement pstm=connection.prepareStatement("scale *from users");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
