/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dd;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Younes
 */
@Stateless
public class NewSessionBean implements NewSessionBeanRemote {
    static List<String[]> l = new ArrayList<>();
    
//    l.add(new String[]{"4","2","3","alg","oran","10:00","11:00"});
//    l.add(new String[]{"d", "f"});
    @Override
    public String sayHi() {
        l.add(new String[]{"4","2","3","alg","oran","10:00","11:00"});
        return l.get(0)[0];
    }

    @Override
    public String Add(String[] item) {
//        if(item.length<l.get(0)[0].length())
        l.add(item);
        return "";
        
    }

    @Override
    public void delete(int id) {
         for (int i = 0; i < l.size(); i++) {
            if(l.get(i)[0].equals(String.valueOf( id))){
                l.remove(i);
            }
        }
    }

    @Override
    public String search(int id) {
        String res="";
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i)[0].equals(String.valueOf( id))){
                for (int j = 0; j < l.get(i).length; j++) {
                    res+=l.get(i)[j]+" | ";
                }
            }
        }
        return res;
    }

    @Override
    public String searchAll() {
        String res="";
        for (int i = 0; i < l.size(); i++) {
                for (int j = 0; j < l.get(i).length; j++) {
                    res+=l.get(i)[j]+" | ";
                }
                res+="\n";     
        }
        return res;
    }
}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


  