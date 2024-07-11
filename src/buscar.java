import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class buscar {
    public JPanel buscar_ve;
    private JTextField placaBus;
    private JButton buscar;
    private JButton regresar;
    private JLabel propietario;
    private JLabel placa;
    private JLabel marca;
    private JLabel Cilindra;
    private JLabel combusti;
    private JLabel color;
    private JLabel informacion;
    private JFrame frame1;

    public buscar( JFrame frame) {
        frame1=frame;
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehiculos vehiculo = new Vehiculos();
                vehiculo.setPlaca(placaBus.getText());
                /*Linea de conexion*/
                String url = "jdbc:mysql://localhost:3306/vehiculos";
                String usuario = "root";
                String contrasenia = "123456";
                try (Connection connection = DriverManager. getConnection(url, usuario, contrasenia)) {
                    System.out.println("Conexion exitosa");
                    String busqueda = "select * from vehiculo where placa = '" + vehiculo.getPlaca() + "'";
                    PreparedStatement statement = connection.prepareStatement(busqueda);
                    ResultSet resultado = statement.executeQuery();
                    if(resultado.next()) {
                        propietario.setText("Propietario: "+resultado.getString("propetiario"));
                        placa.setText("Placa: "+resultado.getString("placa"));
                        marca.setText("Marca: "+resultado.getString("marchar"));
                        Cilindra.setText("Cilindraje: "+resultado.getString("cilindraje"));
                        combusti.setText("Tipo de combustible: "+resultado.getString("tipo_combustible"));
                        color.setText("Color: "+resultado.getString("color"));
                        frame1.setPreferredSize(new Dimension(500,600));
                        frame1.pack();
                        frame1.setLocationRelativeTo(null);
                    } else {
                        informacion.setText("El vehiculo no existe");
                    }
                }
                catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(500, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new pantalla_vehiculos(frame).panel_ve);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame1.setVisible(false);
            }
        });
    }
}
