import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer {
    // crear el main
    public static void main(String[] args){
        System.out.println("Soc el server");

        try {
            // obrir el port
            ServerSocket ss = new ServerSocket(12345);
            Socket entrada = ss.accept();
            // crear el DIS
            InputStream is = entrada.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            // llegir l'String
            // pintar-lo per pantalla
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
