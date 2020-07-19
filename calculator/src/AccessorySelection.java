import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class AccessorySelection extends JPanel implements IMultiChoiceComponent {
    private ArrayList<JCheckBox> group;
    AccessorySelection(Set<String> options) {
        super(new GridLayout(1, options.size()));
        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        this.group = new ArrayList<JCheckBox>();
        this.add(new JLabel("Accesorios:"));
        for (String o: options) {
            JCheckBox button = new JCheckBox(o);
            this.add(button);
            this.group.add(button);
        }
    }

    @Override
    public ArrayList<String> Selection() {
        ArrayList<String> result = new ArrayList<>();
        for (JCheckBox item : this.group) {
            if(item.isSelected()) {
                result.add(item.getText());
            }
        }
        return result;
    }

    @Override
    public boolean IsSelected() {
        return false;
    }
}
