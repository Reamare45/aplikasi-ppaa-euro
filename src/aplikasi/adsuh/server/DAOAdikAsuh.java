package aplikasi.adsuh.server;

import applicationmodel.AdikAsuhModel;
import applicationserverdb.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author raja
 */
public class DAOAdikAsuh implements IDAOAdikAsuh {
    private Connection con;

    // SQL Queries
    private static final String strRead = "SELECT * FROM AdikAsuh ORDER BY no_absen ASC;";
    private static final String strInsert = "INSERT INTO AdikAsuh(no_absen, nama, umur, kelas) VALUES (?, ?, ?, ?);";
    private static final String strUpdate = "UPDATE AdikAsuh SET nama=?, umur=?, kelas=? WHERE no_absen=?;";
    private static final String strDelete = "DELETE FROM AdikAsuh WHERE no_absen=?;";
    private static final String strSearch = "SELECT * FROM AdikAsuh WHERE nama LIKE ?;";

    public DAOAdikAsuh() {
        con = DBConnection.connectDB();
    }

    @Override
    public List<AdikAsuhModel> getAll() {
        List<AdikAsuhModel> lstMhs = new ArrayList<>();
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(strRead)) {
            while (rs.next()) {
                AdikAsuhModel mhs = new AdikAsuhModel();
                mhs.setNoAbsen(rs.getInt("no_absen"));
                mhs.setNama(rs.getString("nama"));
                mhs.setUmur(rs.getInt("umur"));
                mhs.setKelas(rs.getString("kelas"));
                lstMhs.add(mhs);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lstMhs;
    }

    @Override
    public boolean insert(AdikAsuhModel b) {
        try (PreparedStatement statement = con.prepareStatement(strInsert)) {
            statement.setInt(1, b.getNoAbsen());
            statement.setString(2, b.getNama());
            statement.setInt(3, b.getUmur());
            statement.setString(4, b.getKelas());
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to insert: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void update(AdikAsuhModel b) {
        try (PreparedStatement statement = con.prepareStatement(strUpdate)) {
            statement.setString(1, b.getNama());
            statement.setInt(2, b.getUmur());
            statement.setString(3, b.getKelas());
            statement.setInt(4, b.getNoAbsen());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to update: " + e.getMessage());
        }
    }

    @Override
    public void delete(int noAbsen) {
        try (PreparedStatement statement = con.prepareStatement(strDelete)) {
            statement.setInt(1, noAbsen);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to delete: " + e.getMessage());
        }
    }

    @Override
    public List<AdikAsuhModel> getAllByName(String nama) {
        List<AdikAsuhModel> lstMhs = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(strSearch)) {
            st.setString(1, "%" + nama + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    AdikAsuhModel mhs = new AdikAsuhModel();
                    mhs.setNoAbsen(rs.getInt("no_absen"));
                    mhs.setNama(rs.getString("nama"));
                    mhs.setUmur(rs.getInt("umur"));
                    mhs.setKelas(rs.getString("kelas"));
                    lstMhs.add(mhs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lstMhs;
    }
}
