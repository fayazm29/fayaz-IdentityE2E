We Buy Any Car Test Automation
===================

This is the test automation project for the We Buy Any Car site.

### Running the tests

Run maven with the required properties e.g.

    mvn test

By default, this will run all the tests marked with `@smoke` tags in chrome browser.


#### Chrome Browser
WebdriverManager is used as the dependency to automate driver management instead  of downloading the chromerdriver and setting the path

### System Properties

The following system properties are used to override default values when running tests.

| Name               | Required | Description                                                        |
|--------------------|----------|--------------------------------------------------------------------|
| `driver`           | no       | WebdriverManager no chrome driver installation needed              |
| `browser`          | no       | The browser class is used to set browser types, defaults to chrome |
| `cucumber.options` | no       | Additional option to pass to Cucumber JVM                          |

### Links

* https://www.webuyanycar.com/



----


#### Java JDK 17
The first, is the requirement for Java (SDK). 

If you don't already have this installed locally,

then you should install it before attempting to run any tests. 

Install using the link
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html  

and then set the java jdk bin path in the environmental variables.


#### Maven

Make sure maven is also installed in your local machine. Then set the maven path in the environmental variables.


### Test Data
  I have used one input file car_input_v1.txt and one car_output_v1.txt 

  but the scripts are designed such a way we can re-use the code for different scenarios with different input and output txt files.
   
  Also randomized the mileage


### Test result
I captured the vehicle details which exists after the vehicle search.Only two reg vehicles have the details and compared it with the output file by matching it and that
are not matched also printed to highlight the results as per the task requirements.

![Alt text](images/test-result.png)



####  Html report
The reports can be checked after the test run from reports folder and select the myReport.html and right click on it and open in any browser of your choice.

![Alt text](images/test-report.png)
