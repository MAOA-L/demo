**Spring Boot Project**


---
* Spring Boot + Spring Security `V1.0`
  * bean
    * [User 用户表](https://github.com/MAOA-L/demo/blob/master/src/main/java/top/cyanzoy/demo/bean/User.java)
    * [`User_Role` 用户-角色表]()
    * [Role 角色表]()
    * [`Role_Resource` 角色 - 权限 / 资源表]()
    * [Resource 权限 / 资源表]()
  * component
    * [`CustomFilterInvocationSecurityMetadataSourceImpl` 获取url对应的权限]()
    * [`CustomAccessDecisionManagerImpl` 接上条,对比url与user的权限]()
    * [CustomAuthenticationSuccessHandlerImpl 登录成功]()
    * [CustomAuthenticationFailureHandlerImpl 登陆失败]()
    * [CustomAccessDeniedHandlerImpl 403无权限]()
  * config
    * [`DruidDateSource` 配置Druid数据源]()
    * [`WebSecurityConfig` 配置http访问时的权限]()
  * controller
    * BaseController
  * dao
    * ResourceMapper
    * RoleMapper
    * RoleResourceMapper
    * UserMapper
    * UserRoleMapper
  * security
    
    * [`UserDetailsImpl` Note:当前登录的用户信息 - 与User bean有相似之处]()
        + 实现`UserDetails`接口
        + 封装`用户User` `角色Role`
        
    * [`UserService`]()
        + 实现`UserDetailsService`接口
        + 查找用户,根据用户名查找角色，平且封装并且返回`UserDetailsImpl`对象
    
  * service
    * ResourceService
    * RoleService
  * resource
    * template
    
  
  
 # 以下为流程图
 ![总流程图](https://github.com/MAOA-L/demo/blob/master/src/main/resources/static/images/ExplainThePriciple/总流程.jpg)
 ![登录流程图](https://github.com/MAOA-L/demo/blob/master/src/main/resources/static/images/ExplainThePriciple/登陆流程.jpg)
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  