package java01.network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URLConnection 은 어플리케이션과 URL 간의 통신연결을 나타내는 클래스의 최상위 클래스
 */
public class NetworkMain3 {

    public static void main(String[] args) {
        URL url = null;
        String address = "http://www.codechobo.com/post/free/list";

        try {
            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn.toString() : " + conn);
            System.out.println("getAllowUserInteraction() : " + conn.getAllowUserInteraction());
            System.out.println("getConnectTimeout() : " + conn.getConnectTimeout());
            System.out.println("getContent() : " + conn.getContent());
            System.out.println("getContentEncoding() : " + conn.getContentEncoding());
            System.out.println("getContentLength() : " + conn.getContentLength());
            System.out.println("getContentType() : " + conn.getContentType());
            System.out.println("getDate() : " + conn.getDate());
            System.out.println("getDefaultUseCaches() : " + conn.getDefaultUseCaches());
            System.out.println("getDoInput() : " + conn.getDoInput());
            System.out.println("getExpiration() : " + conn.getExpiration());
            System.out.println("getHeaderFields() : " + conn.getHeaderFields());
            System.out.println("getIfModifiedSince() : " + conn.getIfModifiedSince());
            System.out.println("getLastModified() : " + conn.getLastModified());
            System.out.println("getReadTimeout() : " + conn.getReadTimeout());
            System.out.println("getURL() : " + conn.getURL());
            System.out.println("getUseCaches() : " + conn.getUseCaches());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
