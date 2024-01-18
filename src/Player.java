public class Player {

    private int number;
    private String name;
    private int lostTime;

    private BoardHouse house;

public Player(int number, String name) {
    this.number = number;
    this.name = name;
    lostTime = 0;
}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLostTime() {
        return lostTime;
    }

    public void setLostTime(int lostTime) {
        this.lostTime = lostTime;
    }

    public BoardHouse getHouse() {
        return house;
    }

    public void setHouse(BoardHouse house) {
        this.house = house;
    }

    public String getPlayer(int i) {
        return "Player " + i + ": " + name;
    }

    public int getPosition() {
        return house.getPosition();
    }
}
