Feature: Search on booking.com

  Scenario Outline: Search by city criteria
    Given User Opens Booking main page
    When User does search in <City> city
    Then Hotel <Hotel> should be on the first page
    And Hotel <Hotel> rating should be <Rating>

    Examples:
      | Hotel                         | City      | Rating |
      | "Hawkwood Apartments"         | "London"  | "8.2"  |
      | "WH Hotels Papenburg Zentrum" | "Germany" | "8.3"  |
      | "Fregata Kołobrzeg"           | "Poland"  | "9.1"  |