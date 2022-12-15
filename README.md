# 已实现的设计模式
## hsr
- State
- Singleton
- MVP
- Flyweight（potion factory
- Factory
- callback
- adapter
- builder
- currying（builder里）
- Command（buff）
- Component
- Delegation（state，委托模式通过将动态工作委托给实现具有相关方法接口的特定对象来实现。
- dependency-injection
- Double Checked Locking，单例检查多次
- extension-objects inventoryitem的拓展（这样应该算是吧
- Façade 一个函数调多个接口，例gamemgr
- Iterator，查看inventory里一类物品
- object-pool（子弹池、怪物池
- Lazy loading
- Multion
- parameter-object
- separated-interface
- subclass-sandbox
- template-method 
- typeobject
- Decorator（攻击有时可以有武器，武器是装饰

## hyl
- strategy（其实choice方法就是strategy）
- proxy (SceneProxy，进场景能不能触发事件，有没有符合条件)
- template (不同场景用同一套模板生成对话)

## hsr预期增加：

- observer
- mediator
  
**还可能增加（意思是我写不动了，你们可以看看哪个好加，还可以看看开头链接里别的设计模式哪些能套：**
- Dirty flag(按道理来讲存读档可以用，我不太会写存储
- Bytecode
- interpreter（翻译txt生成对话？之前用C# 写过一个弱智的txt翻译，大概意思是这样，规定指令对应的String，读取txt时翻译成对应的操作，效果如下 
 - Converter（物体合成？
- Domain-model（理论上来讲用到了吧？跟背包物品相关的一系列操作？背包、背包物体、商店、使用者之类的…… 
- event-driven-architecture 事件驱动，比如写一个事件处理器，npc好感度到xxx发生一个事件，打死xxx只怪物触发一个事件
- event-aggregator 比如Event Aggregator可以从别的npc里收集对玩家的评价，传递给村长，给个村子对玩家的总体评价（有点扯
- execute-around如果写存读档会用到吧
 

