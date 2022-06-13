package multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private int port;
    private String ip;
    private Scanner scanner;
    BufferedReader reader;

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя");
        String name = reader.readLine();
        System.out.println("Чат начался");
        Connection connection = new Connection(getSocket());

        Thread sender = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String messageText = reader.readLine();
                    if (messageText.equalsIgnoreCase("exit")||messageText.equalsIgnoreCase("/exit")) {
                        connection.close();
                        Thread.currentThread().interrupt();
                        break;
                    }
                    connection.sendMessage(SimpleMessage.getMessage(name, messageText));
                    System.out.println(" ");
                }
            } catch (Exception e) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                e.printStackTrace();
            }
        });
        Thread getter = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    SimpleMessage fromServer = connection.readMessage();
                    System.out.println(fromServer);
                }
            } catch (IOException | ClassNotFoundException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });
        sender.start();
        getter.start();
    }
    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }
    public static void main(String[] args) {
        int port = 8090;
        String ip = "127.0.0.1";
        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
