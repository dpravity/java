package programmers.level2.exhaustivesearch;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 *
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow 가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 갈색 격자의 수 brown 은 8 이상 5,000 이하인 자연수입니다.
 * 노란색 격자의 수 yellow 는 1 이상 2,000,000 이하인 자연수입니다.
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 *
 * 입출력 예
 * brown	yellow	return
 * 10	    2	    [4, 3]
 * 8	    1	    [3, 3]
 * 24	    24	    [8, 6]
 *
 * Hint
 * 가로x, 세로y 라고 하면, 식 2개
 * - yellow box = (x-2) * (y-2)
 * - brown box = x * y - yellow box 수 = brown box 수
 */
public class Carpet {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution1(brown, yellow)));
        System.out.println(Arrays.toString(solution4(brown, yellow)));
    }
    public static int[] solution1(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        for(int width = 3; width <= sum; width++){
            if(sum % width == 0){
                int vertical = sum / width;
//                int center = width * vertical - (width + vertical - 2) * 2;
                // 노란색 박스는 가로 위아래 한줄씩 -2 * 세로 위아래 한줄씩 -2
                int yellowBox = (width - 2) * (vertical - 2);
                if(yellowBox == yellow){
                    answer[0] = vertical;
                    answer[1] = width;
                    return answer;
                }
            }
        }

        return answer;
    }

    public static int[] solution2(int brown, int yellow) {
        for(int width = 3; width <= 5000; width++){
            for(int height = 3; height <= width; height++){
                int boundary = (width + height - 2) * 2;
                int center = width * height - boundary;

                if(brown == boundary && yellow == center){
                    return new int[] {width, height};
                }
            }
        }
        return null;
    }

    /**
     * a는 완성된 카펫의 가로+세로입니다.
     * b는 왜 저런식으로 써 놓으셨는진 모르겠지만 그냥 주어진 타일의 개수를 모두 합친 값입니다.
     * 궁극적으로 answer 안에서 값을 구하는 방법을 기하학 적으로 보자면 우선 카펫의 가로 + 세로, 즉 a를 한변으로 하는 정사각형을 만든 후,
     * 카펫모양으로 정사각형의 네 귀퉁이를 잘라내면, 즉 - 4 * b를 하면 가운데에 정사각형 형태의 타일이 남습니다.
     * 루트를 이용하여 그 정사각형의 한 변의 길이를 구해주는데 그 한 변의 길이가 완성된 카펫의 가로와 세로의 길이 차이가 됩니다.
     * 그러므로 더 긴쪽, 즉 가로를 구하기 위해선 가로와 새로를 더한 값에 차이를 더해주고 2로 나누고, 짧은 쪽을 구하기 위해선 빼고 2로 나눠주면 됩니다
     * @param brown
     * @param yellow
     * @return
     */
    public static int[] solution3(int brown, int yellow) {
        int a = (brown + 4) / 2;
        int b = yellow + 2 * a - 4;
        int[] answer = {(int)(a + Math.sqrt(a * a - 4 * b)) / 2, (int)(a - Math.sqrt(a * a - 4 * b)) / 2};
        return answer;
    }

    //#region - practice
    public static int[] solution4(int brown, int yellow) {
        // 가로, 세로 크기 계산
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int w = 3; w <= sum; w++){
            if(sum % w == 0){
                int h = sum / w;
                int yellowBox = (w - 2) * (h - 2);
                if(yellowBox == yellow){
                    answer[0] = h;
                    answer[1] = w;
                    return answer;
                }
            }
        }
        return answer;
    }
    //#endregion - practice

}
