package lopreiato.it;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        
        System.out.println("Il server è partito!");
        
        ServerSocket ss1 = new ServerSocket(3000);

        do {
            Socket s1 = ss1.accept();
            System.out.println("Qualcuno si è collegato");
            MyThread mt = new MyThread(s1);
            mt.start();
        } while (true);
    }
}