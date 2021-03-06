/*
 * Copyright 2013 State University of New York at Oswego
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package edu.oswego.csc480_hci521_2013.shared.h2o.urlbuilders;

import edu.oswego.csc480_hci521_2013.server.ServerUrlEncoder;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bparsons
 */
public class RFBuilderTest {

    UrlEncoder encoder;

    public RFBuilderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        encoder = new ServerUrlEncoder();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setResponseVariable method, of class RFBuilder.
     */
    @Test
    public void testSetResponseVariable() {
        System.out.println("setResponseVariable");
        String value = "test.value";
        RFBuilder instance = new RFBuilder("test.token");
        String expResult = "http://localhost:54321/RF.json?data_key=test.token&response_variable=test.value";
        String result = instance.setResponseVariable(value).build(encoder);
        assertEquals(expResult, result);
    }

    /**
     * Test of testSetNtree method, of class RFBuilder.
     */
    @Test
    public void testSetNtree() {
        System.out.println("setNtree");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?ntree=1&data_key=test.hex";
        String result = instance.setNtree(value).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetStatTypeGini method, of class RFBuilder.
     */
    @Test
    public void testSetStatTypeGini() {
        System.out.println("StatTypeGini");
        boolean value = true;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?stat_type=GINI&data_key=test.hex";
        String result = instance.setStatType(RFBuilder.StatType.GINI).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetStatTypeEntropy method, of class RFBuilder.
     */
    @Test
    public void testSetStatTypeEntropy() {
        System.out.println("StatTypeEntropy");
        boolean value = false;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?stat_type=ENTROPY&data_key=test.hex";
        String result = instance.setStatType(RFBuilder.StatType.ENTROPY).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetClassWeights method, of class RFBuilder.
     */
    @Test
    public void testSetClassWeights() {
        System.out.println("class_weights");
        HashMap<String, Double> values = new HashMap();
        for (int x = 0; x <= 10; x++) {
            values.put(String.valueOf(x), (double) x);
        }
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?data_key=test.hex&class_weights=3%3D3.0%2C2%3D2.0"
                + "%2C10%3D10.0%2C1%3D1.0%2C0%3D0.0%2C7%3D7.0%2C6%3D6.0%2C5%3D5.0%2C4%" + "3D4.0%2C9%3D9.0%2C8%3D8.0";
        String result = instance.setClassWeights(values).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetSamplingStrategyRandom method, of class RFBuilder.
     */
    @Test
    public void testSetSamplingStrategyRandom() {
        System.out.println("SamplingStrategyRandom");
        boolean value = false;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?sampling_strategy=RANDOM&data_key=test.hex";
        String result = instance.setSamplingStrategy(RFBuilder.SamplingStrategy.RANDOM).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetSamplingStrategyStratifiedLocal method, of class
     * RFBuilder.
     */
    @Test
    public void testSetSamplingStrategyStratifiedLocal() {
        System.out.println("SamplingStrategyStratifiedLocal");
        boolean value = true;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?sampling_strategy=STRATIFIED_LOCAL&data_key=test.hex";
        String result = instance.setSamplingStrategy(RFBuilder.SamplingStrategy.STRATIFIED_LOCAL).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetStrataSamples method, of class RFBuilder.
     */
    @Test
    public void testSetStrataSamples() {
        System.out.println("testSetStrata");
        HashMap<String, Integer> values = new HashMap();
        for (int x = 0; x <= 10; x++) {
            values.put(String.valueOf(x), x);
        }
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?strata_samples=3%3D3%2C2%3D2"
                + "%2C10%3D10%2C1%3D1%2C0%3D0%2C7%3D7%2C6%3D6%2C5%3D5%2C4%"
                + "3D4%2C9%3D9%2C8%3D8&data_key=test.hex";
        String result = instance.setStrataSamples(values).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetModelKey method, of class RFBuilder.
     */
    @Test
    public void testSetModelKey() {
        System.out.println("testSetModelKey");
        String value = "test.input";
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?model_key=test.input&data_key=test.hex";
        String result = instance.setModelKey(value).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetOutOfBagErrorEstimate method, of class RFBuilder.
     * Test for false return
     */
    @Test
    public void testSetOutOfBagErrorEstimateFalse() {
        System.out.println("testSetOutOfBagErrorEstimateFalse");
        boolean value = false;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?out_of_bag_error_estimate=0&data_key=test.hex";
        String result = instance.setOutOfBagErrorEstimate(value).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetOutOfBagErrorEstimate method, of class RFBuilder. Test
     * for true return
     */
    @Test
    public void testSetOutOfBagErrorEstimateTrue() {
        System.out.println("testSetOutOfBagErrorEstimateTrue");
        boolean value = true;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?out_of_bag_error_estimate=1&data_key=test.hex";
        String result = instance.setOutOfBagErrorEstimate(value).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetFeatures method, of class RFBuilder. Test
     * for positive return
     */
    
    @Test
    public void testSetFeaturesPositive() {
        System.out.println("testSetFeaturesPositive");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?features=1&data_key=test.hex";
        String result = instance.setFeatures(value).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetFeatures method, of class RFBuilder. Test
     * will fail if exception isnt caught
     */
    public void testSetFeaturesNegativ() {
        System.out.println("testSetFeaturesNegativ");
        Integer value = -1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?features=-1&data_key=test.hex";
        try {
            instance.setFeatures(value).build(encoder);

            fail("expected IllegalArgumentException");

        }
        catch (IllegalArgumentException e) {
            //ignore, this exception is expected.
        }


    }

    
    /**
     * Test of testSetIgnore method, of class RFBuilder. Test
     * 
     */
    
    @Test
    public void testSetIgnore() {
        System.out.println("testSetIgnore");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?data_key=test.hex&ignore=1";
        String result = instance.setIgnore(value).build(encoder);
        assertEquals(expResult, result);

    }
    
     
    /**
     * Test of testSetSample method, of class RFBuilder. Test
     * value is positive and less than 200
     */

    @Test
    public void testSetSamplePass() {
        System.out.println("testSetSamplePass");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?data_key=test.hex&sample=1";
        String result = instance.setSample(value).build(encoder);
        assertEquals(expResult, result);

    }

    
    /**
     * Test of testSetSample method, of class RFBuilder. Test
     * throw exception if wrong value is passed to method
     */
    @Test
    public void testSetSampleFail() {
        System.out.println("testSetSampleFail");
        Integer value = 200;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?sample=200&data_key=test.hex";
        try {
            instance.setSample(value).build(encoder);

            fail("expected IllegalArgumentException");

        }
        catch (IllegalArgumentException e) {
            //ignore, this exception is expected.
        }

    }
    
     /**
     * Test of testSetBinLimit method, of class RFBuilder. Test
     * check for positive integers
     */

    @Test
    public void testSetBinLimitPass() {
        System.out.println("testSetBinLimitPass");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?bin_limit=1&data_key=test.hex";
        String result = instance.setBinLimit(value).build(encoder);
        assertEquals(expResult, result);

    }
     /**
     * Test of testSetBinLimit method, of class RFBuilder. Test
     * throw exception if wrong value is passed to method or negative value
     */

    @Test
    public void testSetBinLimitFail() {
        System.out.println("testSetBinLimitFail");
        Integer value = -100;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?bin_limit=-100&data_key=test.hex";
        try {
            instance.setBinLimit(value).build(encoder);

            fail("expected IllegalArgumentException");

        }
        catch (IllegalArgumentException e) {
            //ignore, this exception is expected.
        }

    }
    
     /**
     * Test of testSetDepth method, of class RFBuilder. Test
     * test for positive integers
     */

    @Test
    public void testSetDepthPass() {
        System.out.println("testSetDepthPass");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?data_key=test.hex&depth=1";
        String result = instance.setDepth(value).build(encoder);
        assertEquals(expResult, result);

    }
    
     /**
     * Test of testSetDepth method, of class RFBuilder. 
     * 
     * Test to check for negative integers, catches thrown exception.
     */

    @Test
    public void testSetDepthFail() {
        System.out.println("testSetDepthFail");
        Integer value = -1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?depth=-1&data_key=test.hex";
        try {
            instance.setDepth(value).build(encoder);

            fail("expected IllegalArgumentException");

        }
        catch (IllegalArgumentException e) {
            //ignore, this exception is expected.
        }
    }
    
    /**
     * Test of testSetSeed method, of class RFBuilder.
     * 
     */

    @Test
    public void testSetSeed() {
        System.out.println("setSeed");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?seed=1&data_key=test.hex";
        String result = instance.setSeed(value).build(encoder);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of testSetParallel method, of class RFBuilder.
     * tests for false return
     */

    @Test
    public void testSetParallelFalse() {
        System.out.println("testSetParallelFalse");
        boolean value = false;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?parallel=0&data_key=test.hex";
        String result = instance.setParallel(value).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetParallel method, of class RFBuilder.
     * tests for true return
     */
    @Test
    public void testSetParallelTrue() {
        System.out.println("testSetParallelTrue");
        boolean value = true;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?parallel=1&data_key=test.hex";
        String result = instance.setParallel(value).build(encoder);
        assertEquals(expResult, result);

    }
    
    /**
     * Test of testSetExclusiveSplitLimit method, of class RFBuilder.
     * tests for valid input
     */

    @Test
    public void testSetExclusiveSplitLimitPass() {
        System.out.println("testSetExclusiveSplitLimitPass");
        Integer value = 1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?exclusive_split_limit=1&data_key=test.hex";
        String result = instance.setExclusiveSplitLimit(value).build(encoder);
        assertEquals(expResult, result);

    }

    /**
     * Test of testSetExclusiveSplitLimit method, of class RFBuilder.
     * tests methods fail catch
     */
    @Test
    public void testSetExclusiveSplitLimitFail() {
        System.out.println("testSetExclusiveSplitLimitFail");
        Integer value = -1;
        RFBuilder instance = new RFBuilder("test.hex");
        String expResult = "http://localhost:54321/RF.json?exclusive_split_limit=-1&data_key=test.hex";
        try {
            instance.setExclusiveSplitLimit(value).build(encoder);

            fail("expected IllegalArgumentException");

        }
        catch (IllegalArgumentException e) {
            //ignore, this exception is expected.
        }
    }
}
