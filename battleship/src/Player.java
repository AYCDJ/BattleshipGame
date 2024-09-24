class Player {
    private Board board;
    private Ship[] ships;

    public Player() {
        board = new Board();
        ships = new Ship[5]; // Typically, 5 ships in battleship
        ships[0] = new Ship(5); // Carrier
        ships[1] = new Ship(4); // Battleship
        ships[2] = new Ship(3); // Destroyer
        ships[3] = new Ship(3); // Submarine
        ships[4] = new Ship(2); // Patrol Boat
    }

    public Board getBoard() {
        return board;
    }

    public boolean placeShip(int x, int y, int shipIndex, boolean horizontal) {
        return board.placeShip(x, y, ships[shipIndex].getLength(), horizontal);
    }

    public String attack(Player opponent, int x, int y) {
        return opponent.getBoard().attack(x, y);
    }
}
