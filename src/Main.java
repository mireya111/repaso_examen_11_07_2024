import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new pantalla_vehiculos(frame).panel_ve);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}