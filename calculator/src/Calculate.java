import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculate extends JPanel implements ActionListener {
    private UI parent;
    private JButton calculateButton;
    private JTextField result;
    Calculate(UI parent) {
        super(new GridLayout(1, 2));
        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        this.parent = parent;

        this.calculateButton = new JButton("Calcular importe");
        this.calculateButton.addActionListener(this);
        this.add(this.calculateButton);

        this.result = new JTextField("$0.00");
        this.add(this.result);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.result.setText("$ " + parent.calculateFinalPrice());
    }
}
