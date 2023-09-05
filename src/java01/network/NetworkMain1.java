package java01.network;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 네트워킹이란 두 대 이상의 컴퓨터를 케이블로 연결하여 네트워크를 구성하는 것을 말한다
 * @see java.net
 *
 * 클라이언트/서버 (client/server) 는 컴퓨터간의 관계를 역할로 구분하는 개념
 * 서버 : 서비스를 제공하는 컴퓨터 service provider
 * 클라이언트 : 서비스를 사용하는 컴퓨터 service user
 * 서버가 클라이언트로부터 요청받은 작업을 처리하여 결과를 제공
 *
 * 서비스 종류에 따라 파일서버, 메일서버, 어플리케이션 서버 등이 있다
 *
 * 네트워크를 구성할 때 전용 서버를 두는 것을 서버기반모델(server based model)
 * - 장점 : 안정적인 서비스 제공, 공유 데이터의 관리와 보안 용이
 * - 단점 : 서버 구축 비용과 관리비용
 * 별도의 전용 서버없이 각 클라이언트가 서버 역할을 동시에 수행하는 것을 P2P 모델(peer to peer)
 * - 장점 : 서버 구축 비용 및 운용 비용 절감, 자원의 활용 극대화
 * - 단점 : 자원 관리가 어려움, 보안 취약
 *
 * ############################################################
 *
 * IP 주소는 컴퓨터(호스트 host)를 구별하는데 사용되는 고유한 값
 * 4btye(32bit) 의 정수로 구성되어 있으며, 4개의 정수가 마침표를 구분자로 표시
 * IP 주소는 네트워크 주소와 호스트 주소로 나눌 수 있는데, 4byte(32bit)의 IP주소 중에서 네트워크 주소와 호스트 주소가 각각 몇 bit 를 차지하는 지는 네트워크 구성에 따라 달라짐
 * 2진수 표기
 * ex) 255.255.255.255 -> 11111111.11111111.11111111.11111111
 *
 */
public class NetworkMain1 {

    public static void main(String[] args) {
        // TODO 1 IP 다루는 클래스
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName : " + ip.getHostName());
            System.out.println("getHostAddress : " + ip.getHostAddress());
            System.out.println("toString : " + ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress : " + Arrays.toString(ipAddr));

            String result = "";
            for(int i = 0; i < ipAddr.length; i++){
                result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
                result += ".";
            }
            System.out.println("getAddress + 256 : " + result);
            System.out.println("##################################");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("getHostName : " + ip.getHostName());
            System.out.println("getHostAddress : " + ip.getHostAddress());
            System.out.println("##################################");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");
            for(int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr[" + i + "] : " + ipArr[i]);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


    }

}
