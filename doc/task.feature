Feature: Parking boy
  Scenario: 停车
    Given 有一个停车场且有车位
    When 停车
    Then 停车成功且获取车票

    Given 有一个停车场且停满
    When 停车
    Then 停车失败

    Given 有两个停车场且第一个停车场有空位
    When 停车
    Then 成功停车到第一个停车场且获取车票

    Given 有两个停车场且只有第二个有空位
    When 停车
    Then 停车第二个停车场成功且获取车票

    Given 两个停车场都停满
    When 停车
    Then 停车失败
  Scenario: 取车
    Given 有一个停车场
    When 凭票取车
    Then 取车成功

    Given 有两个停车场，车载第一个车库
    When 凭票取车
    Then 取车成功

    Given 有两个停车场，车在第二个车库
    When 凭票取车
    Then 取车成功

    Given 有两个停车场
    When 凭无效车票取车
    Then 取车失败

