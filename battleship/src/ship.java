class Ship {
    private int length;
    private boolean isSunk;

    public Ship(int length) {
        this.length = length;
        this.isSunk = false;
    }

    public int getLength() {
        return length;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void sink() {
        isSunk = true;
    }
}
