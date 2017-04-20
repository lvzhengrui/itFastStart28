
 
--------------------------------------------
###paxos算法之粗浅理解
http://www.cnblogs.com/woshiweige/p/4521165.html
 
###我所理解的Paxos
http://www.tuicool.com/articles/eMnu2aA
http://www.wuzesheng.com/?p=2724&utm_source=tuicool

给某个Proposer发放访问权后，接着被另一个Proposer抢占到了访问权时发生
即第一阶段访问权抢占，被提案号更大的所抢占，即喜新厌旧，
丢掉访问权的，第二段阶必然失败，需重新发起一轮请求

如果之后有人被拒绝，生成了更大的epoch号并发出Prepare请求，就会返回超过半数的现场值，返回的此值成为此人的值，
也就无需进行一步accept阶段，因为最终已经达成了一致

epoch号可采用高位时间戳+低位机器IP组成，保存全局唯一，而且递增

关于Paxos，有几个比较重要的核心点，需要进一步强调:
1. epochNo, 在Paxos中充当了“抢占式锁”的角色，非常重要
2. 新(大)的epochNo到了之后，旧(小)的就不再生效，它所有的请求都会被拒绝
3. 新(epochNo大)的Proposal, 要认可旧值，帮助促成旧值达到一致


 


###分布式系统之Quorum （NRW）算法
http://www.cnblogs.com/netfocus/p/3622184.html#tt_daymode=1&tt_font=m



###抽屉原理(鸽巢原理)
http://baike.baidu.com/link?url=K5wQkUPA1aUoaMOAMWVmZeZT1HWQ9IDeGmpYFMrqzxiBPD_jTJ1FGNn54J1z7UMVxC7u24yJMyfLii2KeAdmYCeOrxfDYRJBD4JOyzjVUBoAOKRmh3pVUxYvycwThiwI







