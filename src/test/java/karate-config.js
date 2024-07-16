function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'uat';
  }
  var config = {

    uatURL: 'https://apiuat.org/',
    devURL: ''

  }
  if (env == 'uat') {
    //TOKEN ALMA ADMIN
    config.username = ''
    config.password = ''

  } else if (env == 'dev') {

  }
  return config;
}