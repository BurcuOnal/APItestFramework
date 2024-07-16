package runner;

import com.intuit.karate.junit5.Karate;

public class UserTest {
    @Karate.Test
    Karate testApi(){
        return Karate.run(""); //run all tests
    }
}
