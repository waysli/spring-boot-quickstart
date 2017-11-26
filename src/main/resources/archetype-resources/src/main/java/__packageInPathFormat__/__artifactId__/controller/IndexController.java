/**
 * Index Controller, project entrance
 */
package ${package}.${artifactId}.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.swagger.annotations.ApiOperation;

/**
 * 服务首页
 * @author waysli
 * @date 16/10/9 下午3:31
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @Autowired
    private EurekaClient discoveryClient;
    @Value("${eureka.instance.instance-id}")
    private String instanceId;
    @Value("${spring.application.name}")
    private String applicationName;

    @ApiOperation(value = "首页跳转", notes = "无需参数")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @ApiOperation(value = "查看状态", notes = "无需参数")
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Object status() throws IOException {
        return "ok!";
    }

    @ApiOperation(value = "查看项目信息", notes = "无需参数")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object info() throws IOException {
        return "App Name: " + "${package}.${artifactId}";
    }

    @ApiOperation(value = "查看当前服务所有实例的状态", notes = "无需参数")
    @RequestMapping(value = "/getServiceInstances", method = RequestMethod.GET)
    public Object getServiceInstances() throws Exception {
        // 找不到对应的服务名，默认返回Collections.emptyList()
        List<InstanceInfo> instances = discoveryClient.getInstancesByVipAddress(applicationName, true);
        // 按照instanceId递增排列，id最小的在前面，设为master
        instances.sort(Comparator.comparing(InstanceInfo::getInstanceId));

        return instances;
    }

    @ApiOperation(value = "优雅地关闭当前服务实例", notes = "无需参数")
    @RequestMapping(value = "/graceShutdown", method = RequestMethod.GET)
    public Object graceShutdown() throws Exception {
        // 找不到对应的服务名，默认返回Collections.emptyList()
        List<InstanceInfo> instances;
        instances = discoveryClient.getInstancesById(instanceId);
        if (instances.size() > 0) {
            instances.get(0).setStatus(InstanceInfo.InstanceStatus.DOWN);
        }
        discoveryClient.shutdown();

        instances = discoveryClient.getInstancesByVipAddress(applicationName, true);
        // 按照instanceId递增排列，id最小的在前面，设为master
        instances.sort(Comparator.comparing(InstanceInfo::getInstanceId));

        return instances;
    }
}
