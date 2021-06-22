package designPattern.builder;

/**
 * 建造者模式：讲一个复杂的对象的构建与他的标识分离，使得同样的构建流程有不同的表示
 * 角色：
 * 产品角色Product： 包含多个组成不见的复杂对象，有具体构造者来构造不同的零部件
 * 抽象构造者Builder：
 * 具体构造者ConcreteBuilder
 * 指挥者Director
 * <p>
 * StringBulder:指挥者类，具有具体建造者的引用，由于StringBuilder继承了AbstractStringBuilder，这里StringBuilder通过super来作为具体建造者的引用。
 * AbstrctStringBuilder:具体建造者，实现了appendable接口的append(Character c)方法
 * appendable：抽象构造者，定义创建对象的接口
 * <p>
 * <p>
 * 场景：游戏菜单中画面配置（根据不同程度配置有不同的显示效果）
 * 创建的对象较复杂，由多个部件构成，各部件面临着复杂的变化，但构件间的建造顺序是稳定的。
 * 创建复杂对象的算法独立于该对象的组成部分以及它们的装配方式，即产品的构建过程和最终的表示是独立的。
 *
 *  优点：首先是易于解耦，将产品本身与产品创建过程进行解耦，可以使用相同的创建过程来得到不同的产品。也就说细节依赖抽象。
 *  其次易于精确控制对象的创建，将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰
 *  最后是易于拓展，增加新的具体建造者无需修改原有类库的代码，易于拓展，符合“开闭原则“。
 *
 *  缺点：
 *  建造者模式所创建的产品一般具有较多的共同点，其组成部分相似；
 *  如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制；
 *  如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大。
 *
 *  参考博文：https://blog.csdn.net/Arthurs_L/article/details/81287128
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Client {

    public static void main(String[] args) {

        Builder builder = new ConcreteBuilder();

        Director director = new Director(builder);

        Product product = director.construct();

    }

}
