Feature: Parking Manager
  Scenario: park car
    Given no parking boy
    And two available parking lots A and B
    When park car
    Then park car successfully in A and return ticket

    Given no parking boy
    And two parking lots
    And there is no available space
    When park car
    Then park car fail

    Given one parking boy
    And two parking lots
    When park car
    Then park car successfully based on boy's strategy and return ticket

    Given one formal parking boy and one smart parking boy
    And formal parking boy in charge of A & B
    And smart parking boy in charge of C & D
    When park car
    Then park car successfully based on boy's registration order and return ticket

  Scenario: pick car
    Given no parking boy
    And two available parking lots
    And available ticket
    When pick car
    Then pick car successfully