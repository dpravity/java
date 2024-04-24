package programmers.level2.greedy;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42860
 *
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 *
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 *
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
 * 예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
 *
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 *
 * 제한 사항
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 *
 * 입출력 예
 * name	    return
 * "JEROEN"	56
 * "JAN"	23
 */
public class Joystick {
    public static void main(String[] args) {
        String name = "JAN";
//        System.out.println((byte)'A');
//        System.out.println((byte)'A' - 'A');
//        System.out.println((byte)'Z' - 'A' + 1);
//        System.out.println((byte)'Z' - 'A' + 1);
        System.out.println(solution1(name));
    }

    /**
     * index == 0인 상태를 기준으로 (커서가 처음 위치하는 부분) 좌우조작의 2, 3번 경우 중 최솟값을 따져본다.
     *
     * ex) 'ZYXAAAAAB'인 경우
     * 현재 내 위치는 'X', index : 2 연속된 'A'가 끝나는 지점은 index : 8에 해당한다.
     * [1]   index : 0에서 'X'가 있는 2까지 왔다가 다시 0으로 돌아간 후, 왼쪽으로 더 움직여 B를 바꾸는 경우
     *        즉, ZYXYZB순으로 움직인 경우
     *        (i * 2) + (name.length() - 연속된 A가 끝나는 지점)
     *        여기서 i는 현재 내 위치, 즉 'X'의 index이다.
     * [2]  index : 0에서 왼쪽으로 움직였다 다시 0으로 온 후, 오른쪽으로 움직인 경우
     *        즉, ZBZYX순으로 움직인 경우
     *       (name.length() - 연속된 A가 끝나는 지점) * 2 + i
     * 좌, 우 커서위치 조정하기의 2번, 3번에 해당하는 경우들을 위와 같이 공식으로 만들었다.
     *
     * 이제 다 왔다! 1번에 해당하는 name.length() - 1 값을 초기 좌우 커서 이동 횟수로 넣어두고,
     *
     * 2번과 3번의 로직과 비교하여 최솟값을 넣게 되면 끝
     */
    public static int solution1(String name) {
        int answer = 0;
        int index = 0;
        int length = name.length();
        int move = length - 1;

        for(int i = 0; i < length; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            // 연속되는 A 횟수
            index = i + 1;
            while (index < length && name.charAt(index) == 'A'){
                index++;
            }

            // 이동거리
            // 오른쪽으로 갔다 다시 왼쪽으로 꺾기, 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - index);
            // 왼쪽으로 갔다 다시 오른쪽으로 꺾기, BBBBAAAAAAAB와 같이 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우도 고려
            move = Math.min(move, (length - index) * 2 + i);
            // 위 계산과 동일
            // move = Math.min(move, i + length - index + Math.min(i, length - index));
        }

        return answer + move;
    }

}
