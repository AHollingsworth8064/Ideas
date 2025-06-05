package org.example.utils;


public class Events {
    public triggeredEvent event;

    public Events(){
        this.event = () -> {;};
    }

    public void triggerEvent(){
        this.event.whenTriggered();
    }


}
