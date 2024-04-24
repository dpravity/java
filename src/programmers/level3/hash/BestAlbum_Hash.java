package programmers.level3.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 *
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres 와 노래별 재생 횟수를 나타내는 정수 배열 plays 가 주어질 때,
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres 와 plays 의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 *
 * 입출력 예
 * genres	                                        plays	                    return
 * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 *
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 *
 * 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.
 */
public class BestAlbum_Hash {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution1(genres, plays)));
    }
    public static int[] solution1(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수
        LinkedHashMap<String, Integer> scoreMap = new LinkedHashMap<>();
        for(int i = 0; i < genres.length; i++){
            scoreMap.put(genres[i], scoreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르별 인덱스, 재생 횟수
        LinkedHashMap<String, ArrayList<Song>> genresMap = new LinkedHashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(genresMap.get(genres[i]) == null){
                ArrayList<Song> indexList = new ArrayList<>();
                indexList.add(new Song(i, plays[i]));
                genresMap.put(genres[i], indexList);
            }else{
                genresMap.get(genres[i]).add(new Song(i, plays[i]));
            }
        }

        // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        ArrayList<String> genresList = new ArrayList<>(scoreMap.keySet());
        // 장르 스코어 내림차순 정렬
        genresList.sort((s1, s2) -> scoreMap.get(s2).compareTo(scoreMap.get(s1)));

        // 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호(인덱스) 가 낮은 노래를 먼저 수록합니다.
        // 장르별로 2 개 씩, 1개의 장르는 1 개만
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < genresList.size(); i++){
            // 장르 이름
            String name = genresList.get(i);
            // 사이즈
            int size = genresMap.get(name).size();
            // 장르 음악 플레이순 내림차순 정렬
            Collections.sort(genresMap.get(name), Collections.reverseOrder());

            for(int j = 0; j < size; j++){
                if(j == 2){
                    break;
                }
                resultList.add(genresMap.get(name).get(j).index);
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Song implements Comparable<Song> {
        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            return (this.play < o.play ? -1 : (this.play == o.play ? 0 : 1));
        }
    }
}
