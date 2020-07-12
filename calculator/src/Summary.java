import javax.swing.*;
import java.awt.*;

public class Summary extends JDialog {
    Summary(UI parent) {
        super(parent, "Resumen");
        this.setLayout(new GridLayout());
        this.pack();
    }
}
