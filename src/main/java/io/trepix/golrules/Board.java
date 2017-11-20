package io.trepix.golrules;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

@EqualsAndHashCode
@RequiredArgsConstructor
public class Board {

    private final List<Cell> cells;

    public Board applyGameOfLifeRules() {
        return cells.stream()
                .map(c -> c.applyGameOfLifeRules(cells))
                .collect(Collector.of(
                        LinkedList::new,
                        List::add,
                        (e1, e2) -> null,
                        Board::new
                ));
    }

}
