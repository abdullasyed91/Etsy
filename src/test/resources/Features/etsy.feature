Feature: Expedia practice

  Background:
    Given user is on the etsy home page


  Scenario: user is able to sign in with valid credentials
    When user clicks on sign in button and upon entering valid credentials enters submit
    Then user will be able to go the profile from home page

  Scenario: user is unable to sign in with invalid password
    When user click on sign in button and upon entering invalid credentials enters submit
      | email                   | password |
      | abdullasyed91@gmail.com | money8   |
    Then user is shown error "Password was incorrect"

  Scenario: buying candles from the valentine day shop tab
    When user adds lavender candle to cart after navigating to the valentine page
    Then user is able to successfully purchases the candles

  Scenario: buying a pendant from the jewelry tab
    When user navigates to the pendant section in the jewelry tab
    And the user adds the pendant to cart
    Then the user is able to purchase the pendant

  Scenario: buying a size 7 crochet boots from the clothing and shoes tab
    When user navigates to the women's boots in the clothing and shoes tab after signing in
    And the user adds crochet boots to cart
    Then the user validates the boots are in the cart

  Scenario: buy a carbon fiber ring
  When user searches for men rings
  And the user adds the viking ring to cart after clicking on it
  Then the use validates the ring is in the cart

#  Scenario: sign in and clear all the contents from the cart
#    When goes to the cart after signing in
#    And the user removes all the items from the cart
#    Then the cart is empty
