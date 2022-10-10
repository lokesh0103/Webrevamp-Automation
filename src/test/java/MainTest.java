import org.testng.annotations.Test;

import java.io.IOException;

public class MainTest {


    @Test
    public static void Login() throws IOException, InterruptedException {
        PostLoginTest.logIn();
    }

    @Test
    public static void sip() throws IOException {

        PostLoginTest.Sip();
    }

}