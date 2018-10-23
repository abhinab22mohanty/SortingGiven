package test.java;

import static org.junit.Assert.*;
import main.java.SortDemoData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@RunWith(Parameterized.class)

public class AlgoTest {
    private Integer algoUnderTest = 0;
    private SortDemoData data = null;
    private HashMap<Integer,String> map = new HashMap<>();


    @SuppressWarnings("unchecked")
    public AlgoTest(Integer algoUnderTest) {
        this.algoUnderTest = algoUnderTest;
    }

    @Parameters
    public static Collection<Integer[]> triangleClassesUnderTest() {
        Integer[][] classes = {
                { 0 },
                { 1 },
                { 2 },
                { 3 },
                { 4 },
                { 5 }


        };

        return Arrays.asList(classes);
    }

    @Before
    public void setBefore(){
        map.put(0,"Bubble Sort");
        map.put(1,"Selection Sort");
        map.put(2,"Insertion Sort");
        map.put(3,"Merge Sort");
        map.put(4,"Quick Sort");
        map.put(5,"Heap Sort");

    }
    /**
     * Test for node coverage
     */

    @Test (expected=java.lang.NullPointerException.class)
    public void case1SortNoElem() {
        data.runAlgo(algoUnderTest);

    }


    /**
     * Test for Condition coverage
     */

    @Test
    public void case2SortSingleElement(){
        //Checking for a single element
        SortDemoData data1 ;
        data1 = new SortDemoData();

        data1.initializeArray("1");
        String[] output1 = data1.runAlgo(algoUnderTest).toString().split("\\s");
        assertTrue(map.get(algoUnderTest),Integer.parseInt(output1[5]) == data1.myArray[0].key);


    }
    
    /**
     * Test for Condition coverage
     */
    
    
    @Test
    public void case3SortTwoElements(){
        //Already sorted array
        SortDemoData data2 = new SortDemoData() ;

        int[] testArray = {1,2};
        data2.initializeArray("2 1");
        assertTrue(map.get(algoUnderTest)+" Before Sort ...First Element",data2.myArray[1].key == testArray[0]);
        assertTrue(map.get(algoUnderTest)+" Before Sort ...Second Element",data2.myArray[0].key == testArray[1]);

        data2.runAlgo(algoUnderTest);
        
        if(algoUnderTest != 0)
        {
        assertTrue(map.get(algoUnderTest)+" After Sort ...First Element",data2.myArray[0].key == testArray[0]);
        assertTrue(map.get(algoUnderTest)+" After Sort ...Second Element",data2.myArray[1].key == testArray[1]);
        }
        
        else {
        	  assertFalse(map.get(algoUnderTest)+" After Sort ...First Element",data2.myArray[0].key == testArray[0]);
              assertFalse(map.get(algoUnderTest)+" After Sort ...Second Element",data2.myArray[1].key == testArray[1]);
        }


    }


    /**
     * Test for Branch and condition coverage
     */

    @Test
    public void case4SortSameSequence(){
        //Already sorted array
        SortDemoData data2 = new SortDemoData() ;

        int[] testArray = {1,2,3};
        data2.initializeArray("1 2 3");
        assertTrue(map.get(algoUnderTest)+" Before Sort ...First Element",data2.myArray[0].key == testArray[0]);
        assertTrue(map.get(algoUnderTest)+" Before Sort ...Second Element",data2.myArray[1].key == testArray[1]);
        assertTrue(map.get(algoUnderTest)+" Before Sort ...Third Element",data2.myArray[2].key == testArray[2]);
        data2.runAlgo(algoUnderTest);

        assertTrue(map.get(algoUnderTest)+" After Sort ...First Element",data2.myArray[0].key == testArray[0]);
        assertTrue(map.get(algoUnderTest)+" After Sort ...Second Element",data2.myArray[1].key == testArray[1]);
        assertTrue(map.get(algoUnderTest)+" After Sort ...Third Element",data2.myArray[2].key == testArray[2]);

    }

    /**
     * Test for Branch, condition coverage and node coverage
     */
    @Test
    public void case5SortReversedSequence(){
        //Completely reverse sorted array
        int[] testArray = {1,2,3};
        SortDemoData data3 = new SortDemoData() ;
        data3.initializeArray("3 2 1");
        assertTrue(map.get(algoUnderTest)+" Before Sort ...First Element",data3.myArray[2].key == testArray[0]);
        assertTrue(map.get(algoUnderTest)+" Before Sort ...Second Element",data3.myArray[1].key == testArray[1]);
        assertTrue(map.get(algoUnderTest)+" Before Sort ...Third Element",data3.myArray[0].key == testArray[2]);

        data3.runAlgo(algoUnderTest);

        if(algoUnderTest != 0)
        {
        assertTrue(map.get(algoUnderTest)+" After Sort ...First Element",data3.myArray[0].key == testArray[0]);
        assertTrue(map.get(algoUnderTest)+" After Sort ...Second Element",data3.myArray[1].key == testArray[1]);
        assertTrue(map.get(algoUnderTest)+" After Sort ...Third Element",data3.myArray[2].key == testArray[2]);
        }
        else {
        	 assertFalse(map.get(algoUnderTest)+" After Sort ...First Element",data3.myArray[0].key == testArray[0]);
             assertFalse(map.get(algoUnderTest)+" After Sort ...Second Element",data3.myArray[1].key == testArray[1]);
             assertFalse(map.get(algoUnderTest)+" After Sort ...Third Element",data3.myArray[2].key == testArray[2]);
        }
        
    }


}
