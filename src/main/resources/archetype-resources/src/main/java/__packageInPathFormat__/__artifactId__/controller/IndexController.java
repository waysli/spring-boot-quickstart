/**
 * Spring Framework Configuration Files
 */
package ${package}.${artifactId}.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 服务首页
 * @author wangyongsheng
 * @date 16/10/9 下午3:31
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Object status() throws IOException {
        return "ok!";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object status() throws IOException {
        return "App Name: " + ${package}.${artifactId};
    }
}
