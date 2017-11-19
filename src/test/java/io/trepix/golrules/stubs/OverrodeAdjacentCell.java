package io.trepix.golrules.stubs;

import io.trepix.golrules.Cell;
import io.trepix.golrules.State;

public class OverrodeAdjacentCell extends Cell {

    private final boolean isAdjacent;

    private OverrodeAdjacentCell(boolean isAdjacent, State state) {
        super(null, state);
        this.isAdjacent = isAdjacent;
    }

    public static Cell createAdjacentCell(State state) {
        return new OverrodeAdjacentCell(true, state);
    }

    public static Cell createNonAdjacentCell(State state) {
        return new OverrodeAdjacentCell(false, state);
    }

    public boolean isAdjacent(Cell cell) {
        return isAdjacent;
    }

}
