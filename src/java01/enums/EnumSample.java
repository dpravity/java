package java01.enums;

public enum EnumSample {
    EAST("동쪽"),
    WEST("서쪽"),
    SOUTH("남쪽"),
    NORTH("북쪽");

    final private String name;

    EnumSample(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
