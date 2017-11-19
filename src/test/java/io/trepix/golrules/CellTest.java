package io.trepix.golrules;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static io.trepix.golrules.stubs.OverrodeAdjacentCell.createAdjacentCell;
import static io.trepix.golrules.stubs.OverrodeAdjacentCell.createNonAdjacentCell;
import static org.mockito.Mockito.*;

public class CellTest {

    private static final Cell DEAD_CELL = new Cell(null , State.DEAD);
    private static final Cell ALIVE_CELL = new Cell(null , State.ALIVE);

    @Test
    public void givenOneAliveAdjacentCellAndCurrentCellIsAlive_ShouldReturnDeadCell() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.DEAD),
                createAdjacentCell(State.DEAD));
        Cell nextCell = cell.applyGameOfLifeRules(cells);
        Assert.assertEquals(DEAD_CELL, nextCell);
    }

    @Test
    public void givenNoAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnDeadCell() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createNonAdjacentCell(State.ALIVE),
                createNonAdjacentCell(State.ALIVE),
                createAdjacentCell(State.DEAD),
                createAdjacentCell(State.DEAD));
        Cell nextCell = cell.applyGameOfLifeRules(cells);
        Assert.assertEquals(DEAD_CELL, nextCell);
    }

    @Test
    public void givenTwoAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnAliveCell() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        Cell nextCell = cell.applyGameOfLifeRules(cells);
        Assert.assertEquals(ALIVE_CELL, nextCell);
    }

    @Test
    public void givenThreeAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnAliveCell() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        Cell nextCell = cell.applyGameOfLifeRules(cells);
        Assert.assertEquals(ALIVE_CELL, nextCell);
    }

    @Test
    public void givenMoreThanThreeAliveAdjacentCellsAndCurrentCellIsAlive_ShouldReturnDeadCell() {
        Cell cell = new Cell(null, State.ALIVE);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        Cell nextCell = cell.applyGameOfLifeRules(cells);
        Assert.assertEquals(DEAD_CELL, nextCell);
    }

    @Test
    public void givenThreeAliveAdjacentCellsAndCurrentCellIsDead_ShouldReturnAliveCell() {
        Cell cell = new Cell(null, State.DEAD);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        Cell nextCell = cell.applyGameOfLifeRules(cells);
        Assert.assertEquals(ALIVE_CELL, nextCell);
    }

    @Test
    public void givenNonThreeAliveAdjacentCellsAndCurrentCellIsDead_ShouldReturnDeadCell() {
        Cell cell = new Cell(null, State.DEAD);
        List<Cell> cells = Arrays.asList(
                createAdjacentCell(State.ALIVE),
                createAdjacentCell(State.ALIVE));
        Cell nextCell = cell.applyGameOfLifeRules(cells);
        Assert.assertEquals(DEAD_CELL, nextCell);
    }

    @Test
    public void whenIsAdjacentIsCalled_ShouldDelegateItsLogicToPosition() {
        Position mockedPosition = Mockito.mock(Position.class);
        Cell cell = new Cell(mockedPosition, State.ALIVE);

        when(mockedPosition.isAdjacent(mockedPosition)).thenReturn(true);
        cell.isAdjacent(cell);

        verify(mockedPosition, times(1)).isAdjacent(mockedPosition);
    }

}