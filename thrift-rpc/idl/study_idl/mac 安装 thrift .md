# mac

# 这个命令会安装最新的 thrift 的软件，然后可以需要配置一下环境变量

```bash
brew install thrift
vim ~/.zshrc

```

# 开启 insert 模式

```bash
export PATH=/opt/homebrew/Cellar/${版本号}/bin:$PATH
```

# 刷新配置信息

```bash
source ~/.bash_profile
```

# 验证结果，一下命令会输出当前的 thrift 的版本号

```bash
thrift --version
```