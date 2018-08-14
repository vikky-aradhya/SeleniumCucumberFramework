$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login into an application",
  "description": "",
  "id": "login-into-an-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Login",
  "description": "",
  "id": "login-into-an-application;login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Login_user"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "test data is read from excel \"Login\" under \"Sheet1\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User opens browser",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters the username",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user enters the password",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user clicks on Login",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "the verify the title",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user quits the browser",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Login",
      "offset": 30
    },
    {
      "val": "Sheet1",
      "offset": 44
    }
  ],
  "location": "Login.test_data_is_read_from_excel_under(String,String)"
});
formatter.result({
  "duration": 6644927337,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_opens_browser()"
});
formatter.result({
  "duration": 7115225523,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_enters_the_username()"
});
formatter.result({
  "duration": 3217546096,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_enters_the_password()"
});
formatter.result({
  "duration": 3124486065,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_clicks_on_Login()"
});
formatter.result({
  "duration": 7711261077,
  "status": "passed"
});
formatter.match({
  "location": "Login.the_verify_the_title()"
});
formatter.result({
  "duration": 20099750,
  "status": "passed"
});
formatter.match({
  "location": "Login.user_quits_the_browser()"
});
formatter.result({
  "duration": 2045552459,
  "status": "passed"
});
});