
package principal;

import javax.swing.UIManager;
import presentacion.FrmMenuPrincipal;

public class Inicio {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            new FrmMenuPrincipal().setVisible(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
