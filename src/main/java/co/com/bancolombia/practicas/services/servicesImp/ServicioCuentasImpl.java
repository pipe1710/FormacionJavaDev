package co.com.bancolombia.practicas.services.servicesImp;


import co.com.bancolombia.practicas.entities.Cuenta;
import co.com.bancolombia.practicas.services.ServicioCuentas;

import java.util.ArrayList;

public class ServicioCuentasImpl implements ServicioCuentas {
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        return cuentas.add(cuenta);
    }

    @Override
    public boolean cancelarCuenta(int numero) {
        return cuentas.removeIf(cuenta -> cuenta.getNumero() == numero);
    }

    @Override
    public void abonarCuenta(int numero, double abono) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero() == numero) {
                cuenta.setSaldo(cuenta.getSaldo() + abono);
                break;
            }
        }
    }

    @Override
    public void retirar(int numero, double retiro) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero() == numero) {
                cuenta.setSaldo(cuenta.getSaldo() - retiro);
                break;
            }
        }
    }

    @Override
    public ArrayList<Cuenta> obtenerCuentas() {
        return cuentas;
    }
}


