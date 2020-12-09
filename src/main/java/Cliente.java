// Librerías
import java.io.*;
import java.net.*;

/**
 * Clase cliente que conectará con el servidor
 * @author Davibern
 * @version 1.0
 */
public class Cliente {

    // Atributos
    private static final String HOST = "localhost";
    private static final int PUERTO = 2000;

    /**
     * Constructor de clase
     */
    public Cliente() {

        try {
            // Se crea un nuevo cliente que conectará al host y puerto especificado
            Socket cliente = new Socket(HOST, PUERTO);

            // Se crean los flujos de entrada de información procedente del servidor si lo hubiera
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

            // Tareas que realiza el cliente
            String datos = flujoEntrada.readUTF();
            System.out.println(datos);

            // Cerrar el cliente
            cliente.close();
        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
        }

    }

    /**
     * Método que lanza el cliente
     * @param args Sin argumentos
     */
    public static void main(String[] args) {
        new Cliente();
    }

}
