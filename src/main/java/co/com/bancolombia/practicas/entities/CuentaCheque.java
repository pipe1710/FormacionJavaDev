package co.com.bancolombia.practicas.entities;

import java.time.LocalDate;

public class CuentaCheque extends Cuenta {
    private double costoManejoMensual;

    public CuentaCheque(int numero, LocalDate fechaApertura, double saldo, double costoManejoMensual) {
        super(numero, fechaApertura, saldo);
        this.costoManejoMensual = costoManejoMensual;
    }

    // Getters y setters
    public double getCostoManejoMensual() {
        return costoManejoMensual;
    }

    public void setCostoManejoMensual(double costoManejoMensual) {
        this.costoManejoMensual = costoManejoMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeCheque{" +
                "numero=" + getNumero() +
                ", fechaApertura=" + fechaApertura +
                ", saldo=" + getSaldo() +
                ", costoManejoMensual=" + costoManejoMensual +
                '}';
    }
}
