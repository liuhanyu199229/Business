package com.formssi.third.aspect;

import com.formssi.third.annotation.Log;
import com.formssi.third.mapper.UmsAdminLogsMapper;
import com.formssi.third.model.UmsAdmin;
import com.formssi.third.model.UmsAdminLogs;
import com.formssi.third.security.util.JwtTokenUtil;
import com.formssi.third.service.UmsAdminCacheService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @author CatalpaFlat
 * @date Created in 2018/7/25 下午5:34
 */
@Slf4j
@Aspect
@Order(4)
@Component
public class LogAspect {
    @Resource
    private UmsAdminLogsMapper umsAdminLogsMapper;
//    @Autowired
//    private TokenMapper tokenMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    //@Before("@annotation(log)")
    public void before(JoinPoint joinPoint, Log log) {
        ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = res.getRequest();
        String authHeader = request.getHeader(this.tokenHeader);
        String authToken = authHeader.substring(this.tokenHead.length());
        String username = jwtTokenUtil.getUserNameFromToken(authToken);
//        UmsAdmin admin = adminCacheService.getAdmin(username);
        String module = log.module();
        String doSome = log.operate();
        UmsAdminLogs logs = new UmsAdminLogs();
        logs.setModel(module);
        logs.setOperation(doSome);
        logs.setAdminId(username);
        logs.setCreateTime(new Date());
        logs.setIsDelete(0);
        umsAdminLogsMapper.insert(logs);
//        String adminUuid = TokenSupport.obtainAdminUuidByAccessToken(tokenMapper);
//        CmsLogPO cmsLog = new CmsLogPO();
//
        ServletRequestAttributes resTemp = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest requestTemp = resTemp.getRequest();
//        String addrTemp = requestTemp.getRemoteAddr();
//
//        String[] controller = module.split(":");
//        String[] action = doSome.split(":");
//        module = controller == null ? module : controller[0];
//        doSome = action == null ? doSome : action[0];
//
//        if(controller.length == 2 && action.length == 2) {
//            cmsLog.setController(controller == null ? module : controller[1]);
//            cmsLog.setAction(action == null ? doSome : action[1]);
//        } else {
//            cmsLog.setController(module);
//            cmsLog.setAction(doSome);
//        }
//        cmsLog.setDesc("管理员在【"+module+"】进行了【"+doSome+"】");
//        cmsLog.setAdminUuid(adminUuid == null ? "" : adminUuid);
//        cmsLog.setOpAddr(addrTemp);
//
//        Object[] obj = joinPoint.getArgs();
//
//        // 符合API设计规范
//        if (obj.length > 0 && obj.length == 1) {
//            Object o = obj[0];
//            cmsLog.setParams(o.toString());
//        }
        System.out.println("===============================================");
        System.out.println("================操作日志==="+module+"===="+doSome+"===========");
        System.out.println("===============================================");
//        cmsAuthorityManageMapper.addLog(cmsLog);

    }
}
