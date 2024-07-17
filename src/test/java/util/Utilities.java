package util;

public class Utilities {
    public static String getName (){
        return "burcuonal" ;
    }

    public static String getJob (){
        return "QA Engineer";
    }


    public static String generateRandomUsername() {
        return "user_" + System.currentTimeMillis();
    }

    public static String generateRandomEmail() {
        return "user_" + System.currentTimeMillis() + "@example.com";
    }
    /* these helpers generate random username and email if needed
    how to use them in the karate scenario:
    ------->
    Background:
  * def Utilities = Java.type('utilities.Utilities')

    Scenario: Yeni kullanıcı oluşturma
      Given path '/users'
      And request { username: '#(Utilities.generateRandomUsername())', email: '#(Utilities.generateRandomEmail())' }
      When method POST
      Then status 200
     */
}




