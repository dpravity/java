package java01.algorithm.codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Destroying Bridges
 * https://codeforces.com/problemset/problem/1944/A
 * 섬, 번호가 매겨져 있음 1 , 2 , … , 𝑛
 * 처음에는 모든 쌍의 섬이 다리로 연결되어 있습니다. 따라서 총 𝑛(𝑛−1)/2 교량.
 * 에버룰은 섬에 산다 1번 다리를 이용하여 다른 섬을 방문하는 것을 즐깁니다.
 * 도미네이터는 기껏해야 파괴할 수 있는 힘을 가지고 있습니다.
 * 𝑘 에버룰이 (아마도 여러 개의) 다리를 사용하여 도달할 수 있는 섬의 수를 최소화하기 위한 다리입니다.
 * 섬의 최소 수를 구합니다(섬 포함).
 * 1) Dominator가 최적으로 다리를 파괴하면 Everule이 방문할 수 있습니다.
 * 알고리즘 : graph, greedy, math
 *
 * 입력
 * 각 테스트에는 여러 테스트 사례가 포함되어 있습니다. 첫 번째 줄에는 단일 정수 t 가 포함됩니다.
 * (1 <= t <= 10의 3승) — 테스트 사례의 수입니다. 테스트 케이스에 대한 설명은 다음과 같습니다.
 * 각 테스트 케이스의 첫 번째이자 유일한 줄에는 두 개의 정수가 포함됩니다. 𝑛 그리고 𝑘
 * (1 <= 𝑛 <= 100, 0 <= 𝑘 <= 𝑛 * ( 𝑛 − 1 ) / 2)
 *
 * ex)
 * [input]
 * 6
 * 2 0
 * 2 1
 * 4 1
 * 4 10
 * 5 3
 * 4 4
 * [output]
 * 2
 * 1
 * 4
 * 1
 * 5
 * 1
 *
 * c++ ex)
 *  int t,n,k;
 *     for(std::cin>>t;t--;){
 *     std::cin>>n>>k;
 *     std::cout<<(k >= n - 1 ? 1 : n)<<"\n";
 * }
 */
public class DestroyingBridges {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {


            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]); // 섬의 수
                int k = Integer.parseInt(input[1]); // 파괴할 수 있는 다리의 수
                System.out.println(k >= n - 1 ? 1 : n);
            }

            int[] arr = {1,2,3};
            for (int i : arr) {
                if(i == 2) {
                    System.out.println("i == 2");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
