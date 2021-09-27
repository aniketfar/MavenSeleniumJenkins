
Feature: How To Execute Selenium Scripts On Already Opened Browser

  @SessionTest
  Scenario: Run Facebook with debugger session on
  Given Run remote debugging port command from chromedevtools
  When Verify the session started on port


    @facebooktest
    Scenario: Perform create account on Facebook
      Given Perform create account on Facebook


