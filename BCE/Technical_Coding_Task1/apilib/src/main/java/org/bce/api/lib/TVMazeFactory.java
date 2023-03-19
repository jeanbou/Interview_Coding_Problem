package org.bce.api.lib;

/**
 * Factory for creating instances of {@link TVMaze}.
 */
public final class TVMazeFactory {

    private TVMazeFactory() {
    }

    /**
     * Creates an instance of {@link TVMaze}.
     *
     * @return the new instance
     */
    public static TVMaze createStringPadder() {
        return new TVMazeImpl();
    }

}
