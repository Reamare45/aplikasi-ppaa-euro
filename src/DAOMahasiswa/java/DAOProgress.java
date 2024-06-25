package DAOMahasiswa.java;

import applicationmodel.ProgressModel;
import applicationserverdb.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author raja
 */
public class DAOProgress implements IDAOProgress {
    private Connection con;

    // SQL Queries
    private static final String strRead = "SELECT * FROM Progres ORDER BY no_absen ASC;";
    private static final String strInsert = "INSERT INTO Progres(no_absen, nama_adsuh, minggu, keterampilan, keaktifan, nilai_quiz, peer, self, holistik, catatan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String strUpdate = "UPDATE Progres SET nama_adsuh=?, minggu=?, keterampilan=?, keaktifan=?, nilai_quiz=?, peer=?, self=?, holistik=?, catatan=? WHERE no_absen=?;";
    private static final String strDelete = "DELETE FROM Progres WHERE no_absen=?;";
    private static final String strSearch = "SELECT * FROM Progres WHERE nama_adsuh LIKE ?;";

    public DAOProgress() {
        con = DBConnection.connectDB();
    }

    @Override
    public List<ProgressModel> getAll() {
        List<ProgressModel> lstMhs = new ArrayList<>();
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(strRead)) {
            while (rs.next()) {
                ProgressModel mhs = new ProgressModel();
                mhs.setNoAbsen(rs.getInt("no_absen"));
                mhs.setNamaAdikAsuh(rs.getString("nama_adsuh"));
                mhs.setMinggu(rs.getInt("minggu"));
                mhs.setKeterampilan(rs.getInt("keterampilan"));
                mhs.setKeaktifan(rs.getInt("keaktifan"));
                mhs.setNilaiQuiz(rs.getInt("nilai_quiz"));
                mhs.setPerr(rs.getInt("peer"));
                mhs.setSelf(rs.getInt("self"));
                mhs.setHolistik(rs.getInt("holistik"));
                mhs.setCatatan(rs.getString("catatan"));
                lstMhs.add(mhs);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lstMhs;
    }

    @Override
    public boolean insert(ProgressModel b) {
        try (PreparedStatement statement = con.prepareStatement(strInsert)) {
            statement.setInt(1, b.getNoAbsen());
            statement.setString(2, b.getNamaAdikAsuh());
            statement.setInt(3, b.getMinggu());
            statement.setInt(4, b.getKeterampilan());
            statement.setInt(5, b.getKeaktifan());
            statement.setInt(6, b.getNilaiQuiz());
            statement.setInt(7, b.getPerr());
            statement.setInt(8, b.getSelf());
            statement.setInt(9, b.getHolistik());
            statement.setString(10, b.getCatatan());
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to insert: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void update(ProgressModel b) {
        try (PreparedStatement statement = con.prepareStatement(strUpdate)) {
            statement.setString(1, b.getNamaAdikAsuh());
            statement.setInt(2, b.getMinggu());
            statement.setInt(3, b.getKeterampilan());
            statement.setInt(4, b.getKeaktifan());
            statement.setInt(5, b.getNilaiQuiz());
            statement.setInt(6, b.getPerr());
            statement.setInt(7, b.getSelf());
            statement.setInt(8, b.getHolistik());
            statement.setString(9, b.getCatatan());
            statement.setInt(10, b.getNoAbsen());
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
    public List<ProgressModel> getAllByName(String nama) {
        List<ProgressModel> lstMhs = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(strSearch)) {
            st.setString(1, "%" + nama + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    ProgressModel mhs = new ProgressModel();
                    mhs.setNoAbsen(rs.getInt("no_absen"));
                    mhs.setNamaAdikAsuh(rs.getString("nama_adsuh"));
                    mhs.setMinggu(rs.getInt("minggu"));
                    mhs.setKeterampilan(rs.getInt("keterampilan"));
                    mhs.setKeaktifan(rs.getInt("keaktifan"));
                    mhs.setNilaiQuiz(rs.getInt("nilai_quiz"));
                    mhs.setPerr(rs.getInt("peer"));
                    mhs.setSelf(rs.getInt("self"));
                    mhs.setHolistik(rs.getInt("holistik"));
                    mhs.setCatatan(rs.getString("catatan"));
                    lstMhs.add(mhs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lstMhs;
    }
    
    @Override
    public ProgressModel getByNameAndNoAbsen(String name, int noAbsen) {
        ProgressModel progress = null;
        try {
            // Create the SQL query
            String sql = "SELECT * FROM Progres WHERE nama_adsuh = ? AND no_absen = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, noAbsen);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Check if a record was found
            if (rs.next()) {
                progress = new ProgressModel();
                progress.setNoAbsen(rs.getInt("no_absen"));
                progress.setNamaAdikAsuh(rs.getString("nama_adsuh"));
                progress.setMinggu(rs.getInt("minggu"));
                progress.setKeterampilan(rs.getInt("keterampilan"));
                progress.setKeaktifan(rs.getInt("keaktifan"));
                progress.setNilaiQuiz(rs.getInt("nilai_quiz"));
                progress.setPerr(rs.getInt("peer"));
                progress.setSelf(rs.getInt("self"));
                progress.setHolistik(rs.getInt("holistik"));
                progress.setCatatan(rs.getString("catatan"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return progress;
    }
}
