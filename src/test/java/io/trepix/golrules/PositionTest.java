package io.trepix.golrules;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    private static final Integer X = 2;
    private static final Integer Y = 2;

    private static final Position POSITION = new Position(X, Y);


    @Test
    public void givenTheSamePosition_ShouldReturnIsNotAdjacent() {
        Position samePosition = new Position(X, Y);
        Assert.assertFalse(POSITION.isAdjacent(samePosition));
    }

    @Test
    public void givenAPositionFoundAtMoreThanTwoUnitsOnEachAxis_ShouldReturnIsNotAdjacent() {
        Position samePosition = new Position(X + 2, Y - 2);
        Assert.assertFalse(POSITION.isAdjacent(samePosition));
    }

    @Test
    public void givenAPositionFoundAtOneLessUnitOnTheXAxisAndOneLessUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position downLeftPosition = new Position(X - 1, Y - 1);
        Assert.assertTrue(POSITION.isAdjacent(downLeftPosition));
    }

    @Test
    public void givenAPositionFoundAtOneLessUnitOnTheXAxisAndSameUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position leftPosition = new Position(X - 1, Y);
        Assert.assertTrue(POSITION.isAdjacent(leftPosition));
    }

    @Test
    public void givenAPositionFoundAtOneLessUnitOnTheXAxisAndOneMoreUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position upLeftPosition = new Position(X - 1, Y + 1);
        Assert.assertTrue(POSITION.isAdjacent(upLeftPosition));
    }

    @Test
    public void givenAPositionFoundAtSameUnitUnitOnTheXAxisAndOneLessUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position upPosition = new Position(X, Y - 1);
        Assert.assertTrue(POSITION.isAdjacent(upPosition));
    }

    @Test
    public void givenAPositionFoundAtSameUnitUnitOnTheXAxisAndOneMoreUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position downPosition = new Position(X, Y + 1);
        Assert.assertTrue(POSITION.isAdjacent(downPosition));
    }

    @Test
    public void givenAPositionFoundAtOneMoreUnitOnTheXAxisAndOneLessUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position downRightPosition = new Position(X + 1, Y - 1);
        Assert.assertTrue(POSITION.isAdjacent(downRightPosition));
    }

    @Test
    public void givenAPositionFoundAtOneMoreUnitOnTheXAxisAndSameUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position rightPosition = new Position(X + 1, Y);
        Assert.assertTrue(POSITION.isAdjacent(rightPosition));
    }

    @Test
    public void givenAPositionFoundAtOneMoreUnitOnTheXAxisAndOneMoreUnitOnTheYAxis_ShouldReturnIsAdjacent() {
        Position upRightPosition = new Position(X + 1, Y + 1);
        Assert.assertTrue(POSITION.isAdjacent(upRightPosition));
    }


}
