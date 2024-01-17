package com.demo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

@DisplayName("Test class for String class methods.")
public class StringTest{
    
    @BeforeAll //This method runs before executing all methods in a class but only once.
    static void beforeAll(){
        System.out.println("Initailizing the database connection");
    }
    
    @AfterAll //This method runs after executing all methods in a class but only once.
    static void afterAll(){
        System.err.println("Destroying the connection to the database");
    }
    
    @BeforeEach //This method runs before each test method and TestInfo passes method information before executing.
    void beforeEach(TestInfo info){
        System.out.println("Initialize the test data : " + info.getDisplayName());
    }
    
    @AfterEach  //This method runs after each test method.
    void afterEach(){
        System.out.println("Clean up the test data");
    }
    
    @Test 
    void testLength(){
        int actualLength = "Sanjay".length();
        int expectedLength = 6;
        assertEquals(expectedLength, actualLength);
    }
    
    @Test
    void upperCaseBasic(){
        String name = "sanjay";
        String result = name.toUpperCase();
        assertEquals("SANJAY",result);
    }
    
    @Test 
    //This test case will not be executed.
    @Disabled
    @DisplayName("Checks the lowercase of message string")
    void lowerCaseBasic(){
        String name = "SANJAY";
        String result = name.toLowerCase();
        assertEquals("sanjay", result);
    }
    
    @Test
    @RepeatedTest(10)
    @DisplayName("When length is greater than zero, return true")
    //In this test, we are testing the same method on multiple data cases. This is without the parameterized.
    void lengthGreaterThanZero(){
        assertTrue("ABCD".length() > 0);
        assertTrue("ABC".length() > 0);
        assertTrue("ABCDEFGH".length() > 0);
    }
    
    @ParameterizedTest
    //With parameterized tests we can test the same method on multiple data points.
    @DisplayName("Parameterized method for checking lengths not equal to zero")
    @ValueSource(strings={"ABC", "ABC", "ABCDEFGH"})
    void lengthGreaterThanZeroUsingParameterized(String str){
        assertTrue(str.length() > 0);
    }
    
    @ParameterizedTest
    @CsvSource(value={"abc, ABC", "abcd, ABCD", "'',''", "hello, HELLO"})
    void checkTheUppercaseWithParameterized(String word, String capitalizedWord){
        assertEquals(capitalizedWord, word.toUpperCase());
    }
    
    @ParameterizedTest(name="{0} length is {1}")
    @CsvSource(value={"abc, 3", "abcd, 4", "abcdef, 6"})
    void checkLengthWithParameterized(String word, int expectedLength){
        assertEquals(expectedLength, word.length());
    }

    @Test 
    void checkSplitMethod(){
        String message = "abc def ghi";
        String[] actualStrings = message.split(" ");
        String[] expectedStrings = {"abc", "def", "ghi"};
        assertArrayEquals(expectedStrings, actualStrings);
    }
    
    @Test 
    @DisplayName("when length is null, throw an NullPointerException ")
    void checkNullPointerExceptionOnLength(){
        String message = null;
        //Checks if the message string gives NullPointerException when length is invoked.
        //We need to put the code in the lambda function.
        assertThrows(NullPointerException.class, () -> {message.length();});
    }
    @Test
    //checks if this piece of code runs within 5 seconds
    void checkPerformance() {
        assertTimeout(Duration.ofSeconds(5), () -> {
            for (int i = 0; i < 500; i++) {
                int j = i;
            }
        });
    }
}