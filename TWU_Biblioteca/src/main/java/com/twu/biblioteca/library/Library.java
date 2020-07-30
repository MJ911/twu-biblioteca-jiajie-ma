package com.twu.biblioteca.library;

import java.util.List;
import java.util.Optional;

public interface Library<C extends item> {
    List<C> getAllItems();

    Optional<C> getBookInfoByItemNo(String itemNo);

    boolean returnItemByItemNo(String itemNo);
}
