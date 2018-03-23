父工程 管理项目依赖
打包方式：pom

子项目：
    02p2p-home
        前台系统
        打包方式：war
        项目：module

    03p2p-service
        业务层
        打包方式：jar
        项目：module
        父项目：01p2p-parent

    04p2p-management
        后台系统
        打包方式：war
        项目：module
        父项目：01p2p-parent

    05p2p-action
        表现层 使用struts2完成数据操作
        打包方式：war
        项目：module
        父项目：01p2p-parent

    06p2p-jms
        消息队列 activemq
        打包方式：war
        项目：module
        父项目：01p2p-parent

    07p2p-cache
        缓存操作 redis ehcache
        打包方式：jar
        项目：module
        父项目：01p2p-parent

    08p2p-dao
        持久层操作 spring data jpa
        打包方式：jar
        项目：module
        父项目：01p2p-parent

    09p2p-domain
        实体类操作
        打包方式：jar
        项目：module
        父项目：01p2p-parent

    10p2p-shiro
        权限操作 只针对于后台系统 (前后台系统使用的权限机制不一样)
        打包方式：jar
        项目：module
        父项目：01p2p-parent

    11p2p-utils
        工具操作
        打包方式：jar
        项目：module
        父项目：01p2p-parent

    ssh-shiro
        权限单独讲解项目  不与上面的11个项目冲突