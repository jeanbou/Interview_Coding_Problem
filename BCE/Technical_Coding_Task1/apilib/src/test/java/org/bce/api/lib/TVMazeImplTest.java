package org.bce.api.lib;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

class TVMazeImplTest {

    private final TVMazeImpl listTVMazeContent = new TVMazeImpl();

    @Test
    void searchContentGirls() {
        assertThat(listTVMazeContent.searchContent("Nv7wn_uV7yc2N-Jkh3e94AKGLOECzChY", "girls").
                size()).isGreaterThan(0);
    }
    
    @Test
    void searchContentNonExistant() {
        assertThat(listTVMazeContent.searchContent("Nv7wn_uV7yc2N-Jkh3e94AKGLOECzChY", "Nv7wn_uV7yc2N-Jkh3e94AKGLOECzChY").
                size()).isEqualTo(0);
    }
    
    @Test
    void searchContentHasGirlsInRandomInstanceTitle() {
        Random randIndex = new Random();
        assertThat(listTVMazeContent.searchContent("Nv7wn_uV7yc2N-Jkh3e94AKGLOECzChY", "girls").
                get(randIndex.nextInt(listTVMazeContent.searchContent("Nv7wn_uV7yc2N-Jkh3e94AKGLOECzChY", "girls").size())).
                getTitle().toLowerCase()).contains("girls");
    }

}
