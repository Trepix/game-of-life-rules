package io.trepix.golrules;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.trepix.golrules.stubs.OverrodeAdjacentCell.*;

public class CellTest {

    @Test
    public void givenOneAliveAdjacentCellAndCurrentCellIsAlive_ShouldReturnDeadAsNextState() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.DEAD),
                createAdjacentCell(State.DEAD));
        State nextState = cell.calculateNextState(cells);
        Assert.assertEquals(State.DEAD, nextState);
    }

    @Test
    public void givenNoAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnDeadAsNextState() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createNonAdjacentCell(State.ALIVE),
                createNonAdjacentCell(State.ALIVE),
                createAdjacentCell(State.DEAD),
                createAdjacentCell(State.DEAD));
        State nextState = cell.calculateNextState(cells);
        Assert.assertEquals(State.DEAD, nextState);
    }

    @Test
    public void givenTwoAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnAliveAsNextState() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        State nextState = cell.calculateNextState(cells);
        Assert.assertEquals(State.ALIVE, nextState);
    }

    @Test
    public void givenThreeAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnAliveAsNextState() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        State nextState = cell.calculateNextState(cells);
        Assert.assertEquals(State.ALIVE, nextState);
    }

    @Test
    public void givenMoreThanThreeAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnDeadAsNextState() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        State nextState = cell.calculateNextState(cells);
        Assert.assertEquals(State.DEAD, nextState);
    }

    @Test
    public void givenThreeAliveAdjacentCellsAndCurrentCellIsDead_ShouldReturnAliveAsNextState() {
        Cell cell = new Cell(null, State.DEAD);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        State nextState = cell.calculateNextState(cells);
        Assert.assertEquals(State.ALIVE, nextState);
    }

    @Test
    public void givenNonThreeAliveAdjacentCellsAndCurrentCellIsDead_ShouldReturnDeadAsNextState() {
        Cell cell = new Cell(null, State.DEAD);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        State nextState = cell.calculateNextState(cells);
        Assert.assertEquals(State.DEAD, nextState);
    }


}
