package se.linda.gamecenter.Componenets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PictureTest {
    private File path;
    private Picture picture;

    @BeforeEach
    public void init() throws IOException {
        path.createNewFile();
        path.canExecute();
        path.exists();
        this.picture = new Picture(path.getPath(),"test");
    }

    @Disabled
    @Test
    public void CreationTest() {
        assertNotNull(picture.getPic(10,10));
    }
}
