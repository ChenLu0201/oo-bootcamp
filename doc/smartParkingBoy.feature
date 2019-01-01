Feature: Smart parking boy
  Scenario: 停车
    Given two parking lots A and B
    And A has more space
    When park car
    Then park car into A and get a ticket

    Given two parking lots A and B
    And A and B have the same space
    When park car
    Then park car into A and get a ticket

    Given two parking lots A and B
    And B has more space
    When park car
    Then park car into B and get a ticket

    Given two parking lots A and B
    And there is no space
    When park car
    Then park car fail and get an exception

  Scenario: 取车
    Given two parking lots A and B
    And a parked car
    And an available ticket
    When pick car
    Then pick car successfully