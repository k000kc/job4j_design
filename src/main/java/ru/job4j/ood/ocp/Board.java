package ru.job4j.ood.ocp;

public class Board {
    private Piece[][] board;

    /**
     * нарушение ocp. Для каждой фигуры придется изменять логику хода.
     * Чтобы не писать логику хода каждой фигуры в данном методе,
     * лучше сделать Piece - интерфейсом с методом move,
     * и создать реализацию каждой фигуры с соответствующей логикой хода.
     */
    public void move(Piece piece, int destX, int destY) {
        //логика движения фигуры
    }

    private class Piece {
        int x;
        int y;
    }
}
