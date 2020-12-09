// Librerías
import java.net.*;
import java.io.*;

/**
 * Clase servidor que aceptará peticiones del clientes de forma concurrente
 * @author Davibern
 * @version 1.0
 */
public class Servidor extends Thread {

    // Atributos de clase
    private static final int PUERTO = 2000;
    private Socket cliente;

    /**
     * Constructor de clase que se inicializa con un objeto de tipo cliente
     * @param cliente Cliente
     */
    public Servidor(Socket cliente) {
        this.cliente = cliente;
    }

    /**
     * Método que inicia el servidor
     * @param args Sin argumentos
     */
    public static void main(String[] args) {

        try {
            // Se inicia el servidor en el puerto especificado con el atributo
            ServerSocket servidor = new ServerSocket(PUERTO);
            // Se muestra por consola el puerto de escucha
            System.out.println("Escuchando el puerto -> " + PUERTO);

            while(true) {
                // Se conecta el cliente
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado");

                // Se atiende la petición del cliente mediante un hilo de ejecución
                new Servidor(cliente).start();
            }
        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
        }

    }

    @Override
    public void run() {

        try {
            // Se crea los flujos de salida
            DataOutputStream salida = new DataOutputStream(this.cliente.getOutputStream());

            // Atender la petición del cliente
            salida.writeUTF("Conexión realizada correctamente.");

            // Se cierra la conexión
            this.cliente.close();
            System.out.println("Cliente cerrado correctamente.");
        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
        }

    }

}
