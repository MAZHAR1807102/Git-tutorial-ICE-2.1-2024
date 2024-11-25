import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Test {
    public static void main(String[] args) {
        String host = "localhost"; // Server's hostname
        int port = 12345;          // Server's port

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to the server.");

            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send "hi" message to the server
            String message = "hi";
            String date = "22/11/24";
            out.println(message);
            out.println(date);
            System.out.println("Client sent: " + message);
            System.out.println("Client Date: "+ date);

            // Receive response from the server
            String response = in.readLine();
            System.out.println("Server responded: " + response);

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());


            System.out.println("this is from sazzad");
        }
    }
}
