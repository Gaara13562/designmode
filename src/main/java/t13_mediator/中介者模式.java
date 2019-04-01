/**
 * 中介者模式：：属于行为型模式。
 * 包括两类角色：中介者角色（Mediator）和同事角色（Colleague）
 * - 中介者角色：负责跟各个同事对象打交道
 * - 同事角色：执行具体的业务逻辑，但是相互之间不直接交互，而是通过中介者来进行交互
 * 
 * 中介者模式的本质：
 * – 解耦多个同事对象之间的交互关系。
 * - 每个对象都持有中介者对象的引用，只跟中介者对象打交道，通过中介者对象统一管理这些交互关系。
 * 
 * 常见应用：
 * 1. MVC模式中的C（控制器）
 * 2. 反射中的invoke()方法，就是通过中介者模式实现的，将调用方法的主体也传递过去了
 */
package t13_mediator;