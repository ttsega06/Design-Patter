import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import libs.CpuUtilizationSensor;
import libs.DeskUsageSensor;
import libs.MemoryUsageSensor;

public class ActivityMonitorGUI extends JFrame {

    public ActivityMonitorGUI() {
        setTitle("Activity Monitor Tracker");
        setLayout(new GridLayout(3,1));

    
        CPUSensor cpu = new CPUSensor();
        JPanel  pnlCPU = new JPanel();
        pnlCPU.setBorder(new TitledBorder(cpu.getTitle()));
        pnlCPU.setLayout(new GridLayout(2,1));
        JLabel lblCPU = new JLabel(cpu.getStatusMessage());
        lblCPU.setBorder(new EmptyBorder(0,100,0,0));
        JProgressBar barCPU = new JProgressBar();
        barCPU.setForeground(cpu.getBarColor());
        barCPU.setMaximum(cpu.getDangerBarValue());
        barCPU.setValue((int)cpu.getValue());     
        pnlCPU.add(barCPU);
        pnlCPU.add(lblCPU);
        add(pnlCPU);
        
        //Desk Usage Sensor
        DeskUsageSensorImp dus = new DeskUsageSensorImp();
        JPanel  pnlDUS = new JPanel();
        pnlDUS.setBorder(new TitledBorder(dus.getTitle()));
        pnlDUS.setLayout(new GridLayout(2,1));
        JLabel lblDUS = new JLabel(dus.getStatusMessage());
        lblDUS.setBorder(new EmptyBorder(0,100,0,0));
        JProgressBar barDUS = new JProgressBar();
        barDUS.setForeground(dus.getBarColor());
        barDUS.setMaximum(dus.getDangerBarValue());
        barDUS.setValue((int)dus.getValue());     
        pnlDUS.add(barDUS);
        pnlDUS.add(lblDUS);
        add(pnlDUS);
        
        //Memory Usage Sensor
        MemorySensor mus = new MemorySensor();
        JPanel  pnlMUS = new JPanel();
        pnlMUS.setBorder(new TitledBorder(mus.getTitle()));
        pnlMUS.setLayout(new GridLayout(2,1));
        JLabel lblMUS = new JLabel(mus.getStatusMessage());
        lblMUS.setBorder(new EmptyBorder(0,100,0,0));
        JProgressBar barMUS = new JProgressBar();
        barMUS.setForeground(mus.getBarColor());
        barMUS.setMaximum(mus.getDangerBarValue());
        barMUS.setValue((int)mus.getValue());     
        pnlMUS.add(barMUS);
        pnlMUS.add(lblMUS);
        add(pnlMUS);
                
             
        setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        ActivityMonitorGUI app = new ActivityMonitorGUI();
    }

}
