public class BoardGame extends BoardHouse {
    private BoardHouse init;

    public BoardHouse getInit() {
        return init;
    }

    private int qtd;
    private int nowPlayer;

    public int getQtd() {
        return qtd;
    }

    public boolean isEmpty() {
        return init == null;
    }

    public void insertElementInit(BoardHouse element) {
        if (!isEmpty()) {
            element.setNext(init);
            element.setPrev(element.getPrev());
            init.setPrev(element);
            element.getPrev().setNext(element);
        }
        init = element;
        qtd++;
    }

    public void insertElementLast(BoardHouse element) {
        if (!isEmpty()) {
            element.setNext(init);
            element.setPrev(element.getPrev());
            init.getPrev().setNext(element);
            init.setPrev(element);
        }
        init = element;
        qtd++;
    }


    public boolean insertElementClockwise(BoardHouse eNew, BoardHouse eCurrent) {
        if (eNew == null) {
            return false;
        }
        //Se  a lista estiver vazia, insere o elemento na primeira posição
        if (qtd <= 1 || eCurrent == init || isEmpty()) {
            insertElementInit(eNew);
            return true;
            //Se o elemento a ser inserido for o último, insere o elemento na última posição
        } else if (eCurrent.getNext() == init.getPrev()) {
            insertElementLast(eNew);
            return true;
            //Caso contrário, insere o elemento na posição correta, mantendo a ordem cíclica.
        } else {
            eNew.setNext(eCurrent);
            eNew.setPrev(eNew.getPrev());
            eCurrent.getNext().setPrev(eNew);
            eCurrent.setNext(eNew);
            qtd++;
            return true;
        }
    }


    public boolean insertElementCounterclockwise(BoardHouse eNew, BoardHouse eCurrent) {
        if (eNew == null) {
            return false;
        }
        if (qtd <= 1 || eCurrent == init || isEmpty()) {
            insertElementInit(eNew);
        } else if (eCurrent.getNext() == init.getPrev()) {
            insertElementLast(eNew);
        } else {
            //O valor do novo elemento é o valor do próximo elemento, e o próximo elemento é o valor do novo elemento.
            eNew.setNext(eCurrent.getNext());
            //O valor do elemento anterior é o valor do elemento atual.
            eNew.setPrev(eCurrent);
            //O valor do elemento atual é o valor do novo elemento.
            eCurrent.getNext().setPrev(eNew);
            //O valor do próximo elemento é o valor do elemento atual.
            eCurrent.setNext(eNew);
            qtd++;
        }
        return true;
    }

    public boolean removeElement(BoardHouse element) {
        if (isEmpty()) {
            return false;
        }
        if (qtd == 1) {
            init = null;
            qtd = 0;
        } else if (element == init) {
            init = init.getNext();
        }
        element.getPrev().setNext(element.getNext());
        element.getNext().setPrev(element.getPrev());
        element.setNext(null);
        element.setPrev(null);
        qtd--;
        return true;
    }

    public void printElements(BoardHouse boardHouse) {
        int position = boardHouse.getPosition();
        if (position < 10) {
            System.out.println(position);
            switch (getStatus()) {
                case 0:
                    System.out.println("Vazio");
                    break;
                case 1:
                    System.out.println("Casa marcada - 1x " + boardHouse.getPlayer());
                    break;
                case 2:
                    System.out.println("Casa marcada - 2x " + boardHouse.getPlayer());
                    break;
            }
        }

    }

    public void printElementsClockwise() {
        int positionCurrent = 1;
        if (!isEmpty()) {
            BoardHouse element = init;
            do {
                printElements(element);
                element = element.getNext();
            } while (positionCurrent <= getQtd());
        } else {
            System.out.println("Lista vazia");
        }
    }
    Player[] nPlayer = new Player[1];
    public Player numberPlayer(int n) {
        return switch (n) {
            case 1 -> nPlayer[0];
            case 2 -> nPlayer[1];
            case 3 -> nPlayer[2];
            case 4 -> nPlayer[3];
            default -> null;
        };
    }
    public Player nextPlayer() {
        if (nowPlayer == 0) {
            nowPlayer = 1;
        } else{
            nowPlayer++;
            if (nowPlayer < qtd) {
                nowPlayer = 1;
            }
        }

        return numberPlayer(nowPlayer);
    }

    public BoardHouse getPositionClockwise(int dice, BoardHouse position) {
        int positionCurrent = 0;
        if (dice > qtd || dice <= 0) {
            return null;
        }
        BoardHouse aux = position;
        while (positionCurrent < dice) {
            aux = aux.getNext();
            positionCurrent++;
        }
        return aux;
    }

    public BoardHouse getPositionCounterclockwise(int dice, BoardHouse position) {
        int positionCurrent = 1;
        if (dice > qtd || dice <= 0) {
            return null;
        }
        BoardHouse aux = position;
        while (positionCurrent < dice) {
            aux = aux.getPrev();
            positionCurrent++;
        }
        return aux;
    }



}


