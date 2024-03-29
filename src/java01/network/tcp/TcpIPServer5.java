package java01.network.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TcpIPServer5 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 서버 소켓을 생성하여 7777번 포트와 결합(bind) 시킨다
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " 서버가 준비되었습니다.");

            socket = serverSocket.accept();

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String getTime() {
        return LocalDateTime.now().toString();
    }

}

class Sender extends Thread {
    Socket socket;
    DataOutputStream out;
    String name;

    Sender(Socket socket){
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            name = "[" + socket.getInetAddress() + " : " + socket.getPort() + "]";
        }catch (IOException e){}
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (out != null){
            try {
                out.writeUTF(name + scanner.nextLine());
            }catch (IOException e){}
        }
    }
}

class Receiver extends Thread {
    Socket socket;
    DataInputStream in;

    Receiver(Socket socket){
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
        }catch (IOException e){}
    }

    @Override
    public void run() {
        while(in != null){
            try {
                System.out.println(in.readUTF());
            }catch (IOException e){}
        }
    }
}