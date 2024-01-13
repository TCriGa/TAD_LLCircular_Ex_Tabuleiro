import java.util.Random;

public class BoardHouse {

    private int _id;
    private int player;
    private Random dado;
    private int position;
    private int status;
    private int penalty;
    private BoardHouse next;
    private BoardHouse prev;
    public BoardHouse() {
        this._id = 0;
        this.player = 0;
        this.dado = new Random();
        this.position = 0;
        this.status = 0;
        this.penalty = 0;
        this.next = this;
        this.prev = this;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Random getDado() {
        return dado;
    }

    public void setDado(Random dado) {
        this.dado = dado;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public void setPenalty(int penalty) {
        this.penalty = penalty;
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
