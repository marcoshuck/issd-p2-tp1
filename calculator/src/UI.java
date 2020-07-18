import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UI extends JFrame {
    private Summary summary;
    private CpuDropdown cpuDropdown;
    private HashMap<String, Integer> cpuList;

    private MotherboardSelection motherboardSelection;
    private HashMap<String, Integer> motherBoardList;

    private RamSelection ramSelection;
    private HashMap<String, Integer> ramList;

    private HashMap<String, Integer> accessoryList;

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
        this.summary = new Summary(this);
        this.cpuDropdown = new CpuDropdown(this.cpuList.keySet());
        this.add(this.cpuDropdown);

        this.motherboardSelection = new MotherboardSelection(this.motherBoardList.keySet());
        this.add(this.motherboardSelection);

        this.ramSelection = new RamSelection(this.ramList.keySet());
        this.add(this.ramSelection);
    }
}
