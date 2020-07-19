import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

public class RamSelection extends JPanel implements ISingleChoiceComponent {
    private ButtonGroup group;
    private JPanel buttonsPanel;
    private JLabel label;
    private Set<String> options;

    RamSelection(Set<String> options) {
        super(new GridLayout(1, options.size()));
        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
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

    @Override
    public String Selection() {
        Enumeration<AbstractButton> buttons = this.group.getElements();
        while(buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    @Override
    public boolean IsSelected() {
        return this.group.getSelection() != null;
    }
}
