package com.tw.bootcamp.measurement;

import java.util.Objects;

public class Measurement {

    private final double magnitude;
    private final Unit unit;

    public static Measurement centimeter(double magnitude) {
        return new Measurement(magnitude, Unit.CM);
    }

    public static Measurement meter(double magnitude) {
        return new Measurement(magnitude, Unit.M);
    }

    public static Measurement kilometer(double magnitude) {
        return new Measurement(magnitude, Unit.KM);
    }

    public static Measurement mgs(double magnitude) {
        return new Measurement(magnitude, Unit.MG);
    }

    public static Measurement gms(double magnitude) {
        return new Measurement(magnitude, Unit.GM);
    }

    public static Measurement kgs(double magnitude ) {
        return new Measurement(magnitude, Unit.KG);
    }

    public static Measurement celsius(double magnitude ) {
        return new Measurement(magnitude, Unit.CEL);
    }

    public static Measurement fahrenheit(double magnitude ) {
        return new Measurement(magnitude, Unit.FAH);
    }

    public static Measurement kelvin(double magnitude ) {
        return new Measurement(magnitude, Unit.KEL);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Measurement that = (Measurement) obj;
        if(this.unit.isNotCompatibleWith(that.unit)) {
            return false;
        }

        return this.convertToBase() == that.convertToBase();
    }

    private Measurement(double magnitude, Unit unit ) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    private double convertToBase() {
        return this.unit.convertToUnit(Unit.M, this.magnitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.convertToBase());
    }

    public Measurement add(Measurement other) {
        double otherConvertedMagnitude = other.unit.convertToUnit(this.unit, other.magnitude);
        return new Measurement(this.magnitude + otherConvertedMagnitude, this.unit);
    }
}

