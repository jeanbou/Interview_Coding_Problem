package org.bce.api.lib;

import java.util.ArrayList;

/**
 * TVMaze
 * <p>
 * The instances of classes that implement this interface
 */
public interface TVMaze {

    /**
     * Returns an array list of TVMazeContent 
     *
     * @param apiKey
     * @param Query
     * @return ArrayList<TVMazeContent>
     */
    ArrayList<TVMazeContent> searchContent(String apiKey, String Query);

}
