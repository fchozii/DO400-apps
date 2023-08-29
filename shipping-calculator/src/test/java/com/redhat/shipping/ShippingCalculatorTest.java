package com.redhat.shipping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingCalculatorTest {

    // @todo: add tests
    // @Test
    // public void canCalcualteTheCostForARegion() throws RegionNotFoundException {
    //     //given
    //     ShippingCalculator calculator = new ShippingCalculator();

    //     //when then
    //     assertEquals(0, calculator.costForRegion("A Region"));
    // }

    @Test
    public void onNARegionTheCostIs100() throws RegionNotFoundException {
        //given
        ShippingCalculator calculator = new ShippingCalculator();
        
        //when then
        assertEquals(100, calculator.costForRegion("NA"));
    }

    @Test
    public void onLATAMRegionTheCostIs200() throws RegionNotFoundException {
        //given
        ShippingCalculator calculator = new ShippingCalculator();
        
        //when then
        assertEquals(200, calculator.costForRegion("LATAM"));
    }

    @Test
    public void onEMEARegionTheCostIs300() throws RegionNotFoundException {
        //given
        ShippingCalculator calculator = new ShippingCalculator();
        
        //when then
        assertEquals(300, calculator.costForRegion("EMEA"));
    }

    @Test
    public void onAPACRegionTheCostIs400() throws RegionNotFoundException {
        //given
        ShippingCalculator calculator = new ShippingCalculator();
        
        //when then
        assertEquals(400, calculator.costForRegion("APAC"));
    }

    @Test
    public void onNonSupportedRegionARegionNotFoundExceptionIsRaised(){
        ShippingCalculator calculator = new ShippingCalculator();

        assertThrows(
            RegionNotFoundException.class, 
            () -> calculator.costForRegion("Unknown Region")
        );
    }
    
}
