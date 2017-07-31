package com.inteview.corejava.stream;

/**
 * Created by linxing on 31/07/2017.
 */
public class Task {

    private final Status status;
    private final Integer points;

    public Task( final Status status, final Integer points ) {
        this.status = status;
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format( "[%s, %d]", status, points );
    }
}
