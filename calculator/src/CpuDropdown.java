import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class CpuDropdown extends JPanel implements ISingleChoiceComponent {
    public JLabel label;
    public JComboBox comboBox;
    CpuDropdown(Set<String> cpuList) {
        super(new GridLayout(1, 2));

        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        this.label = new JLabel("Tipo de:");
        this.add(this.label);

        this.comboBox = new JComboBox();
        for (String c: cpuList) {
            this.comboBox.addItem(c);
        }
        this.add(this.comboBox);
    }

    @Override
    public String Selection() {
        return this.comboBox.getSelectedItem().toString();
    }

    @Override
    public boolean IsSelected() {
        return true;
    }
}
