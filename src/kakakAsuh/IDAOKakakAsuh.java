/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kakakAsuh;


import applicationmodel.KakakAsuhModel;
import aplikasi.adsuh.server.*;

import java.util.List;

/**
 *
 * @author raja
 */
public interface IDAOKakakAsuh {
    //read
    public List<KakakAsuhModel> getAll();
    //insert
    public boolean insert(KakakAsuhModel b);
    //update
    public void update(KakakAsuhModel b);
    //delete
    public void delete(int id); 
    //search
    public List<KakakAsuhModel> getAllByName(String nama);
}
