@Navigate
Feature: Navigate bar
  To see the subpages
  Without logging in
  I can click the navigation bar links

  #Como precondicion a usarse en todos los escenarios
  Background: I am on the Free Range Testers web whithout logging in.
        Given I navigate to www.freerangetesters.com

  Scenario Outline: I can access the subpages through the navigation bar
      When I go to <section> using the navigation bar
      Examples:
        | section    |
        | Cursos     |
        | Recursos   |
        | Newsletter |
        | Udemy      |
        | Mentorías  |

@Courses
  Scenario: Courses are presented correctly to potential customers
    When I go to Cursos using the navigation bar
    And selected Introduccion al testing

    @Plans
  Scenario: Users can select a plan when signing up
    When I select Elegin plan
    Then I can validate the options in the checkout page