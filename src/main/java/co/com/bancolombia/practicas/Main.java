package co.com.bancolombia.practicas;

import co.com.bancolombia.practicas.entities.*;
import co.com.bancolombia.practicas.services.servicesImp.ServicioClientesImpl;
import co.com.bancolombia.practicas.services.servicesImp.ServicioCuentasImpl;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "Cliente 1", new Domicilio("Calle 1", 123, "Colonia A", "Estado X", "Pais F", 051050), "RFC1", "555-1234", LocalDate.of(1990, 1, 1));
        Cliente cliente2 = new Cliente(2, "Cliente 2", new Domicilio("Calle 2", 456, "Colonia B", "Estado Y", "Pais G", 051053), "RFC2", "555-5678", LocalDate.of(1990, 2, 2 ));
        Cliente cliente3 = new Cliente(3, "Cliente 3", new Domicilio("Calle 3", 789, "Colonia C", "Estado Z", "Pais H", 051055), "RFC3", "555-9999", LocalDate.of(1990, 3, 3));

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\elaba\\Documents\\JavaDevBanco\\Hola.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line, cliente1, cliente2, cliente3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Validar que cada cliente tenga sus respectivas cuentas
        validateClientes(cliente1, cliente2, cliente3);
    }

    private static void processLine(String line, Cliente cliente1, Cliente cliente2, Cliente cliente3) {
        System.out.println("Processing line: " + line);
        line = line.trim();
        if (line.startsWith("CA") || line.startsWith("CC")) {
            String[] parts = line.substring(3, line.length() - 1).split(",\\s*");
            int numeroCuenta = Integer.parseInt(parts[0].trim());
            LocalDate fechaApertura = LocalDate.parse(parts[1].trim(),  DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            double saldo = Double.parseDouble(parts[2].trim());
            double extra = Double.parseDouble(parts[3].trim());
            int numeroCliente = Integer.parseInt(parts[4].trim());

            Cuenta cuenta = null;
            if (line.startsWith("CA")) {
                cuenta = new CuentaAhorro(numeroCuenta, fechaApertura, saldo, extra);
            } else if (line.startsWith("CC")) {
                cuenta = new CuentaCheque(numeroCuenta, fechaApertura, saldo, extra);
            }

            if (cuenta != null) {
                switch (numeroCliente) {
                    case 1:
                        cliente1.getCuentas().add(cuenta);
                        break;
                    case 2:
                        cliente2.getCuentas().add(cuenta);
                        break;
                    case 3:
                        cliente3.getCuentas().add(cuenta);
                        break;
                }
            }
            // Debugging: Print the parsed and assigned cuenta information
            System.out.println("Parsed cuenta: " + cuenta + " assigned to cliente: " + numeroCliente);
        }
    }

    private static void validateClientes(Cliente cliente1, Cliente cliente2, Cliente cliente3) {
        if (cliente1.getCuentas().size() == 1) {
            System.out.println("Cliente 1 tiene 1 cuenta");
        } else {
            System.out.println("Error: Cliente 1 tiene " + cliente1.getCuentas().size() + " cuentas");
        }

        if (cliente2.getCuentas().size() == 2) {
            System.out.println("Cliente 2 tiene 2 cuentas");
        } else {
            System.out.println("Error: Cliente 2 tiene " + cliente2.getCuentas().size() + " cuentas");
        }

        if (cliente3.getCuentas().size() == 2) {
            System.out.println("Cliente 3 tiene 2 cuentas");
        } else {
            System.out.println("Error: Cliente 3 tiene " + cliente3.getCuentas().size() + " cuentas");
        }
    }
}




