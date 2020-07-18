import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class RamSelection extends JPanel {
    private ButtonGroup group;
    private JPanel buttonsPanel;
    private JLabel label;
    private Set<String> options;

    RamSelection(Set<String> options) {
        super(new GridLayout(1, 2));
        this.options = options;
        this.setupComponents();
    }

    private void setupComponents() {
        this.label = new JLabel("Memoria:");
        this.buttonsPanel = new JPanel();
        this.add(this.label);

        this.group = new ButtonGroup();
        for (String o : this.options) {
            JRadioButton button = new JRadioButton(o);
            this.buttonsPanel.add(button);
            this.group.add(button);
        }
        this.add(this.buttonsPanel);
    }
}
