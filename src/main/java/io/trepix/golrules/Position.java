package io.trepix.golrules;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
public class Position {

    private final Integer x;
    private final Integer y;


    public boolean isAdjacent(Position position) {
        return false;
    }
}
