/**
 * Index Controller, project entrance
 */
package ${package}.${artifactId}.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import io.swagger.annotations.ApiOperation;

/**
 * 服务首页
 * @author wangyongsheng
 * @date 16/10/9 下午3:31
 */
@RestController
@RequestMapping("/")
public class IndexController {

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
}
