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

## Strategy Factories

`Strategy Factories`是通用策略工厂，目的是为j2ee编写中较常使用到的策略模式提供通用的解决方案。

以对象存储为例，假定有4种操作策略（阿里、七牛、腾讯、华为）

### 定义策略接口
必须继承自`com.cheegu.framework.toolkit.strategy.Strategy`
```java
public interface OSSStrategy extends Strategy {
    String upload();
}
```

### 定义策略类
```java
@RegisterStrategy(type = OSSStrategy.class, key = "ALI_YUN")
@Component
public class AliUploadStrategy implements OSSStrategy {
    @Override
    public String upload() {
        return "上传阿里云成功";
    }
}
```

```java
@RegisterStrategy(type = OSSStrategy.class, key = "HUAWEI_YUN")
@Component
public class HuaWeiUploadStrategy implements OSSStrategy {
    @Override
    public String upload() {
        return "上传华为云成功";
    }
}
```

```java
@RegisterStrategy(type = OSSStrategy.class, key = "QI_NIU_YUN")
@Component
public class QiNiuUploadStrategy implements OSSStrategy {
    @Override
    public String upload() {
        return "上传七牛云成功";
    }
}
```

```java
@RegisterStrategy(type = OSSStrategy.class, key = "TECENT_YUN")
@Component
public class TecentUploadStrategy implements OSSStrategy {
    @Override
    public String upload() {
        return "上传腾讯云成功";
    }
}
```

### 在应用代码中获取策略并使用

```java
StrategyFactories.get(OSSStrategy.class, "TECENT_YUN").upload();
```

视情况可以考虑对这个过程做一些封装，例如：
```java
public abstract class StrategyFactoriesFacade {
    public static OSSStrategy getOSSStrategy(String type) {
        return StrategyFactories.get(OSSStrategy.class, type);
    }
}
```

然后通过`getOSSStrategy(String)`来使用OSS策略。



