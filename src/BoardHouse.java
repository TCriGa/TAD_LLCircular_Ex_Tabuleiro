import java.util.Random;

public class BoardHouse {

    private int _id;
    private int player;
    private int position;
    private int status;
    private int penalty;
    private BoardHouse next;
    private BoardHouse prev;
    public BoardHouse() {
        this.player = 0;
        this.position = 0;
        this.status = 0;
        this.penalty = 0;
        this.next = this;
        this.prev = this;
    }
    public int rollDice(){
        Random dado = new Random();
        return dado.nextInt(6)+1;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }


    public int getPosition() {
        return position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPenalty() {
        return penalty;
    }

    public BoardHouse getNext() {
        return next;
    }

    public void setNext(BoardHouse next) {
        this.next = next;
    }

    public BoardHouse getPrev() {
        return prev;
    }

    public void setPrev(BoardHouse prev) {
        this.prev = prev;
    }


}
