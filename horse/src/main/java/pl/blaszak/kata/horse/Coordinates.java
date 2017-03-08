package pl.blaszak.kata.horse;

/**
 * Created by kblaszke on 03.03.17.
 */
@SuppressWarnings("ALL")
public class Coordinates {

    public int row;
    public int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (row != that.row) return false;
        if (col != that.col) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }
}
