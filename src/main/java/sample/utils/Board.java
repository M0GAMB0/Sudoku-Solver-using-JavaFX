package sample.utils;

public class Board {
    Integer board[][] = new Integer[9][9];
    public Board(){};

    public Board(Board copyMe) {
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                board[c][r] = copyMe.get(c, r);
            }
        }
    }

    public Integer get(int c, int r) {
        return board[c][r];
    }

    public void set(int c, int r, Integer x) {
        board[c][r] = x;
    }

}
