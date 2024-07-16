Feature: Login olma

  Background:
    Given url uatURL
@tcUserLogin
  Scenario: Tc kullanıcı login olma

#TOKEN ALMA İŞLEMİ
    Given path 'tokenpath/..'
    And header Content-Type = 'application/json'
    Then request
    """
    {
    "username": "#(username)",
    "password": "#(password)"
    }
    """
    When method POST
    Then status 200
    And match response.isSuccess == true
    * def token = response.data.token

# LOGIN İŞLEMİ
    Given path 'Loginpath/..'
    And request
    """
      {

      "tcIdentityNo": "",
      "birthDate": "",
      "securityCode": ""
      }
    """
    And header Authorization = 'Bearer ' + token
    When method POST
    Then status 200
    And match response.isSuccess == true
    And match response.data.isMember == true
    * def sessionId = response.data.sessionId
    * match sessionId != null
    * print 'sessionId:', sessionId

#PATIENT VERIFY
  Given path 'login/Verify/path..'
  And request
    """
     {
      "sessionId": "#(sessionId)",
      "smsCode": ""

    }
    """
  And header Authorization = 'Bearer ' + token
  When method POST
  Then status 200
  And match response.isSuccess == true

  * def guid = response.data.guid
  * def patientId = response.data.patientId
  * def profileId = response.data.profileId
  * def userId = response.data.userId

  * match guid != null
  * match patientId != null
  * match profileId != null
  * match userId != null

  * print 'guid:', guid
  * print 'patientId:', patientId
  * print 'profileId:', profileId
  * print 'userId:', userId




