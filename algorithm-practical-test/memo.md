## 【java.util.ConcurrentModificationException】

### [error detail]
SNSのuserのfollowをMapで管理していた際に起きたerror  
key = user number, value = follow list by user(key)

error point
```kotlin
val userMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

for (i in 1..Q) {
    val row = readLine()!!.split(" ").map { it.toInt() }
    val S = row[0]
    val from = row[1]
    val followList = userMap[from]!!
```

```kotlin
// By copying the list with toMutableList, ConcurrentModificationException does not occur
followList.toMutableList().forEach { x -> /** error point */
    userMap[x]?.forEach {
        if(it != from) {
            if(!followList.contains(it)) followList.add(it)
        }
    }
}
```

> **Javadoc(ConcurrentModificationException)**  
> <sl>この例外は、**objectの並行変更を検出したmethodによって、そのような変更が許可されていない場合にthrow**されます</sl>。

基本的には、<sl>繰り返しているものが変更されたときに早めに失敗して例外を投げるフェイルファーストするために使用</sl>される。つまり、繰り返し処理を終了する前に例外が発生している。

for-each文はIteratorを使用しているが、あまり冗長ではないが、テストでIteratorを使用するようにいリファクタリングした場合はremove()などの追加のメソッドにアクセスできる。removeメソッドがConcurrentModificationExceptionを引き起こさないため、繰り返しの処理中に呼び出しても大丈夫である。

ArrayListの場合、ArrayListとIteratorは内部で「変更された回数」を保持しており、ArrayListのiterator()メソッドで生成されるIteratorはforで回す際に使うnext()メソッドなどを起動した際に，変更された回数にずれがないかチェックする。ずれを検出したとき、ConcurrentModificationExceptionの例外が発生する。

> **Javadoc(ArrayList)**  
> このクラスの iterator および listIterator メソッドによって返されるイテレータは、フェイルファストです。イテレータの作成後に、イテレータ自体の remove または add メソッド以外の方法でリストが構造的に変更されると、イテレータは ConcurrentModificationException をスローします。このように、並行して変更が行われると、イテレータは、将来の予測できない時点において予測できない動作が発生する危険を回避するために、ただちにかつ手際よく例外をスローします。 通常、非同期の並行変更がある場合、確かな保証を行うことは不可能なので、イテレータのフェイルファストの動作を保証することはできません。フェイルファストイテレータは最善努力原則に基づき、ConcurrentModificationException をスローします。したがって、正確を期すためにこの例外に依存するプログラムを書くことは誤りです。「イテレータのフェイルファストの動作はバグを検出するためにのみ使用すべきです」。


### [Solution]

`toMutableList()` methodを使用してlistをcopyすることでConcurrentModificationExceptionは起きない
