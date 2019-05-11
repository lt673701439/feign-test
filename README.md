# feign-test使用说明
## 一.启动说明：
### 1.将项目以maven方式导入到IDE工具并完成编译
### 2.依次启动eureka-server、feign-client、feign-eureka
### 3.当eureka-server控制台出现：Registered instance FEIGN-EUREKA...和Registered instance FEIGN-CLIENT/...后说明注册完成
## 二.测试说明：
### 1.测试feign通过http的方式调用普通MVC项目的请求,请访问：http://localhost:2222/feignHttp
### 测试结果：{"aaa":"httpTest 返回成功"}
### 2.测试feign通过eureka注册中心的方式调用普通MVC项目的请求，请访问：http://localhost:2222/feignEureka
### 测试结果：{"bbb": "eurekaTest 返回成功"}
##### 后记：原本想只建一个feign-client项目的，将被调的接口写在这一个项目里，但是发现http的接口能正常访问，eureka的方式则找不到服务，具体是否能实现有待研究。