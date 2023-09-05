package java01.player;

public class CdPlayer extends Player {

    int currentTrack;   // 현재 재생중인 트랙

    @Override
    void play(int pos) {

    }

    @Override
    void stop() {

    }

    void nextTrack(){
        currentTrack++;
        // TODO
    }

    void preTrack(){
        currentTrack--;
        // TODO
    }
}
