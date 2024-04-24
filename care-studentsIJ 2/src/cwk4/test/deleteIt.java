package cwk4.test;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import cwk4.CARE;
import cwk4.Tournament;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class deleteIt {
    CARE game;

    public deleteIt() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.game = new Tournament("Ola");
    }

    @After
    public void tearDown() {
    }

    private boolean containsText(String text, String[] str) {
        boolean result = true;
        String[] var4 = str;
        int var5 = str.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String temp = var4[var6];
            result = result && text.toLowerCase().contains(temp.toLowerCase());
        }

        return result;
    }

    @Test
    public void getReserveTest() {
        String[] xx = new String[]{"Ganfrank", "Rudolf", "Elblond", "Flimsi", "Drabina", "Golum", "Argon", "Neon", "Xenon"};
        String details = this.game.getReserve();
        boolean actual = this.containsText(details, xx);
        Assert.assertTrue(actual);
    }
}
