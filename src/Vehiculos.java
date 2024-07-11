public class Vehiculos {
    String placa;
    String marca;
    double cilindraje;
    String tipo_conbustible;
    String color;
    String propietario;
    /*Constructores*/
    public Vehiculos(){}
    public Vehiculos(String placa, String marca, int cilindraje, String tipo_conbustible, String color, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.tipo_conbustible = tipo_conbustible;
        this.color = color;
        this.propietario = propietario;
    }
    /*Stters y getters*/

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo_conbustible() {
        return tipo_conbustible;
    }

    public void setTipo_conbustible(String tipo_conbustible) {
        this.tipo_conbustible = tipo_conbustible;
    }

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
