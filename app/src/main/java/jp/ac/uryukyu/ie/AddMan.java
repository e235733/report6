package jp.ac.uryukyu.ie;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import jp.ac.uryukyu.ie.e235733.Costing;
import jp.ac.uryukyu.ie.e235733.CalcMan;

/**
 * AddManは足し算をするCalcManのクラス/
 * 会社員タイプで、安定している。/
 * 収入はー定の範囲の額で増加し、貯蓄しても昇給は継続される。
 */
public class AddMan extends CalcMan{
    String name;
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    long input;
    long donating = 0;//総寄付額
    long stock;//総貯蓄額
    long baseIncome;
    long nextIncome;//次の給与、計算の答え
    long lastIncome;//前の給与
    Costing cost;
    long amount;
    long raise;
    long raiseBase;
    long raiseBound;

    /**
     * @param _name 名前
     * @param _stock 最初の貯蓄額
     * @param _baseIncome 収入の基準
     * @param _raiseBase 昇給の基準
     * @param _raiseBound 昇給の幅
     * @param _cost 生活コスト
     */
    public AddMan(String _name, long _stock, long _baseIncome, long _raiseBase, long _raiseBound, Costing _cost){
        this.name = _name;
        this.stock = _stock;
        this.baseIncome = _baseIncome;
        this.raiseBase = _raiseBase;
        this.raiseBound = _raiseBound;
        this.cost = _cost;
        this.lastIncome = _baseIncome;
    }

    public long getStock(){
        return this.stock;
    }

    public long getDonating(){
        return this.donating;
    }

    public String getName(){
        return this.name;
    }

    public void donate(){
        this.donating += this.lastIncome;
        System.out.println(this.name + " は寄付した。");
    }

    /**
     * 収入を貯蓄するメソッド/
     * 貯蓄額に収入額が足される/
     * MultiManとは違い貯蓄に回しても収入はリセットされない
     */
    public void stock(){
        this.stock += this.lastIncome;
        System.out.println(this.name + " は貯蓄に回した。");
    }

    public void input(){
        while (true){
            try {
                System.out.println("値を入力してください");
                this.input = sc.nextLong();
                break;
            } catch (InputMismatchException e){
                sc.nextLine();
            }
        }
    }

    public void select(){
        System.out.println("寄付する:1, 貯蓄する:2");
        this.input();
        if (this.input == 1){
            this.donate();
        }
        else if (this.input == 2){
            this.stock();
        }
        else {
            this.select();
        }
    }

    /**
     * 計算をして次の収入を得るメソッド/
     * (次の昇給) = (基準額) + (０〜raiseBound)/
     * min:raiseBase , max:raiseBase + raiseBound - 1/
     * 
     * （次の給与）＝（前の給与）＋（昇給額）/
     * 次の収入が前の収入となる
     */
    @Override
    public void work(){
        this.raise = raiseBase + rand.nextLong(raiseBound);
        System.out.println(this.lastIncome + " + " + this.raise + " ?");
        this.nextIncome = this.lastIncome + this.raise;
        this.input();
        if (this.nextIncome == this.input){ 
            System.out.println("Good Job! " + this.name + "は ¥ " + this.nextIncome + " 稼いだ。");
            this.lastIncome = this.nextIncome;
            this.select();
        }
        else {
            System.out.println("クビになった。" + this.name + "は再就職した。");
            this.lastIncome = this.baseIncome;
        } 
    }

    public void live(){
        this.amount = this.cost.getNextCosting();
        this.stock -= this.amount;
        System.out.println("¥ " + this.amount + " の出費！");
        cost.setLastCosting(this.amount);
        cost.calcCost();
    }

    //for selectBot
    /**
     * SelectBotが期待される最高額の貯蓄額を得るメソッド/
     * (現在の貯蓄) + (前の収入) + (昇給の最高額)
     * @return 貯蓄の最高期待額
     */
    @Override
    public long thinkBest(){
        return this.stock + this.lastIncome + this.raiseBase + this.raiseBound; 
    }

    public long thinkNextCosting(){
        return this.cost.getNextCosting();
    }

    public void selectBot(){
        if (this.getStock() >= this.thinkNextCosting()){
            this.donate();
        }
        else if (this.thinkBest() < this.thinkNextCosting()){
            this.donate();
        }
        else {
            this.stock();
        }
    }
}