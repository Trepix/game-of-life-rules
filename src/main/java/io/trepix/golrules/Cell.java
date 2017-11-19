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

    public State calculateNextState(List<Cell> cells) {
        Integer aliveAdjacentCells = 0;
        for (Cell cell : cells) {
            if (cell.isAdjacent(this) && cell.isAlvie()) ++aliveAdjacentCells;
        }
        if (isUnderPopulation(aliveAdjacentCells)) return State.DEAD;
        if (isSurvivalSituationGiven(aliveAdjacentCells)) return State.ALIVE;
        if (isOverCrowded(aliveAdjacentCells)) return State.DEAD;
        if (canReproduce(aliveAdjacentCells)) return State.ALIVE;
        return State.DEAD;
    }

    public boolean isAdjacent(Cell cell) {
        return this.position.isAdjacent(cell.position);
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
