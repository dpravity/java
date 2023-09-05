package java01.network.multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TcpIPMultichatServer {
    HashMap clients;

    public TcpIPMultichatServer() {
        clients = new HashMap<>();
        Collections.synchronizedMap(clients);
    }

    public void start(){
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // 서버 소켓을 생성하여 7777번 포트와 결합(bind) 시킨다
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 시작되었습니다.");

            while(true){
                socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서 접속하였습니다.");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static String getTime() {
        return LocalDateTime.now().toString();
    }

    private void sendToAll(String msg) {
        Iterator it = clients.keySet().iterator();

        while (it.hasNext()){
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            }catch (IOException e){}
        }
    }

    public static void main(String[] args) {
        new TcpIPMultichatServer().start();
    }

    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        public ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            }catch (IOException e){}
        }

        @Override
        public void run() {
            String name = "";
            try {
                name = in.readUTF();
                sendToAll("#" + name + " 님이 들어오셨습니다.");

                clients.put(name, out);
                System.out.println("현재 서버 접속자 수는 " + clients.size() + "입니다.");

                while (in != null){
                    sendToAll(in.readUTF());
                }
            }catch (IOException e){
                // ignore
            }finally {
                sendToAll("#" + name + " 님이 나가셨습니다.");
                clients.remove(name);
                System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
            }
        }
    }

}




