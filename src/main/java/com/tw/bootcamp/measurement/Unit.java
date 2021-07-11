package com.tw.bootcamp.measurement;

enum Unit {

    //Length units
    CM(0.01, 0, UnitType.LENGTH),
    M(1, 0, UnitType.LENGTH),
    KM(1000, 0, UnitType.LENGTH),

    //Weight units
    MG(0.001, 0, UnitType.WEIGHT),
    GM(1, 0, UnitType.WEIGHT),
    KG(1000, 0, UnitType.WEIGHT),

    //Temperature units
    CEL(1, 273.15, UnitType.TEMPERATURE),
    FAH(5.0/9, (5.0/9)*459.67, UnitType.TEMPERATURE),
    KEL(1, 0, UnitType.TEMPERATURE);

    private final double baseFactor;
    private final UnitType unitType;
    private final double constant;

    Unit(double baseUnitFactor, double constant, UnitType unitType) {
        this.baseFactor = baseUnitFactor;
        this.unitType = unitType;
        this.constant = constant;
    }

    double convertToUnit(Unit toUnit, double value) {
        return (double) Math.round((value * (baseFactor / toUnit.baseFactor) + constant)*100)/100;
    }


    boolean isNotCompatibleWith(Unit other) {
        return this.unitType != other.unitType;
    }

}


