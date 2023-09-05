package java01.network.multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIPMultichatClient {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        if(name.isEmpty()){
            System.out.println("USAGE : Java TcpIpMultichatClient 대화명");
            System.exit(0);
        }

        try {
//            String serverIp = "127.0.0.1";
            String serverIp = "10.140.56.220";
            int serverPort = 7777;

            Socket socket = new Socket(serverIp, serverPort);
            System.out.println("서버에 연결되었습니다.");
            Thread sender = new Thread(new ClientSender(socket, name));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        }catch (ConnectException ce){
            ce.printStackTrace();
        }catch (Exception e){
            // ignore
        }
    }

    static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;

        public ClientSender(Socket socket, String name) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                this.name = name;
            }catch (IOException e){

            }
        }

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                if(out != null){
                    out.writeUTF(name);
                }
                while (out != null){
                    out.writeUTF("[" + name + "]" + scanner.nextLine());
                }
            }catch (IOException e){}
        }
    }

    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        public ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            }catch (IOException e){}
        }

        @Override
        public void run() {
            while (in != null){
                try {
                    System.out.println(in.readUTF());
                }catch (IOException e){

                }
            }
        }
    }
}
