package org.usfirst.frc.team2508.robot.util;

public class Location {
    Double distance;
    Double angle;
    Type type;

    public Location(Double distance, Double angle, Type type) {
        this.distance = distance;
        this.angle = angle;
        this.type = type;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
