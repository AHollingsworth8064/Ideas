package org.example;

class Row {
    public E[] es;
    public double bias;

    public Row(int size, double bias){
        this.es = new E[size];
        this.bias = bias;

        for(int i  = 0; i <= size;i++){
            es[i] = new E(Math.random()* 10);
        }
    }

    public Row(int size){
        this.es = new E[size];
        this.bias = Math.random()* 10;

        for(int i  = 0; i <= size;i++){
            es[i] = new E(Math.random()* 10);
        }
    }

    class E {
        private double weight;
        private double activateCondtion;

        public E(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return this.weight;
        }
        public double getWeightedOutput(double input){
            return this.weight * input;
        }
        public void setWeight(int weight) {
            this.weight = weight;
        }
       // public boolean activated(){
            //.
       /// }
    }
    private static class Activation{
        private int actviationKey;
        public Activation(int equation){
          this.actviationKey = equation;
        }

        public int getActviationKey() {
            return actviationKey;
        }

        public void setActviationKey(int actviationKey) {
            this.actviationKey = actviationKey;
        }

        public double activateCheck(double val){
            if(this.actviationKey == 0){
                return (val > 1.0)? 1 : 0;
            }
            return 0;
        }
    }
}