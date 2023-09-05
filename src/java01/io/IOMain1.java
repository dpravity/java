package java01.io;

import java.io.*;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * I/O 에서의 스트림
 * 1. 입출력에서 스트림은 데이터를 운반하는데 사용되는 연결 통로
 * 2. 스트림은 단방향 통신만 가능하기 때문에 하나의 스트림으로 입력과 출력을 동시에 처리할 수 없다
 * 3. 스트림은 먼저 보낸 데이터를 먼저 받게 되어있으며 (FIFO 선입선출) 건너뜀 없이 연속적으로 데이터를 주고 받는다
 * 4. 스트림은 바이트 단위로 데이터를 전송하며 입출력 종류에 따라 그에 맞는 입출력 스트림을 사용한다
 *
 * 입력 : Input
 * - read
 * 출력 : Output
 * - write
 * 종류
 * - File / IO / Stream : 파일
 * - Byte / IO / Stream : byte 계열 메모리
 * - Piped / IO / Stream : 프로세스
 * - Audio / IO / Stream : 오디오 장치
 *
 * 보조 스트림
 * 1. 스트림 기능을 보완하기 위해 제공된 스트림
 * 2. 실제 데이터를 주고받는 스트림이 아니지만 스트림의 기능을 향상 시키거나 새로운 기능을 추가할 수 있다
 * 3. 스트림을 먼저 생성한 후 이를 사용하여 보조 스트림을 생성해야 한다
 *
 * 종류
 * - Filter / IO / Stream : 필터를 이용한 입출력 처리
 * - Buffered / IO / Stream : 버퍼를 이용한 입출력 성능 향상
 * - Data / IO / Stream : int, float 과 같은 기본형 단위로 데이터를 처리
 * - Sequence / I / Stream : 두 개의 스트림을 하나로 연결
 * - LineNumber / I / Stream : 읽어온 데이터의 라인 번호를 카운트
 * - Object / IO / Stream : 데이터를 객체 단위로 읽고 쓰기
 * - Print / O / Stream : 버퍼를 이용한 추가적인 print 기능
 * - Pushback / I / Stream : 버퍼를 이용하여 읽어온 데이터를 다시 되돌리는 기능
 *
 * byte 기반 스트림 2byte -> 자바는 4byte 이므로 보조 스트림을 활용한 성능 향상
 */
public class IOMain1 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/dpravity/Downloads/test.txt");
        fileIOStream(file);
        fileReaderStream(file);
//        fileOutputStream(file);
        switch ("a"){
            case "b":
                break;
            case "DDDD":
                // fall throws
            default:
                break;
        }
    }

    public static void fileIOStream(File file) throws IOException {
        // 바이트 기반(2byte) 스트림
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        StringBuilder sb = new StringBuilder();

        while (bis.available() > 0) {
            sb.append((char) bis.read());
        }

        System.out.println(sb.toString());;
    }

    public static void fileReaderStream(File file) throws IOException {
        FileReader fr = new FileReader (file);
        int data = 0;
        // 더 이상 읽을 데이터가 없을 때까지 데이터를 읽고 출력하는 작업 반복
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
        }
        // 입력 스트림 종료
        fr.close();
    }
    public static void fileOutputStream(File file) throws IOException {
        try(FileOutputStream fo = new FileOutputStream(file)){
            fo.write(65);
            fo.write(66);
            fo.write(67);
        }catch (IOException e){
            System.out.println(e);
        }
        System.out.println("create file");
    }



}
