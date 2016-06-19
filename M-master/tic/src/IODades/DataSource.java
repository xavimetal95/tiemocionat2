/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IODades;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public interface DataSource {
    public int open (String source, int mode);
    public int close (String source);
    public int importdades (ArrayList dades, String source);
    public int exportdades (ArrayList dades, String source, int mode);
}
