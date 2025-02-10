import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HelloWorldClient {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String javaVersion = System.getProperty("java.version");
        System.out.println("Versión de Java: " + javaVersion);

        String host = "localhost";
        int port = 12345;

        try {
            Socket s = new Socket(host, port);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            dos.writeUTF("hellow");
            s.close();

        }catch (Exception e){
            System.out.println("Ha ocorregut un error i paro");
            System.out.println(e);
        }
    }
}