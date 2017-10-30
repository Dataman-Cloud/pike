# pike  发布管理系统
        pike专注于发布过程的管理，主要实现交付过程自动化的场景。
        pike基于Jenkins做最终的发布，通过Jenkins rest api实现对Jenkins pipeline的管理，
                同时也封装了对发布过程涉及到的其他系统如工单系统、CMDB、LDAP的交互。
        pike可以提取封装原生的Linux脚本和groovy脚本，通过可视化表单录入减少人工编写脚本的工作量、降低人工出错概率。
        pike分为以下几个模块
# pike-api    后台接口模块
        pike-api以HTTP+json对外开放接口
# pike-auth   认证管理模块
        pike-auth是一个独立的模块，支持第三方认证授权。
# pike-common   通用基础模块
        pike-common封装了各个模块都需要用到的工具类和常量类。
# pike-core     业务模块
        pike-core封装了业务层和数据层的操作。
# pike-external     外部系统交互
        pike-external封装与外部系统的交互如Jenkins、CMDB、工单系统、容器云管理平台等。
# pike-ui      前端展示层
        使用vue展示前端ui，前后端分离
