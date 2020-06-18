# Tasking
## locker
1. Given locker 有可用容量 When locker存包 Then 存包成功，返回票据
2. Given locker已经存满 When locker存包 Then 存包失败，提示储物柜已满
3. Given 一张有效票据 When locker取包 Then 取包成功
4. Given 一张伪造票据 When locker取包 Then 取包失败，提示非法票据
5. Given 一张重复使用的票据 When locker取包 Then 取包失败，提示非法票据
## primary locker robot
1. Given robot管理两个locker，两个locker都有可用容量; When robot存包; Then 成功存入第一个locker，返回票据
2. Given robot管理两个locker，第一个locker已经存满，第二个locker有可用容量; When robot存包; Then 成功存入第二个locker，返回票据
3. Given robot管理两个locker，两个locker都没有可用容量; When robot存包; Then 存包失败，提示储物柜已满
4. Given robot管理两个locker，拿到一张有效的票; When robot取包; Then 取包成功
5. Given robot管理两个locker，拿到一张伪造的票; When robot取包; Then 取包失败，提示非法票据

## smart locker robot
1. Given robot管理两个locker，第一个locker剩余容量为3，第二个剩余容量为2; When robot存包，Then 成功存入第一个locker，返回票据
2. Given robot管理两个locker，第一个locker剩余容量为2，第二个剩余容量为3; When robot存包，Then 成功存入第二个locker，返回票据
3. Given robot管理两个locker，剩余容量都为2; When robot存包，Then 成功存入第一个locker，返回票据
4. Given robot管理两个locker，且两个locker都存满了; When robot存包，Then 存包失败，提示locker已满
5. Given robot管理两个locker，且拿到有效票; When robot取包，Then 取包成功
6. Given robot管理两个locker，且拿到伪造票; When robot取包，Then 取包失败，提示非法票据

