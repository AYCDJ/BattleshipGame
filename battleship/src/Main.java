/*

Alexis Santiago
First made March 2022
Old battleship game made for Object-Oriented Programing

 */
    class Board {
        private char[][] grid;
        private final int size = 10;

        public Board() {
            grid = new char[size][size];
            // Initialize the board with water '~'
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    grid[i][j] = '~'; // ~ represents water
                }
            }
        }

        public void displayBoard() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Place a ship on the board
        public boolean placeShip(int x, int y, int length, boolean horizontal) {
            if (horizontal) {
                if (y + length > size) return false;
                for (int i = 0; i < length; i++) {
                    if (grid[x][y + i] != '~') return false; // check if the space is occupied
                }
                for (int i = 0; i < length; i++) {
                    grid[x][y + i] = 'S'; // 'S' represents a ship
                }
            } else {
                if (x + length > size) return false;
                for (int i = 0; i < length; i++) {
                    if (grid[x + i][y] != '~') return false; // check if the space is occupied
                }
                for (int i = 0; i < length; i++) {
                    grid[x + i][y] = 'S';
                }
            }
            return true;
        }

        // Attack a position
        public String attack(int x, int y) {
            if (grid[x][y] == 'S') {
                grid[x][y] = 'X'; // 'X' represents a hit
                return "Hit!";
            } else if (grid[x][y] == '~') {
                grid[x][y] = 'O'; // 'O' represents a miss
                return "Miss!";
            }
            return "Already attacked this position!";
        }
    }