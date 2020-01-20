package com.juliamavenpractice.test;

import org.testng.annotations.*;

/*
To run the different profiles from the terminal we run the command mvn -P{profilename}, for example: mvn -Pregression
This profiles need to be properly configured in the pom.xml file. If we run the 'mvn test' command, all the tests are
going to be executed.
We can find the TestNG reports inside target > surefire-reports folder and we can also delete de target folder with
'mvn clean' command. */
public class TestNG_Grouping {

    @BeforeClass
    public void beforeClass() {
        System.out.println("This method runs before class");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println();
        System.out.println("This method runs before every method");
    }

    @Test(groups = {"Sedan", "BMW"})
    public void BMW3Series() {
        System.out.println("Running Test - BMW 3 Series");
    }

    @Test(groups = {"SUV", "BMW"})
    public void BMWX3() {
        System.out.println("Running Test - BMW X3");
    }

    @Test(groups = {"Sedan", "Audi"})
    public void AudiA6() {
        System.out.println("Running Test - Audi A6");
    }

    @Test(groups = {"Sedan", "Honda"})
    public void HondaAccord() {
        System.out.println("Running Test - Honda Accord");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This method runs after every method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This method runs after class");
    }
}

