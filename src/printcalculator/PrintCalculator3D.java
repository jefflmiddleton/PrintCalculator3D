/*
 *  Jeff Middleton
 *  JeffLMiddleton@gmail.com
 *  Created  2018
 */
package printcalculator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jeff Middleton
 */
public class PrintCalculator3D {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrintCalcModel model = new PrintCalcModel();
                PrintCalcView view = new PrintCalcView("3D Printer Calculator 2.0");
                PrintCalcController controller = new PrintCalcController(model, view);
                controller.control();

                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Metal".equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(PrintCalculator3D.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
            }
        });
    }

}
