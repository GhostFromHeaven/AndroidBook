# 资源

## Gradle 资源

### gradle-xxx-all.zip

使用 http 协议 替代 https 协议，否则下载很慢
```
http\://services.gradle.org/distributions/gradle-5.1.1-all.zip
```

### 可用的国内仓


## Git

### 生成 key

```bash
ssh-keygen -t rsa -b 2048 -C "author@corpmail.com"
```

### 配置用户名密码

[https://www.cnblogs.com/behindman/p/8686458.html](https://www.cnblogs.com/behindman/p/8686458.html)


全局配置

```bash
#将用户名设为author
git config --global user.name author 

#将用户邮箱设为author@corpmail.com
git config --global user.email author@corpmail.com

cat ~/.gitconfig
[user]
name = author
email = author@corpmail.com
```


工程配置

```bash
#将用户名设为author
git config user.name author 

#将用户邮箱设为author@corpmail.com
git config user.email author@corpmail.com

cat .git/.gitconfig
[user]
name = author
email = author@corpmail.com
```

## 插件

AndroidStudio插件集合

[https://www.jianshu.com/p/469eda65b563](https://www.jianshu.com/p/469eda65b563)



