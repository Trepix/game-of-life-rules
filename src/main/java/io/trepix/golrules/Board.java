package io.trepix.golrules;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
public class Board {

    private List<Cell> cells;

    public void applyGameOfLifeRules() {
        List<Cell> nextGenerationCells = new ArrayList<>();
        for (val cell : cells) {
            State newState = cell.calculateNextState(cells);
            nextGenerationCells.add(new Cell(cell.getPosition(), newState));
        }
        this.cells = nextGenerationCells;
    }

}
