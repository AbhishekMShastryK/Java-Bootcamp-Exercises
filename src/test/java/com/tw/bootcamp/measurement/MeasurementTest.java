package com.tw.bootcamp.measurement;

import org.junit.jupiter.api.Test;

import static com.tw.bootcamp.measurement.Measurement.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MeasurementTest {

    @Test
    void should_equate_1_cm_to_1_cm() {
        assertThat(centimeter(1), is(equalTo(centimeter(1))));
    }

    @Test
    void should_not_equate_1_cm_to_2_cm() {
        assertThat(centimeter(1), is(not(equalTo(centimeter(2)))));
    }

    @Test
    void should_equate_100_cm_to_1_m() {
        assertThat(centimeter(100), is(equalTo(meter(1))));
    }

    @Test
    void should_equate_1_km_to_1000_m() {
        assertThat(kilometer(1), is(equalTo(meter(1000))));
    }

    @Test
    void should_equate_distance_hashCodes_correctly() {
        assertThat(kilometer(1).hashCode(), is(equalTo(meter(1000).hashCode())));
    }

    @Test
    void should_equal_2km_add_1_km_to_1000_m() {
        assertThat(kilometer(2), is(equalTo(kilometer(1).add(meter(1000)))));
    }

    //Weight
    @Test
    void should_equate_1_kg_to_1000_gms() {
        assertThat(kgs(1), is(equalTo(gms(1000))));
    }

    @Test
    void should_equate_1_gms_to_1000_mgs() {
        assertThat(gms(1), is(equalTo(mgs(1000))));
    }

    @Test
    void should_equal_2kg_add_1_kg_to_1000_gms() {
        assertThat(kgs(2), is(equalTo(kgs(1).add(gms(1000)))));
    }

    @Test
    void should_not_equate_1_m_to_1_gm() {
        assertThat(meter(1), is(not(equalTo(gms(1)))));
    }

    //Temperature
    @Test
    void should_equate_0_celsius_to_273_15_kelvin() {
        assertThat(celsius(0), is(equalTo(kelvin(273.15))));
    }

    @Test
    void should_not_equate_0_celsius_to_1_fahrenheit() {
        assertThat(celsius(0), is(not(equalTo(fahrenheit(1)))));
    }
    @Test
    void should_equate_0_celsius_to_32_fahrenheit() {
        assertThat(celsius(0), is(equalTo(fahrenheit(32))));
    }

    @Test
    void should_equate_100_fahrenheit_to_310_93_kelvin() {
        assertThat(fahrenheit(100), is(equalTo(kelvin(310.93))));
    }

    @Test
    void should_equal_2_celsius_add_1_celsius_to_1_celsius() {
        assertThat(celsius(2), is(not(equalTo(celsius(1).add(celsius(1))))));
    }

}

