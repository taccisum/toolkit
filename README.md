# Toolkit

`toolkit`提供各种方便开发的java小工具，例如`bean转换器`，`通用策略工厂`等。

`toolkit`还提供与spring boot进行快速集成的starter。

## Getting Started

依赖starter即可，目前仅支持spring boot2快速集成。

```xml
<dependency>
    <groupId>com.cheegu.framework</groupId>
    <artifactId>toolkit-spring-boot2-starter</artifactId>
    <version>{version}</version>
</dependency>
```

## Bean Converter

`Bean Converter`用于抽离您应用中的各种bean之间互相转换的代码，使你的代码看起更优雅。

在使用之前，首先根据实际情况要定义您自己的转换器

```java
@Component
public class String2IntegerConverter extends ConverterSkeleton<String, Integer> {
    @Override
    protected Integer doConvert(String source) {
        return Integer.parseInt(source);
    }
}
```

然后即可以通过`ConverterUtils`提供的相关方法就可以调用转换器

```java
public void foo() {
    int val = ConverterUtils.convert("123", Integer.class);
}
```
您只需要告知ConverterUtils您要转换成的目标类型即可，ConverterUtils会自动根据源类型和目标类型查找到合适的转换器

你也可以使用`import static`让你的代码看起来更优雅

```java
import static com.cheegu.framework.toolkit.converter.util.ConverterUtils.convert;

public void foo() {
    int val = convert("123", Integer.class);
}
```

### Advanced

> 暂无

### Configurations

> 暂无


