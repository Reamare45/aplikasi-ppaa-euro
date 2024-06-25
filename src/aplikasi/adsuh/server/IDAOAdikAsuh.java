/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aplikasi.adsuh.server;


import applicationmodel.AdikAsuhModel;
import java.util.List;

/**
 *
 * @author raja
 */
public interface IDAOAdikAsuh {
    //read
    public List<AdikAsuhModel> getAll();
    //insert
    public boolean insert(AdikAsuhModel b);
    //update
    public void update(AdikAsuhModel b);
    //delete
    public void delete(int id); 
    //search
    public List<AdikAsuhModel> getAllByName(String nama);
}
