public class BoardGame extends BoardHouse {

    private BoardHouse init;
    private int qtd;

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

}
