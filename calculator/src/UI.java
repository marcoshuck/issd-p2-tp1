import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class UI extends JFrame implements ActionListener {
    private CpuDropdown cpuDropdown;
    private HashMap<String, Integer> cpuList;

    private MotherboardSelection motherboardSelection;
    private HashMap<String, Integer> motherBoardList;

    private RamSelection ramSelection;
    private HashMap<String, Integer> ramList;

    private AccessorySelection accessorySelection;
    private HashMap<String, Integer> accessoryList;

    private Calculate calculateBox;

    private JPanel controlBox;
    private JButton showDialog;
    private JButton quit;

    UI() {
        super("Venta de PC");
        this.setLayout(new GridLayout(6, 1));

        this.cpuList = new HashMap<String, Integer>();
        this.motherBoardList = new HashMap<String, Integer>();
        this.ramList = new HashMap<String, Integer>();
        this.accessoryList = new HashMap<String, Integer>();

        this.loadData();

        this.setupComponents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
    }

    private void loadData() {
        this.loadCPUList();
        this.loadMotherboardList();
        this.loadRAMList();
        this.loadAccessoryList();
    }

    private void loadCPUList() {
        this.cpuList.put("Intel", 150);
        this.cpuList.put("Athlon", 80);
        this.cpuList.put("Turion", 120);
    }

    private void loadMotherboardList() {
        this.motherBoardList.put("ASUS", 75);
        this.motherBoardList.put("Gigabyte", 320);
        this.motherBoardList.put("MSI", 100);
    }

    private void loadRAMList() {
        this.ramList.put("2Mb", 50);
        this.ramList.put("4Mb", 80);
        this.ramList.put("8Mb", 130);
    }

    private void loadAccessoryList() {
        this.accessoryList.put("Monitor", 250);
        this.accessoryList.put("Disco duro 1Tb", 80);
    }

    private void setupComponents() {
        this.cpuDropdown = new CpuDropdown(this.cpuList.keySet());
        this.add(this.cpuDropdown);

        this.motherboardSelection = new MotherboardSelection(this.motherBoardList.keySet());
        this.add(this.motherboardSelection);

        this.ramSelection = new RamSelection(this.ramList.keySet());
        this.add(this.ramSelection);

        this.accessorySelection = new AccessorySelection(this.accessoryList.keySet());
        this.add(this.accessorySelection);

        this.calculateBox = new Calculate(this);
        this.add(this.calculateBox);

        this.controlBox = new JPanel(new GridLayout(1, 2));
        this.controlBox.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        this.showDialog = new JButton("Mostrar diálogo");
        this.quit = new JButton("Salir");
        this.setupActions();

        this.controlBox.add(this.showDialog);
        this.controlBox.add(this.quit);
        this.add(this.controlBox);
    }

    private void setupActions() {
        this.showDialog.addActionListener(this);
        this.quit.addActionListener(this);
    }

    private String getSelectedMicro() {
        return this.cpuDropdown.Selection();
    }

    public String calculateFinalPrice() {
        float sum = 0;
        sum += this.cpuList.get(this.cpuDropdown.Selection());
        if (this.motherboardSelection.IsSelected()) {
            sum += this.motherBoardList.get(this.motherboardSelection.Selection());
        }
        if (this.ramSelection.IsSelected()) {
            sum += this.ramList.get(this.ramSelection.Selection());
        }
        for (String item : this.accessorySelection.Selection()) {
            sum += this.accessoryList.get(item);
        }
        return String.format("%.2f", sum);
    }

    private void createDialog() {
        JOptionPane.showMessageDialog(this, String.format("Se ha elegido el CPU: %s. El monto final es: $ %s", this.getSelectedMicro(), this.calculateFinalPrice()));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.quit)) {
            System.exit(0);
        }
        if (actionEvent.getSource().equals(this.showDialog)) {
            this.createDialog();
        }
    }
}
