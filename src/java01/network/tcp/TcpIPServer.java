package java01.network.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * TCP 소켓 프로그래밍
 * 클라이언트 - 서버 1:1 통신
 * 서버 : 클라이언트의 연결 요청을 기다림
 * 1. 서버는 서버 소켓을 사용해서 서버 컴퓨터의 특정 포트에서 클라이언트의 연결 요청을 처리할 준비를 한다
 * 2. 클라이언트는 접속할 서버의 IP 주소와 포트 정보를 가지고 소켓을 생성해서 서버에 연결을 요청한다
 * 3. 서버 소켓은 클라이언트의 연결 요청을 받으면 서버에 새로운 소켓을 생성해서 클라이언트의 소켓과 연결되도록 한다
 * 4. 클라이언트의 소켓과 새로 생성된 서버의 소켓은 서버 소켓과 관계없이 일대일 통신을 한다
 *
 * 서버 소켓은 포트와 결합(bind) 되어 포트를 통해 원격 사용자의 연결 요청을 기다리다가
 * 연결 요청이 올 때마다 새로운 소켓을 생성하여 상대편 소켓과 통신할 수 있도록 연결한다
 * 실제 데이터 통신은 서버 소켓과 관계없이 소켓과 소켓 간에 이루어진다
 * * 서버 소켓은 포트를 독점
 *
 * 연결 후 통신 ex) 전화기, 1:1 통신
 * 데이터의 경계를 구분하지 않음 (byte-stream)
 * 신뢰성 있는 데이터 전송
 * - 데이터 전송 순서 보장
 * - 데이터 수신 여부 확인 (데이터 손실 시 재전송)
 * - 패킷 관리할 필요 없음
 * UDP 보다 전송 속도 느림
 *
 */
public class TcpIPServer {

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
                // 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다
                // 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + " 로부터 연결요청이 들어왔습니다.");

                // 소켓의 출력 스트림을 얻는다
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                // 원격 소켓 (remote socket) 에 데이터를 보낸다
                dos.writeUTF("[NOTICE] Test Message 1 from Server.");
                System.out.println(getTime() + " 데이터를 전송했습니다.");

                // 스트림과 소켓을 닫는다
                dos.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        } // end while


    }

    private static String getTime() {
        return LocalDateTime.now().toString();
    }

}
