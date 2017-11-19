package io.trepix.golrules;

import static java.lang.Math.*;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
public class Position {

    private static final double MAX_DISTANCE_ALLOWED_TO_BE_CONSIDERED_ADJACENT = sqrt(1+1);

    private final Integer x;
    private final Integer y;


    public boolean isAdjacent(Position position) {
        double absoluteDistanceX = abs(this.x - position.x);
        double absoluteDistanceY = abs(this.y - position.y);
        double distance = sqrt(pow(absoluteDistanceX,2) + pow(absoluteDistanceY, 2));
        return distance != 0 && distance <= MAX_DISTANCE_ALLOWED_TO_BE_CONSIDERED_ADJACENT;
    }
}
