# retrofit 修改版

版本号规则: 开源版本+`.x`; 例如开源版本为 2.10.0, 那么该库的版本号为 2.10.0.x

[原README](./原README.md)

## 1. 特性增加

### 1.1 JsonBody 和 JsonField 注解增加

原本我们写`Json`请求是这样的:

```kotlin
class ApiService {
  @Post("xxxx")
  suspend fun login(@Body jsonStr: String): LoginRet

  // 或
  suspend fun login(@Body body: RequestBody/*或 Map 或 Bean */): LoginRet
}
```

这样的请求我们很难从接口上看到需要什么参数, `Bean` 还好, 但是我们大多数只需要一个参数, 不适合给所有的接口都创建`JavaBean`, 使用 `Map` 或者 `body`
又略显复杂,并且参数`key`需要多处编写(这里不考虑Model/Repository处理);

所以有了这两个注解

```kotlin
@Post("xxxx")
@JsonBody
suspend fun login(@JsonField("userName") userName: String, @JsonField("pwd") pwd: String): LoginRet
```

这样就可以了,参数不一定是String的, 可以是任何可被Json序列化的对象

组装的body内容为

```json
{
  "userName": "xxx",
  "pwd": "xxx"
}
```

注意:**JsonField 只支持json 根节点,不支持嵌套节点的情况(我觉得没必要)**

注意:**kotlin: 如果泛型带Any,要加上 @JvmSuppressWildcards 注解** 例如:

```kotlin
@Post("xxxx")
@JsonBody
suspend fun login(@JsonField("config") otherConfig: Map<String, @JvmSuppressWildcards Any?>): LoginRet
```

## 2 发布配置

本项目只修改了 `retrofit`, 所以只需要发布`retrofit`即可:

根目录下创建文件名:

发布到nexus: 创建 `nexus.properties`
发布到GithubPackages: 创建`github.properties`

内容格式如下:

```
URL=地址
USER_NAME=用户名
PWD=密码
```

命令:

```
#nexus
gradlew clean publishAllPublicationsToNexusRepository

#github packages
gradlew clean publishAllPublicationsToGithubPackagesRepository
```


