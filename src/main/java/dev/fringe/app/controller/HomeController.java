package dev.fringe.app.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.spring.annotation.ParamDataSet;
import com.nexacro.spring.data.NexacroResult;
import com.nexacro.xapi.data.PlatformData;
import com.nexacro.xapi.tx.PlatformType;
@Controller
public class HomeController {

    @RequestMapping(value = "/test")
    public NexacroResult test(HttpSession session, PlatformData platformData) {
        NexacroResult nexaResult = new NexacroResult();
        nexaResult.addVariable("ErrorCode", "12323");
        nexaResult.addVariable("ErrorMsg", "success");
        return nexaResult;
    }
    
    @RequestMapping(value = "/workflow/iom/iomListNexa")
    public NexacroResult iomListNexa(HttpSession session ,PlatformData platformData, @ParamDataSet(name = "ds") Map<String, Object> map) {
        System.out.println(platformData.getDataSet("ds"));
        System.out.println(map);
        NexacroResult nexaResult = new NexacroResult();
        nexaResult.addVariable("ErrorCode", "12323");
        nexaResult.addVariable("ErrorMsg", "success");
        return nexaResult;
    }
}
