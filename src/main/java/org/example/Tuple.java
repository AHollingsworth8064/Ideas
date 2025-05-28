package org.example;

import java.util.Objects;

public class Tuple<X,Y>{
    public X x;
    public Y y;

    public Tuple( X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().isInstance(this)){
            return (((Tuple<?, ?>) obj).x.equals(this.x) && ((Tuple<?, ?>) obj).y.equals(this.y));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
