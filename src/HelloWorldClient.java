import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HelloWorldClient {
    public static void main(String[] args) {
        // check java version
        String javaVersion = System.getProperty("java.version");
        System.out.println("Versión de Java: " + javaVersion);

        String host = "localhost";
        int port = 12345;

//        host address from args
        if (args.length > 0) {
            host = args[0];
        }

        try {
            Socket s = new Socket(host, port);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

//            sending different data types
            dos.writeInt (123456);
            dos.writeDouble (3.141592653589793);
            dos.writeBoolean (true);
            dos.writeUTF ("Hellow world!");

            System.out.println("Tot enviat.");
            dos.flush();
            dos.close();
            s.close();

        }catch (Exception e){
            System.out.println("Ha ocorregut un error i paro");
            e.printStackTrace();
        }
    }
}