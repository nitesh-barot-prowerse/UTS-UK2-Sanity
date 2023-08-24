Feature: Verify Quote Module Features


  Background:
    Given User should log in with username "sa" and password "Good2go@2019" to the admin panel
    When User clicks on quote icon on left tool bar

  @Sanity
  Scenario: Manage Quote page displays with list of quotes by clicking on quote icon on left tool bar.
    Then Manage quote page displays with list of quote

  @Sanity
  Scenario:To verify dates under Quote date and Expire date columns displays in dd-mm-yyyy format
    Then User will able to see all data under quote date and expire date column displays with dd-mm-yyyy format

  @Sanity
  Scenario:Data under total and monthly premium column should prefixed by £ sign
    Then User will able to see  all data under total and monthly premium colum prefixed by £ sign


  @Sanity
  Scenario:On the Add Quote page, verify that the Product dropdown appears with list of products
    When User clicks on add quote button
    Then On add quote page product dropdown will appear with desired list

  @Sanity
  Scenario: Respected quote information page will be displayed upon clicking quote number on manage quote page
    When User clicks on quote number on manage quote page
    Then Quote Information page displays with details

  @Sanity
  Scenario: Items on manage quote page displays upon option selects from quote status dropdown
    When User selects appropriate option from quote status dropdown
    Then Respected data will be displayed on Manage quote page

  @Sanity
  Scenario: Fetch list of quote based on product option from product dropdown on manage quote page
    When User selects appropriate option from product dropdown on manage quote page
    And User clicks on search button on manage quote page
    Then Appropriate list of quote will display

  @Sanity
  Scenario: Fetch list of quote based on option from Is referred dropdown on manage quote page
    When User selects appropriate option from Is referred dropdown on manage quote page
    And User clicks on search button on manage quote page
    Then Appropriate list of quote will display upon drop down option


  @Sanity
  Scenario: Fetch list of quote based on pet id products checkbox on manage quote page
    When User selects pet id products checkbox on manage quote page
    And User clicks on search button on manage quote page
    Then Appropriate list of quote will display upon pet id products checkbox on manage quote page


  @Sanity
  Scenario:To check whether user will able able to redirect and see data on microchip file upload page after clicking on upload microchip button on manage quote page
    When User clicks on upload microchip file button
    Then User will be able to see microchip file upload page with data


  @Sanity
  Scenario:Upload details window should open by clicking on file name link on microchip file upload page
    When User clicks on upload microchip file button
    And User clicks on filename link on upload microchip page
    Then Upload details window displays with all details

  @Sanity
  Scenario:Pending Microchip displays with details by clicking on pending microchip button on manage quote page
    When User clicks on pending microchip file button
    Then Pending Microchip page displays with details

#  @Qa
#  Scenario:Fetch quotation based on quote number on manage quote page
#    When User enters quote number inside searc box on manage quote page
#    And User clicks on search button on manage quote page
#    Then Appropriate quote information displays on manage quote page
#
#  @Stage
#  Scenario:Fetch quotation based on quote number on manage quote page
#    When User enters quote number inside search box on manage quote page
#    And User clicks on search button on manage quote page
#    Then Appropriate quote information displays on manage quote page

#    @Qa
#    Scenario: Edit quote details and verifies the same
#    When User enters quote number inside searc box on manage quote page
#    And User clicks on search button on manage quote page
##    And User clicks on quote number from list of quote on manage quote page
#    And User selects edit quote option from cog icon on quote information page
#    Then User can edit all required field on edit quote page
#
#  @Stage
#  Scenario: Edit quote details and verifies the same
#    When User selects edit quote option from cog icon on quote information page
#    Then User can edit all required field on edit quote page




