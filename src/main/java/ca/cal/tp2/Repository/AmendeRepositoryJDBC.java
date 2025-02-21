package ca.cal.tp1.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ca.cal.tp1.Modele.Amende;

public class AmendeRepositoryJDBC extends RepositoryParentJDBC implements AmendeRepository {


    public void save(Amende amende) {
        String query = "INSERT INTO amende (fineid, montant, dateCreation, status) VALUES (?, ?, ?, ?)";
        Connection connection = super.conn;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, amende.getFineID());
            preparedStatement.setDouble(2, amende.getMontant());
            preparedStatement.setDate(3, amende.getDateCreation());
            preparedStatement.setBoolean(4, amende.isStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Amende getAmende(int id) {
        String query = "SELECT * FROM amende WHERE fineid = ?";
        Connection connection = super.conn;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Amende(rs.getInt("fineid"), rs.getDouble("montant"), rs.getDate("dateCreation"), rs.getBoolean("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
