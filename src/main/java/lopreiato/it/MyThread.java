package lopreiato.it;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class MyThread extends Thread {
    private Socket s;

    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            Random random = new Random();
            int numero = random.nextInt(100);

            int contatore = 0;
            do {
                contatore++;
                String s = in.readLine();

                int tentativo = Integer.parseInt(s);

                String risultato ="";

                if (tentativo < numero) {
                    risultato = "TOO_LOW";
                    System.out.println(risultato);
                    out.writeBytes(risultato + "\n");
                } else if (tentativo > numero) {
                    risultato = "TOO_HIGH";
                    System.out.println(risultato);
                    out.writeBytes(risultato + "\n");
                } else if (tentativo == numero) {
                    risultato = "CORRECT";
                    System.out.println(risultato);
                    out.writeBytes(risultato + "\n");
                    System.out.println("tentativi: " + contatore + "\n");
                }
            } while (true);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
