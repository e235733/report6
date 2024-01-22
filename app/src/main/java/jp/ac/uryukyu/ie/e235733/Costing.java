package jp.ac.uryukyu.ie.e235733;

/**
 * 生活コストのクラス
 */
public class Costing {
    double inflation ;
    long lastCosting;
    long nextCosting;

    /**
     * @param _firstCosting 初月のコスト
     * @param _inflation 毎月のインフレ率
     */
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

    /**
     * 次のコストを計算するメソッド
     * (次のコスト) = (前のコスト) * (インフレ率)
     */
    public void calcCost(){
        this.nextCosting = (long) (this.lastCosting * inflation);
    }
}