package co.com.bancolombia.practicas.services;

import co.com.bancolombia.practicas.entities.Cliente;

import java.util.TreeSet;

public interface ServicioClientes {
    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numero);
    Cliente consultarCliente(int numero);
    TreeSet<Cliente> obtenerClientes();
    Cliente buscarClientePorRFC(String rfc);
}
