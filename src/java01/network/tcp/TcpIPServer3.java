package java01.network.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;

public class TcpIPServer3 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // 서버 소켓을 생성하여 7777번 포트와 결합(bind) 시킨다
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime() + " 서버가 준비되었습니다.");
        }catch (IOException e){
            e.printStackTrace();
        }

        while (true){
            try {
                System.out.println(getTime() + " 연결 요청을 기다립니다.");
                // 요청대기시간을 5초로 설정
                // 5초 동안 접속 요청이 없으면 SocketTimeoutException 발생
                serverSocket.setSoTimeout(5 * 1000);
                // 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다
                // 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");
                System.out.println("getPort() : " + socket.getPort());  // 연결 요청한 클라이언트 소켓 포트
                System.out.println("getLocalPort() : " + socket.getLocalPort());    // 서버 포트

                // 소켓의 출력 스트림을 얻는다
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓 (remote socket) 에 데이터를 보낸다
                dos.writeUTF("[NOTICE] Test Message 1 from Server.");
                System.out.println(getTime() + " 데이터를 전송했습니다.");

                // 스트림과 소켓을 닫는다
                dos.close();
                socket.close();
            }catch (SocketTimeoutException soe){
                System.out.println("지정된 시간동안 접속 요청이 없어서 서버를 종료합니다.");
                System.exit(0);
            }catch (IOException e){
                e.printStackTrace();
            }
        } // end while


    }

    private static String getTime() {
        return LocalDateTime.now().toString();
    }

}
