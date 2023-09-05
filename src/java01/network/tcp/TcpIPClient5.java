package java01.network.tcp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIPClient5 {

    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";  // localhost 가상아이피
            System.out.println("서버에 연결중입니다. 서버 IP : " + serverIp);
            // 소켓 생성하여 연결을 요청한다
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결되었습니다.");

            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        }catch (ConnectException ce){
            ce.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
