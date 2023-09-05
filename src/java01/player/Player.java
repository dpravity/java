package java01.player;

public abstract class Player {

    boolean pause;  // 일시정지 상태
    int currentPos; // 현재 play 되고 있는 위치 저장

    public Player(){
        pause = false;
        currentPos = 0;
    }
    // 지정된 위치에서 시작
    abstract void play(int pos);

    // 즉시 멈춤
    abstract void stop();

    void play(){
        play(currentPos);
    }

    void pause(){
        if(pause){
            pause = false;
            play(currentPos);
        }else{
            pause = true;
            stop();
        }
    }

}
