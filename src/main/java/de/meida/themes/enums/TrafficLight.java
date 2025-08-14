package de.meida.themes.enums;

import javax.swing.*;

public enum TrafficLight {

    RED {
        enum Light {ON, OFF}
        public TrafficLight nextState() {
            System.out.println(Light.OFF);
            System.out.println("Change To Green");
            return GREEN;
        }
    },
    GREEN
            {
                public TrafficLight nextState() {
                    System.out.println("Change To Yellow");
                    return YELLOW;
                }
            },
    YELLOW
            {
                public TrafficLight nextState() {
                    System.out.println("Change To RED");
                    return RED;
                }
            };

    public abstract TrafficLight nextState();

    public static void main(String[] args) {
        TrafficLight currentState = RED;
        System.out.println(currentState);
        currentState = currentState.nextState();
        System.out.println(currentState);
        System.out.println(currentState.nextState());

        switch (currentState) {
            case RED:
                System.out.println("stehen");
                break;
            case YELLOW:
                System.out.println("bremsen");
                break;
            case GREEN:
                System.out.println("fahren");
                break;
        }

    }
}
