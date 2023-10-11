Feature: Search on booking.com
  Scenario: Search by city criteria
    Given User Opens Booking main page
    When User does search in 'London' city
    Then Hotel 'Hawkwood Apartments' should be on the first page
    And Hotel rating is '8.2'