import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer {
    private static int port = 12345;

    // crear el main
    public static void main(String[] args) {
        try {
            // obrir el port
            ServerSocket ss = new ServerSocket(port);
            Socket entrada = ss.accept();
            // crear el DIS
            InputStream is = entrada.getInputStream();
            DataInputStream dis = new DataInputStream(is);

//            llegir un enter (2 variants)
//            int i = dis.readInt();
//            System.out.println ("El nombre enter és " +  i);

            byte b3 = dis.readByte();
            byte b2 = dis.readByte();
            byte b1 = dis.readByte();
            byte b0 = dis.readByte();
            System.out.println("Bytes de l'enter: " + b3 + " " + b2 + " " + b1 + " " + b0);

//            llegir un double
            double d = dis.readDouble();
            System.out.println("El nombre real és " + d);

//            llegir un boolean (2 variants)
            // boolean b = dis.readBoolean();
            // System.out.println ("El booleà és " +  b);
            byte b = dis.readByte();
            System.out.println("El byte del booleà és " + b);

            // llegir l'String (2 variants)
            // pintar-lo per pantalla
//            System.out.println(dis.readUTF());

            short mida = dis.readShort();
            System.out.println("La mida del text és " + mida);
            for (int i = 0; i < mida; i++) {
                byte c = dis.readByte();
                System.out.print((char) c);
            }
            System.out.println();

//            tancament de canals
            dis.close();
            entrada.close();
            ss.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
