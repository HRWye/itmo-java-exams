package multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class EchoServer {
    public EchoServer(int port) {
        this.port = port;
    }

    private int port;
    private ArrayBlockingQueue<SimpleMessage> blockingQueue = new ArrayBlockingQueue<>(10, true);
    private CopyOnWriteArrayList<Connection> connections = new CopyOnWriteArrayList<>();


    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен...");
            SendToClients sendToClients = new SendToClients();
            sendToClients.start();
            while (true) {
                Socket socket = serverSocket.accept();
                Clients clients = new Clients(socket);
                clients.start();
            }
        }
    }

    class Clients extends Thread {
        private Connection connection;
        private long id;

        public Clients(Socket socket) throws IOException {
            this.connection = new Connection(socket);
        }

        @Override
        public void run() {
            id = Thread.currentThread().getId();
            connection.setId(id);
            connections.add(connection);
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    SimpleMessage message = connection.readMessage();
                    message.setId(id);
                    printMessage(message);
                    blockingQueue.add(message);
                } catch (IOException | ClassNotFoundException e) {
                    connections.remove(connection);
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " interrupted");

                }
            }
        }
    }

    class SendToClients extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                SimpleMessage message;
                try {
                    message = blockingQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (Connection currentConnection : connections) {
                    try {
                        if (currentConnection.getId() != message.getId()) {
                            currentConnection.sendMessage(message);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void printMessage(SimpleMessage message) {
        System.out.println("Поступило сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8090;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
