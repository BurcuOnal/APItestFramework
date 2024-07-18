package runner;

import com.intuit.karate.junit5.Karate;

public class KarateRunner {

    @Karate.Test
    Karate testApi(){
        return Karate.run("");
    } // '' run all tests and .tags("") can be added to run scenarios according to the tags, ex: "@smoke"

    @Karate.Test
    Karate testSomeFeatures() {
        return Karate.run("src/test/resources/features/----.feature",
                "src/test/resources/features/---.feature");
    } // run more than one feature file

}
