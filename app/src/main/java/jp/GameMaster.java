package jp;

import jp.ac.uryukyu.ie.e235733.CalcMan;

/**
 * 問題を解決するクラス/
 * ゲームを進める
 */
public class GameMaster {
    /**
     * ゲームを動かすメソッド/
     * CalcManの貯蓄がマイナスになるまで続く
     * @param calcMan AddMan or MultiMan
     * @param calcBot 計算ボット
     */
    public void Play(CalcMan calcMan){
        System.out.println(calcMan.getName() + "の人生が始まった。");

        while (calcMan.getStock() >= 0){
            calcMan.Work();
            
            calcMan.Live();
        }

        System.out.println(calcMan.getName() + "の人生が終わった。");
        System.out.println("総寄付額 : ¥ " + calcMan.getDonating());
    }

}
