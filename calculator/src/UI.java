import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    private Summary summary;
    UI() {
        super("Venta de PC");
        this.setLayout(new GridLayout(6, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setupComponents();
    }

    private void setupComponents() {
        this.summary = new Summary(this);
    }
}
