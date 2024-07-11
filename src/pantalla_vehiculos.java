import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pantalla_vehiculos {
    public JPanel panel_ve;
    private JTextField placa;
    private JTextField marca;
    private JTextField cilindraje;
    private JTextField combustible;
    private JTextField color;
    private JTextField nombre;
    private JButton insertarButton;
    private JButton buscarButton;
    private JLabel confirmacion;
    private JButton limpiar;

    public pantalla_vehiculos(JFrame frame1) {
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Setteo de objetos*/
                Vehiculos vehiculo = new Vehiculos();
                vehiculo.setPlaca(placa.getText());
                vehiculo.setMarca(marca.getText());
                vehiculo.setCilindraje(Double.parseDouble(cilindraje.getText()));
                vehiculo.setTipo_conbustible(combustible.getText());
                vehiculo.setColor(color.getText());
                vehiculo.setPropietario(nombre.getText());
                /*Linea de conexion*/
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String user = "root";
                String contrasenia = "123456";
                /*La conexion es fructifera*/
                try(Connection connection= DriverManager.getConnection(url, user, contrasenia)){
                    System.out.println("Conectado");
                    String consulta = "insert into vehiculo(placa, marchar, cilindraje, tipo_combustible, color, propetiario) values (?, ?, ?, ?, ?, ?)";
                    PreparedStatement activasConsulata = connection.prepareStatement(consulta);
                    activasConsulata.setString(1, vehiculo.getPlaca());
                    activasConsulata.setString(2, vehiculo.getMarca());
                    /*De double a string = String.valueOf*/
                    activasConsulata.setString(3, String.valueOf(vehiculo.getCilindraje()));
                    activasConsulata.setString(4, vehiculo.getTipo_conbustible());
                    activasConsulata.setString(5, vehiculo.getColor());
                    activasConsulata.setString(6, vehiculo.getPropietario());
                    activasConsulata.executeUpdate();
                    confirmacion.setText("Se ha registrado el vehiculo");
                }
                /*La conexion no es fructifera*/
                catch (SQLException exception){
                    System.out.println(exception.getMessage());
                }

            }
        });
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placa.setText(" ");
                marca.setText(" ");
                cilindraje.setText(" ");
                combustible.setText(" ");
                color.setText(" ");
                nombre.setText(" ");
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Busqueda de vehiculos");
                frame.setSize(600, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new buscar(frame).buscar_ve);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame1.setVisible(false);
            }
        });
    }
}
