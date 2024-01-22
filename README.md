# 暗算で収入を得るゲーム「CalcMan」
## 概要
- 計算問題が出され、それを解く。正解して得た収入をより多く寄付することが目的。貯蓄がマイナスになると終了。
- VScode 上では標準入力ができたが、ターミナル上での gradle run だとエラーが出たためBotを使用している。

## CalcMan
- このゲームのキャラクター CalcMan は２種類いる。次の収入額を計算し、正解すればそれを得られる。
- 足し算が出題される AddMan 。
- 掛け算が出題される MultiMan 。

## Costing（生活コスト）
- CalcMan は毎回生活コストが貯蓄から引かれる。インフレ率が設定でき、コストは増加していく。
- (次のコスト) = (前のコスト) * (インフレ率)

## Workメソッド
- 計算問題が生成される。
- 誤答すると最初の収入にリセットされる。
- 計算問題に正解して収入を得ると、 Donate か Stock を選べる。
- より多く　Donate を選択した方がいいが、コストで貯蓄がマイナスにならないように Stock も選択する必要がある。
### AddMan の足し算
- 収入に一定の幅で昇給額が足されていく。
- (次の収入) = (前の収入) + (昇給額)
### MultiMan の掛け算
- 収入に一定の倍率が掛けられていく。
- (次の収入) = (前の収入) * (倍率)
### Donate(寄付)
- 総寄付額に収入額が足される。より多く選択することでスコアを高められる。
### Stock(貯蓄)
- 生活コストで貯蓄がマイナスにならないように適宜選択する必要がある。