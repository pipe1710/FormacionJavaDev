package co.com.bancolombia.practicas.entities;


public class CuentaAhorro extends Cuenta {
    private double tasaInteresMensual;

    public CuentaAhorro(int numero, double saldo, double tasaInteresMensual) {
        super(numero, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    // Getters y setters
    public double getTasaInteresMensual() {
        return tasaInteresMensual;
    }

    public void setTasaInteresMensual(double tasaInteresMensual) {
        this.tasaInteresMensual = tasaInteresMensual;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "numero=" + getNumero() +
                ", saldo=" + getSaldo() +
                ", tasaInteresMensual=" + tasaInteresMensual +
                '}';
    }
}

