package designPattern.singleton;

/**
 *
 * 使用单例模式的好处：
 *
 * 对于频繁使用的对象，可以省略创建对象所花费的时间，这对于那些重量级对象而言，是非常可观的一笔系统开销；
 * 由于new操作的次数减少，因而对系统内存的使用频率也会降低，这将减轻GC压力，缩短GC停顿时间。
 * Spring中bean的默认作用域就是singleton(单例)的，除了singleton作用域，Spring中bean还有下面几种作用域：
 *
 * prototype : 每次请求都会创建一个新的 bean 实例。
 * request : 每一次HTTP请求都会产生一个新的bean，该bean仅在当前HTTP request内有效。
 * session : 每一次HTTP请求都会产生一个新的 bean，该bean仅在当前 HTTP session 内有效。
 * global-session： 全局session作用域，仅仅在基于portlet的web应用中才有意义，Spring5已经没有了。Portlet是能够生成语义代码(例如：HTML)片段的小型Java Web插件。它们基于portlet容器，可以像servlet一样处理HTTP请求。但是，与 servlet 不同，每个 portlet 都有不同的会话
 *
 * 场景：单例模式只允许创建一个对象，因此节省内存，加快对象访问速度，因此对象需要被公用的场合适合使用，如多个模块使用同一个数据源连接对象等等。如：
 * 如：
 *     1.需要频繁实例化然后销毁的对象。
 *     2.创建对象时耗时过多或者耗资源过多，但又经常用到的对象。
 *     3.有状态的工具类对象。
 *     4.频繁访问数据库或文件的对象。
 * 以下都是单例模式的经典使用场景：
 *     1.资源共享的情况下，避免由于资源操作时导致的性能或损耗等。如上述中的日志文件，应用配置。
 *     2.控制资源的情况下，方便资源之间的互相通信。如线程池等。
 *
 *
 * @author xiechurong
 * @Date 2021/6/22
 */
public class Client {

    public static void main(String[] args) {
        DCLSingleton instance = DCLSingleton.getSingletonInstanse();
    }
}
