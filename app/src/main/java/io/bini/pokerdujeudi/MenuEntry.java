package io.bini.pokerdujeudi;

import lombok.Getter;

public class MenuEntry {
    @Getter
    private String label;

    @Getter
    private int target;

    public MenuEntry(String label, int target) {
        this.label = label;
        this.target = target;
    }
}
