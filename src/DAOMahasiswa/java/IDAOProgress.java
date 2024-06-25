/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOMahasiswa.java;


import applicationmodel.ProgressModel;
import java.util.List;

/**
 *
 * @author raja
 */
public interface IDAOProgress {
    //read
    public List<ProgressModel> getAll();
    //insert
    public boolean insert(ProgressModel b);
    //update
    public void update(ProgressModel b);
    //delete
    public void delete(int id); 
    //search
    public List<ProgressModel> getAllByName(String nama_adsuh);
    
    ProgressModel getByNameAndNoAbsen(String name, int noAbsen);

}
