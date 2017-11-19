package io.trepix.golrules;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Cell {

    private final Position position;
    private final State state;

    public Cell applyGameOfLifeRules(List<Cell> cells) {
        Integer aliveAdjacentCells = (int) cells.stream().filter(c -> c.isAdjacent(this) && c.isAlvie()).count();
        if (isUnderPopulation(aliveAdjacentCells)) return createDeadCell();
        if (isSurvivalSituationGiven(aliveAdjacentCells)) return createAliveCell();
        if (isOverCrowded(aliveAdjacentCells)) return createDeadCell();
        if (canReproduce(aliveAdjacentCells)) return createAliveCell();
        return createDeadCell();
    }

    private Cell createDeadCell() {
        return new Cell(this.position, State.DEAD);
    }

    private Cell createAliveCell() {
        return new Cell(this.position, State.ALIVE);
    }

    public boolean isAdjacent(Cell cell) {
        return false;
    }

    private boolean isUnderPopulation(Integer aliveAdjacentCells) {
        return this.isAlvie() && aliveAdjacentCells < 2;
    }

    private boolean isSurvivalSituationGiven(Integer aliveAdjacentCells) {
        return this.isAlvie() && (aliveAdjacentCells == 2 || aliveAdjacentCells == 3);
    }

    private boolean isOverCrowded(Integer aliveAdjacentCells) {
        return this.isAlvie() && aliveAdjacentCells > 3;
    }

    private boolean canReproduce(Integer aliveAdjacentCells) {
        return this.isDead() && aliveAdjacentCells == 3;
    }

    private boolean isAlvie() {
        return state.equals(State.ALIVE);
    }

    private boolean isDead() {
        return state.equals(State.DEAD);
    }
    
}
