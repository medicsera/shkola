package org.example;

class Balance {

    int Rweight = 0;
    int Lweight = 0;

    public void addRight(int weight){
        Rweight += weight;
    }
    public void addLeft(int weight) {
        Lweight += weight;
    }
    public void result() {
        if (Rweight == Lweight)
            System.out.println("=");
        else if (Rweight >= Lweight)
            System.out.println("R");
        else System.out.println("L");
    }

}
