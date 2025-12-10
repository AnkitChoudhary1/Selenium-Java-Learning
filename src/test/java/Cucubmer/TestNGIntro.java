package Cucubmer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGIntro {




        // @Test tells Java: "This is a test case. Run it!"
        @Test
        public void demoTest() {
            System.out.println("Hello! This is my first TestNG test.");

            // This is how we validate in real life
            // Assert.assertEquals(Actual, Expected);
            Assert.assertEquals("Google", "Google");
        }

        @Test
        public void secondTest() {
            System.out.println("This is the second test case.");
        }
    }


