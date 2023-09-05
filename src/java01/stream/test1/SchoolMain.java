package java01.stream.test1;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class SchoolMain {

    public static void main(String[] args) throws IOException {
        List<School> list = makeData();
//        list.stream().sorted(Comparator.comparing(School::getSchoolName)
//                .thenComparing(School::getSchoolCategory));
//        streamForEach(list);
//        streamPredicate(list);
//        streamMap(list);
        streamParallel();
    }

    public static void streamForEach(List<School> list){
        list.stream().forEach(school -> System.out.println(school));
    }

    public static void streamPredicate(List<School> list){
        Predicate<String> p = o -> o.equals("가락중학교");
        list.stream().filter(school -> p.test(school.getSchoolName())).forEach(System.out::println);
    }

    public static void streamMap(List<School> list){
        Function<School, String> f = school -> school.getSchoolName();
        list.stream().map(f).forEach(System.out::println);
    }

    public static void streamParallel(){
        String[] arr = {"1","22","333","4444"};
        List<String> list = Arrays.asList(arr);
//        int sum = list.parallelStream().mapToInt(s -> s.length()).sum();
        int sum = list.parallelStream().mapToInt(String::length).sum();
        System.out.println(sum);
    }


    public static List<School> makeData() {
        String[] str1 = {"B10","서울특별시교육청","7010057","가락고등학교","Garak High School","고등학교","서울특별시","서울특별시교육청","공립","5678","서울특별시 송파구 송이로 42","(송파동/가락고등학교)","02-416-4658","http://garak.sen.hs.kr","남여공학","02-421-9669","일반고","N","일반계","","후기","주간","19881223","19890428","20230205"};
        String[] str2 = {"B10","서울특별시교육청","7130165","가락중학교","Karak Middle School","중학교","서울특별시","서울특별시강동송파교육지원청","공립","5673","서울특별시 송파구 송이로 45","(송파동/가락중학교)","02-2143-3102","http://www.karak.ms.kr","남여공학","02-2143-3119","","N","일반계","","전기","주간","19860129","19860506","20230205"};
        String[] str3 = {"B10","서울특별시교육청","7041164","가산중학교","Gasan Middle School","중학교","서울특별시","서울특별시남부교육지원청","공립","8584","서울특별시 금천구 시흥대로115길 48","(독산동)","02-804-1777","http://www.gasan.ms.kr","남여공학","02-892-8477","","N","일반계","","전기","주간","19700810","19710303","20230205"};
        String[] str4 = {"B10","서울특별시교육청","7130166","가원중학교","Gawon Middle School","중학교","서울특별시","서울특별시강동송파교육지원청","공립","5831","서울특별시 송파구 중대로10길 40-18","(가락동/가원중학교)","02-409-2179","www.gawon.ms.kr","남여공학","02-443-5825","","N","일반계","","전기","주간","19881224","19881224","20230205"};
        String[] str5 = {"B10","서울특별시교육청","7011169","가재울고등학교","Gajaeul High School","고등학교","서울특별시","서울특별시교육청","공립","3709","서울특별시 서대문구 수색로 100-35","(북가좌동)","02-6351-0500","http://www.gajaeul.hs.kr","남여공학","02-307-6605","일반고","N","일반계","","후기","주간","20130301","20130501","20230205"};
        String[] str6 = {"B10","서울특별시교육청","7031261","가재울중학교","Gajaeul Middle School","중학교","서울특별시","서울특별시서부교육지원청","공립","3790","서울특별시 서대문구 수색로 100-75","(북가좌동/ 가재울중학교)","02-726-1700","http://gajaeul.sen.ms.kr","남여공학","02-726-1799","","N","해당없음","","후기","주간","20130301","20130521","20230205"};
        String[] str7 = {"B10","서울특별시교육청","7132123","강남중학교","Gangnam Middle School","중학교","서울특별시","서울특별시동작관악교육지원청","공립","6955","서울특별시 동작구 대방동15길 29","(대방동/ 강남중학교)","02-814-5637","http://www.kangnam.ms.kr","남여공학","02-823-4226","","N","일반계","","전기","주간","19590403","19590403","20230205"};
        String[] str8 = {"B10","서울특별시교육청","7010117","강동고등학교","Kangdong High School","고등학교","서울특별시","서울특별시교육청","사립","5279","서울특별시 강동구 구천면로 572","(상일동)","02-427-0231","http://kangdong.sen.hs.kr","남여공학","02-441-3494","일반고","N","일반계","","후기","주간","19841217","19850908","20230205"};
        String[] str9 = {"B10","서울특별시교육청","7130167","강동중학교","GANGDONG MIDDLE SCHOOL","중학교","서울특별시","서울특별시강동송파교육지원청","공립","5208","서울특별시 강동구 풍산로 237","/ 강동중학교 (강일동)","02-481-1503","http://www.gang-dong.ms.kr","남여공학","02-481-1504","","N","해당없음","","전기","주간","20100301","20100301","20230205"};
        String[] str10 = {"B10","서울특별시교육청","7130168","강명중학교","GANGMYOUNG MIDDLE SCHOOL","중학교","서울특별시","서울특별시강동송파교육지원청","공립","5285","서울특별시 강동구 상일로12길 56","(강일동/ 강명중학교)","02-440-3200","http://www.gangmyoung.ms.kr","남여공학","02-428-7377","","N","해당없음","","전기","주간","20120301","20120506","20230205"};
        String[] str11 = {"B10","서울특별시교육청","7121341","강북중학교","Kangbuk Middle School","중학교","서울특별시","서울특별시성북강북교육지원청","공립","1051","서울특별시 강북구 한천로150길 67","(수유동/ 강북중학교)","02-999-4104","http://www.kangbuk.ms.kr/","남여공학","02-993-3465","","N","일반계","","전기","주간","19801227","19801227","20230205"};
        String[] str12 = {"B10","서울특별시교육청","7130268","강빛중학교","Gangbit middle school","중학교","서울특별시","서울특별시강동송파교육지원청","공립","5201","서울특별시 강동구 아리수로93다길 1","(강일동/ 강빛초중통합학교)","02-6951-3964","http://gbm.sen.ms.kr","남여공학","02-6951-3966","","N","","","전후기","주간","20210301","20210301","20230205"};
        String[] str13 = {"B10","서울특별시교육청","7010118","강서고등학교","Gangseo High School","고등학교","서울특별시","서울특별시교육청","사립","7958","서울특별시 양천구 목동중앙남로 27","/ 강서고등학교 (목동)","02-2642-0725","http://gangseo.sen.hs.kr","남","02-2651-3046","일반고","N","일반계","","후기","주간","19831101","19831101","20230205"};
        String[] str14 = {"B10","서울특별시교육청","7010270","강서공업고등학교","Gangseo Technical High School","고등학교","서울특별시","서울특별시교육청","공립","7514","서울특별시 강서구 방화대로47길 9","(방화동/강서공업고등학교)","02-2666-2106","https://gangseo-th.sen.hs.kr/","남여공학","02-2666-2161","특성화고","N","전문계","","전기","주간","19940105","19940105","20230205"};
        String[] str15 = {"B10","서울특별시교육청","7081484","강신중학교","Kangsin Middle School","중학교","서울특별시","서울특별시강서양천교육지원청","공립","8047","서울특별시 양천구 남부순환로 604","(신월동/강신중학교)","02-2694-9623","http://kangsin.sen.ms.kr","남여공학","02-2699-3253","","N","일반계","","전기","주간","19881224","19881224","20230205"};
        String[] str16 = {"B10","서울특별시교육청","7010958","강일고등학교","GANGIL HIGH SCHOOL","고등학교","서울특별시","서울특별시교육청","공립","5213","서울특별시 강동구 아리수로98길 40","(강일동)","02-428-6200","http://www.gang-il.hs.kr","남여공학","02-428-6810","일반고","N","일반계","","후기","주간","20100301","20100404","20230205"};
        String[] str17 = {"B10","서울특별시교육청","7130169","강일중학교","Gang-il Middle School","중학교","서울특별시","서울특별시강동송파교육지원청","공립","5236","서울특별시 강동구 고덕로27길 12","(암사동414-17)","02-441-4651","http://www.kangil.ms.kr","남여공학","02-441-4677","","N","일반계","","전기","주간","19821209","19830415","20230205"};
        String[] str18 = {"B10","서울특별시교육청","7132124","강현중학교","Gang-hyeon Middle School","중학교","서울특별시","서울특별시동작관악교육지원청","공립","6953","서울특별시 동작구 상도로13라길 22","/ 강현중학교 (상도동)","02-815-8335","http://sganghyeon.sen.ms.kr","남여공학","02-817-9162","","N","일반계","","전기","주간","19680806","19680806","20230205"};
        String[] str19 = {"B10","서울특별시교육청","7041165","개봉중학교","Gaebong Middle School","중학교","서울특별시","서울특별시남부교육지원청","공립","8250","서울특별시 구로구 고척로21나길 68","(개봉동)","02-3660-2400","http://gaebong.sen.ms.kr","남여공학","02-2688-9514","","N","일반계","","전기","주간","19840504","19840504","20230205"};
        String[] str20 = {"B10","서울특별시교육청","7121342","개운중학교","Gaewoon Middle School","중학교","서울특별시","서울특별시성북강북교육지원청","공립","2808","서울특별시 성북구 북악산로 935","(돈암동/개운중학교)","02-3291-5492","http://www.gw.ms.kr","남여공학","02-3291-5495","","N","해당없음","","전기","주간","20060301","20060301","20230205"};
        String[] str21 = {"B10","서울특별시교육청","7041166","개웅중학교","Kaewoong Middle School","중학교","서울특별시","서울특별시남부교육지원청","공립","8351","서울특별시 구로구 개봉로11길 81","/ 개웅중학교 (개봉동/개웅중학교)","02-2613-3342","http://www.kaewoong.ms.kr","남여공학","02-2616-7618","","N","일반계","","전기","주간","19870212","19870212","20230205"};
        String[] str22 = {"B10","서울특별시교육청","7091420","개원중학교","Gaewon Middle School","중학교","서울특별시","서울특별시강남서초교육지원청","공립","6328","서울특별시 강남구 영동대로 101","/ 개원중학교 (개포동/개원중학교)","02-3411-8321","http://gaewon.sen.ms.kr","남여공학","02-3411-8329","","N","일반계","","전기","주간","19841204","19841204","20230205"};
        String[] str23 = {"B10","서울특별시교육청","7010058","개포고등학교","Gaepo High School","고등학교","서울특별시","서울특별시교육청","공립","6324","서울특별시 강남구 개포로 402","(개포동/ 개포고등학교)","02-576-3333","http://www.gaepo.hs.kr","남여공학","02-571-6560","일반고","N","일반계","","후기","주간","19870512","19870512","20230205"};
        String[] str24 = {"B10","서울특별시교육청","7091421","개포중학교","Gaepo Middle School","중학교","서울특별시","서울특별시강남서초교육지원청","공립","6321","서울특별시 강남구 선릉로 9","(개포동/개포중학교)","02-571-1361","http://www.gaepo.ms.kr","남여공학","02-578-3823","","N","일반계","","전기","주간","19821209","19830422","20230205"};
        String[] str25 = {"B10","서울특별시교육청","7130170","거원중학교","Geowon Middle School","중학교","서울특별시","서울특별시강동송파교육지원청","공립","5789","서울특별시 송파구 양산로2길 30","(거여동/거원중학교)","02-405-4205","http://www.geowon.ms.kr","남여공학","02-405-4204","","N","일반계","","전기","주간","19971220","19980406","20230205"};
        String[] str26 = {"B10","서울특별시교육청","7010119","건국대학교사범대학부속고등학교","Konkuk University High School","고등학교","서울특별시","서울특별시교육청","사립","5029","서울특별시 광진구 능동로 120","/ 건국대학교사범대학부속고등학교 (화양동)","070-7012-3500","http://konkuk.sen.hs.kr","남여공학","02-456-0646","일반고","N","일반계","","후기","주간","19800131","19800515","20230205"};
        String[] str27 = {"B10","서울특별시교육청","7134119","건국대학교사범대학부속중학교","Middle School Attached To College of Education KONKUK University","중학교","서울특별시","서울특별시성동광진교육지원청","사립","5025","서울특별시 광진구 자양로 145-1","건국대학교사범대학부속중학교","02-457-0318","http://www.konkuk.ms.kr","남여공학","02-458-7427","","N","일반계","","전기","주간","19671230","19680515","20230205"};
        String[] str28 = {"B10","서울특별시교육청","7010059","경기고등학교","Kyunggi High School","고등학교","서울특별시","서울특별시교육청","공립","6086","서울특별시 강남구 영동대로 643","/ 경기고등학교 (삼성동)","02-3496-7300","http://kyunggi.hs.kr/","남","02-3496-7497","일반고","N","일반계","","후기","주간","19001003","19001003","20230205"};
        String[] str29 = {"B10","서울특별시교육청","7010271","경기기계공업고등학교","Gyeonggi Mechanical Technical High School","고등학교","서울특별시","서울특별시교육청","공립","1810","서울특별시 노원구 공릉로 264","(하계동)","02-2289-1600","http://www.ggmt.hs.kr","남여공학","02-978-4327","특성화고","N","전문계","","전기","주간","19570215","19570215","20230205"};
        String[] str30 = {"B10","서울특별시교육청","0","경기기계공업고등학교부설미래기술교육센터",".","공동실습소","서울특별시","서울특별시교육청","공립","1810","서울특별시 노원구 공릉로 264","(하계동/ 경기기계공업고등학교)","02-970-8922","http://www.ggmt.hs.kr","남여공학","02-978-4327","","N","해당없음","","전기","주간","19820601","19820601","20230205"};
        String[] str31 = {"B10","서울특별시교육청","7010272","경기상업고등학교","Gyeonggi Commercial High School","고등학교","서울특별시","서울특별시교육청","공립","3047","서울특별시 종로구 자하문로 136","(청운동)","02-737-6490","http://ggc.sen.hs.kr","남여공학","02-722-0504","특성화고","N","전문계","","전기","주간","19230206","19230514","20230205"};
        String[] str32 = {"B10","서울특별시교육청","7010060","경기여자고등학교","Kyunggi Girls’High School","고등학교","서울특별시","서울특별시교육청","공립","6324","서울특별시 강남구 삼성로 29","/ 경기여자고등학교 (개포동)","02-573-6797","http://www.kgg.hs.kr","여","02-575-1157","일반고","N","일반계","","후기","주간","19080401","19080401","20230205"};
        String[] str33 = {"B10","서울특별시교육청","7010385","경기여자고등학교부설방송통신고등학교","Air and Correspondence High School Attached to Gyeonggi Girls’ High School","방송통신고등학교","서울특별시","서울특별시교육청","공립","6324","서울특별시 강남구 삼성로 29","(개포동/경기여자고등학교)","02-573-6796","http://www.kgg.hs.kr","여","02-575-1157","일반고","N","일반계","","전기","주간","19740301","20020101","20230205"};
        String[] str34 = {"B10","서울특별시교육청","7031110","경기초등학교","Kyonggi Elementary School","초등학교","서울특별시","서울특별시서부교육지원청","사립","3746","서울특별시 서대문구 경기대로9길 10","(충정로2가/경기초등학교)","02-363-2908","http://www.kyonggicho.es.kr","남여공학","02-3146-9581","","N","일반계","","전기","주간","19641203","19641203","20230205"};
        String[] str35 = {"B10","서울특별시교육청","7010061","경동고등학교","Kyungdong High School","고등학교","서울특별시","서울특별시교육청","공립","2870","서울특별시 성북구 보문로29길 49","(삼선동3가/ 경동고등학교)","02-928-2353","www.kyungdong.hs.kr","남","02-926-7525","자율고","N","일반계","","후기","주간","19400416","19400416","20230205"};
        String[] str36 = {"B10","서울특별시교육청","7010386","경동고등학교부설방송통신고등학교","Air and Correspondence High School Attached to Kyungdong High School","방송통신고등학교","서울특별시","서울특별시교육청","공립","2870","서울특별시 성북구 보문로29길 49","(삼선동3가/ 경동고등학교)","02-928-2077","http://kyungdong.cyber.hs.kr","남여공학","02-926-7525","일반고","N","일반계","","전기","주간","19741231","20020101","20230205"};
        String[] str37 = {"B10","서울특별시교육청","7010120","경문고등학교","Kyungmoon High School","고등학교","서울특별시","서울특별시교육청","사립","6995","서울특별시 동작구 동작대로 171","/ 경문고등학교 (동작동)","02-535-1301","http://kyungmoon.hs.kr/","남","02-535-1230","일반고","N","일반계","","전기","주간","19800124","19800507","20230205"};
        String[] str38 = {"B10","서울특별시교육청","7010062","경복고등학교","Kyungbock High School","고등학교","서울특별시","서울특별시교육청","공립","3047","서울특별시 종로구 자하문로28가길 9","/ 경복고등학교 (청운동/경복고등학교)","02-397-5301","http://kyungbock.sen.hs.kr","남","02-736-0422","일반고","N","일반계","","후기","주간","19210502","19210502","20230205"};
        String[] str39 = {"B10","서울특별시교육청","7010387","경복고등학교부설방송통신고등학교","Open highschool affiliated with KYUNGBOCK","방송통신고등학교","서울특별시","서울특별시교육청","공립","3047","서울특별시 종로구 자하문로28가길 9","(청운동)","02-397-5470","http://www.cyber.hs.kr/user/index.do","남여공학","02-736-0422","일반고","N","일반계","","전기","주간","19740323","19740323","20230205"};
        String[] str40 = {"B10","서울특별시교육청","7010835","경복비즈니스고등학교","Kyungbok Business High School","고등학교","서울특별시","서울특별시교육청","사립","7589","서울특별시 강서구 화곡로 379","(등촌동)","02-3661-3425","http://www.kbb.hs.kr","여","02-3661-8372","특성화고","N","전문계","","전기","주간","19721002","19721002","20230205"};

        List<String[]> temp = new ArrayList<>();
        temp.add(str1);
        temp.add(str2);
        temp.add(str3);
        temp.add(str4);
        temp.add(str5);
        temp.add(str6);
        temp.add(str7);
        temp.add(str8);
        temp.add(str9);
        temp.add(str10);
        temp.add(str11);
        temp.add(str12);
        temp.add(str13);
        temp.add(str14);
        temp.add(str15);
        temp.add(str16);
        temp.add(str17);
        temp.add(str18);
        temp.add(str19);
        temp.add(str20);
        temp.add(str21);
        temp.add(str22);
        temp.add(str23);
        temp.add(str24);
        temp.add(str25);
        temp.add(str26);
        temp.add(str27);
        temp.add(str28);
        temp.add(str29);
        temp.add(str30);
        temp.add(str31);
        temp.add(str32);
        temp.add(str33);
        temp.add(str34);
        temp.add(str35);
        temp.add(str36);
        temp.add(str37);
        temp.add(str38);
        temp.add(str39);
        temp.add(str40);

        List<School> list = new ArrayList<>();
        for(String[] arr : temp){
            School s = new School();
            for(int i=0; i<arr.length; i++){
                switch (i){
                    case 0:
                        s.setCitySchoolCode(arr[i]);
                        
                    case 1:
                        s.setCitySchoolName(arr[i]);
                        
                    case 2:
                        s.setSchoolCode(arr[i]);
                        
                    case 3:
                        s.setSchoolName(arr[i]);
                        
                    case 4:
                        s.setSchoolNameEng(arr[i]);
                        
                    case 5:
                        s.setSchoolCategory(arr[i]);
                        
                    case 6:
                        s.setLocationName(arr[i]);
                        
                    case 7:
                        s.setJurisdictionOrgName(arr[i]);
                        
                    case 8:
                        s.setEstablishmentName(arr[i]);
                        
                    case 9:
                        s.setZipCode(arr[i]);
                        
                    case 10:
                        s.setAddress1(arr[i]);
                        
                    case 11:
                        s.setAddress2(arr[i]);
                        
                    case 12:
                        s.setPhone(arr[i]);
                        
                    case 13:
                        s.setHomepageUrl(arr[i]);
                        
                    case 14:
                        s.setDivision(arr[i]);
                        
                    case 15:
                        s.setFax(arr[i]);
                        
                    case 16:
                        s.setSchoolDivision(arr[i]);
                        
                    case 17:
                        s.setClassificationTf(arr[i]);
                        
                    case 18:
                        s.setClassificationName(arr[i]);
                        
                    case 19:
                        s.setAffiliationName(arr[i]);
                        
                    case 20:
                        s.setEntrance(arr[i]);
                        
                    case 21:
                        s.setDayAndNightTF(arr[i]);
                        
                    case 22:
                        s.setCreatedDate(arr[i]);
                        
                    case 23:
                        s.setAnniversary(arr[i]);
                        
                    case 24:
                        s.setModifiedDate(arr[i]);
                        
                    default:
//                        System.out.println("default");
                        break;
                }

            }
            list.add(s);
        }
        return list;
     }
}