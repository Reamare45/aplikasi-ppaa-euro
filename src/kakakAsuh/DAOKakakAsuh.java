package kakakAsuh;

import applicationmodel.KakakAsuhModel;
import aplikasi.adsuh.server.*;
import applicationserverdb.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DAOKakakAsuh implements IDAOKakakAsuh {
    private Connection con;

    // SQL Queries
    private static final String strRead = "SELECT * FROM KakakAsuh ORDER BY no_absen ASC;";
    private static final String strInsert = "INSERT INTO KakakAsuh(no_absen, nama, hasil_angka, hasil_huruf, predikat, status) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String strUpdate = "UPDATE KakakAsuh SET nama=?, hasil_angka=?, hasil_huruf=?, predikat=?, status=? WHERE no_absen=?;";
    private static final String strDelete = "DELETE FROM KakakAsuh WHERE no_absen=?;";
    private static final String strSearch = "SELECT * FROM KakakAsuh WHERE nama LIKE ?;";

    public DAOKakakAsuh() {
        con = DBConnection.connectDB();
    }

    @Override
    public List<KakakAsuhModel> getAll() {
        List<KakakAsuhModel> lstMhs = new ArrayList<>();
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(strRead)) {
            while (rs.next()) {
                KakakAsuhModel mhs = new KakakAsuhModel();
                mhs.setNoAbsen(rs.getInt("no_absen"));
                mhs.setNama(rs.getString("nama"));
                mhs.setHasilAngka(rs.getInt("hasil_angka"));
                mhs.setHasilHuruf(rs.getString("hasil_huruf"));
                mhs.setPredikat(rs.getString("predikat"));
                mhs.setStatus(rs.getString("status"));
                lstMhs.add(mhs);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lstMhs;
    }

    @Override
    public boolean insert(KakakAsuhModel b) {
        try (PreparedStatement statement = con.prepareStatement(strInsert)) {
            statement.setInt(1, b.getNoAbsen());
            statement.setString(2, b.getNama());
            statement.setInt(3, b.getHasilAngka());
            statement.setString(4, b.getHasilHuruf());
            statement.setString(5, b.getPredikat());
            statement.setString(6, b.getStatus());
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to insert: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void update(KakakAsuhModel b) {
        try (PreparedStatement statement = con.prepareStatement(strUpdate)) {
            statement.setString(1, b.getNama());
            statement.setInt(2, b.getHasilAngka());
            statement.setString(3, b.getHasilHuruf());
            statement.setString(4, b.getPredikat());
            statement.setString(5, b.getStatus());
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
    public List<KakakAsuhModel> getAllByName(String nama) {
        List<KakakAsuhModel> lstMhs = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(strSearch)) {
            st.setString(1, "%" + nama + "%");
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    KakakAsuhModel mhs = new KakakAsuhModel();
                    mhs.setNoAbsen(rs.getInt("no_absen"));
                    mhs.setNama(rs.getString("nama"));
                    mhs.setHasilAngka(rs.getInt("hasil_angka"));
                    mhs.setHasilHuruf(rs.getString("hasil_huruf"));
                    mhs.setPredikat(rs.getString("predikat"));
                    mhs.setStatus(rs.getString("status"));
                    lstMhs.add(mhs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return lstMhs;
    }
}
