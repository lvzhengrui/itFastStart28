###命令

telnet 127.0.0.1 11211

memcached.exe -d install 安装memcached服务
memcached -d start 启动memcached服务

memcached -d uninstall 卸载memcached服
memcached -d restart 重起memcached服务
memcached -d stop|shutdown 关闭正在运行的memcached服务
memcached -p 监听的端口
memcached -l 连接的IP地址, 默认是本机
memcached -u 以的身份运行 (仅在以root运行的时候有效
memcached -m 最大内存使用，单位MB。默认64M
memcached -M 内存耗尽时返回错误，而不是删除
memcached -c 最大同时连接数，默认是102
memcached -f 块大小增长因子，默认是1.2
memcached -n 最小分配空间，key+value+flags默认是4
memcached -h 显示帮助
  
netstat -an
  


###memcached简介
一、 概念
Memcached是danga.com（运营LiveJournal的技术团队）开发的一套分布式内存对象缓存系统，用于在动态系统中减少数据库负载，提升性能。

二、 适用场合

1. 分布式应用。由于memcached本身基于分布式的系统，所以尤其适合大型的分布式系统。

2. 数据库前段缓存。数据库常常是网站系统的瓶颈。数据库的大并发量访问，常常造成网站内存溢出。当然我们也可以使用hibernate的缓存机制。但memcached是基于分布式的，并可独立于网站应用本身，所以更适合大型网站进行应用的拆分。

3. 服务器间数据共享。举例来讲，我们将网站的登录系统、查询系统拆分为两个应用，放在不同的服务器上，并进行集群，那这个时候用户登录后，登录信息如何从登录系统服务器同步到查询系统服务器呢？这时候，我们便可以使用memcached，登录系统将登录信息缓存起来，查询系统便可以获得登录信息，就像获取本地信息一样。

三、 不适用场合

那些不需要“分布”的，不需要共享的，或者干脆规模小到只有一台服务器的应用，memcached不会带来任何好处，相反还会拖慢系统效率，因为网络连接同样需要资源

四、 安装
这里介绍windows环境的安装。
1. 下载memcache的windows稳定版，解压放某个盘下面，比如在c:\memcached
2. 在cmd下输入 'c:\memcached\memcached.exe -d install' 安装
3. 再输入： 'c:\memcached\memcached.exe -d start' 启动。
以后memcached将作为windows的一个服务每次开机时自动启动。这样服务器端已经安装完毕了。


