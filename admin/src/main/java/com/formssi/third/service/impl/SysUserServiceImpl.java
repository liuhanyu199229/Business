package com.formssi.third.service.impl;

import com.formssi.third.dao.SysUserDao;
import com.formssi.third.dto.SysUserVo;
import com.formssi.third.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    SysUserDao dao;
    @Override
    public List<SysUserVo> getSysUser(String username) {
        List<SysUserVo> list = dao.getUserList(username);
        List<SysUserVo> list1 = new ArrayList<>();
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("(LPP:)_$^11244^%$_(LPP:)_@@++--(LPP:)_++++_.sds_(LPP:)");
        for(SysUserVo sysUserVo : list){
            log.info(sysUserVo.getCertId());
            log.info(textEncryptor.decrypt(sysUserVo.getCertId()));
            sysUserVo.setCertId(textEncryptor.decrypt(sysUserVo.getCertId()));
            list1.add(sysUserVo);
        }
        return list1;
    }
}
