package util;

import com.github.javafaker.Faker;

public class DataGenerator {

    public static String generateRandomUsername() {
        //add faker mvn

        Faker faker = new Faker();
        String usernamer = faker.name().username();
        return usernamer;


    }

    public static String generateRandomEmail() {

        Faker faker = new Faker();
        String email = faker.name().firstName().toLowerCase() + faker.random().nextInt(0, 100) + "@example.com";
        return  email;
    }


    /* these helpers generate random username and email if needed
    how to use them in the karate scenario:
    ------->

   Background:

    * def dataGenerator = Java.type('util.DataGenerator (path of the generator class)')
    Given path uatURL
  Scenario: A random new user sign up

    * def randomEmail = dataGenerator.generateRandomEmail()
    * def randomUsername = dataGenerator.generateRandomUsername()

    Given path 'users'
    And request
    """
    {
      username: #(randomUsername),
      email: #(randomEmail)
    }
    """
    When method POST
    Then status 200
     */
}
