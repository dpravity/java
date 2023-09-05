package java01.network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * URL (Uniform Resource Location)
 * 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조
 * ex) https://www.naver.com/board/test.html?page=1#content
 * * URL 에서 default 포트번호, 쿼리, 참조는 생략할 수 있다
 * 프로토콜 : 자원에 접근하기 위해 서버와 통신하는데 사용되는 통신 규약(http)
 * 호스트명 : 자원을 제공하는 서버의 이름 (www.naver.com)
 * 포트번호 : 통신에 사용되는 서버의 포트번호(80,443)
 * 경로명 : 접근하려는 자원이 저장된 서버상의 위치(/board/)
 * 파일명 : 접근하려는 자원의 이름 (test.html)
 * 쿼리(query) : URL 에서 ? 이후의 부분 (page=1)
 * 참조(anchor) : URL 에서 # 이후의 부분 (content)
 */
public class NetworkMain2 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url1 = new URL("http://www.codechobo.com/post/free/list");
//        URL url3 = new URL("http", "www.codechobo.com", 80, "/post/free/list");

        System.out.println("url1.getAuthority() : " + url1.getAuthority());
        System.out.println("url1.getContent() : " + url1.getContent());
        System.out.println("url1.getDefaultPort() : " + url1.getDefaultPort());
        System.out.println("url1.getPort() : " + url1.getPort());
        System.out.println("url1.getFile() : " + url1.getFile());
        System.out.println("url1.getHost() : " + url1.getHost());
        System.out.println("url1.getPath() : " + url1.getPath());
        System.out.println("url1.getProtocol() : " + url1.getProtocol());
        System.out.println("url1.getQuery() : " + url1.getQuery());
        System.out.println("url1.getRef() : " + url1.getRef());
        System.out.println("url1.getUserInfo() : " + url1.getUserInfo());
        System.out.println("url1.toExternalForm() : " + url1.toExternalForm());
        System.out.println("url1.toURI() : " + url1.toURI());

    }

}
