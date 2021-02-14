# webuitest

This is an **ongoing** project for Web UI automation, using: 

- TestNG: for tests execution
- Selenium: for tests creation
- Junit5: for group assertion
- Maven: for dependencies management
- Slf4j & log4j: for logging
- Allure: for report
- Page Object Model
- Cucumber: BDD style (ongoing)

**Project Structure:**

src/test/java:

- base/ BaseDriver, BasePage, BaseTest
- data/ DataBuilder, Employee, Visitor
- listener
- pom.pages/ DashboardPage, EmployeesPage, LoginPage, VisitorsPage
- pom.testcases/ AddEmployeeTest, AddVisitorTest
- util/ PropertiesReader, RandomUtil, ScreenshotUtil

src/test/resources:
- config
  - config.properties
  - account.properties
- driver
  - chromedriver
  - geckodriver
- allure.properties
- log4j.properties

output:
- logs
- screenshots

pom.xml

testng.xml
