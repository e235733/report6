package jp.ac.uryukyu.ie.e235733;

public class Costing {
    double inflation ;

    long lastCosting;
    long nextCosting;

    public Costing(long _firstCosting, double _inflation){
        this.nextCosting = _firstCosting;
        this.inflation = _inflation;
    }

    public void setLastCosting(long amount){
        this.lastCosting = amount;
    }

    public long getNextCosting(){
        return this.nextCosting;
    }

    public void CalcCost(){
        this.nextCosting = (long) (this.lastCosting * inflation);
        //（次の出費）＝（前の出費）＊（インフレ率）
    }

}
