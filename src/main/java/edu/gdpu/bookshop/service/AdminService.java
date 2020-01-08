package edu.gdpu.bookshop.service;

import edu.gdpu.bookshop.entity.Admin;
import edu.gdpu.bookshop.entity.AdminExample;
import edu.gdpu.bookshop.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    //根据管理员和密码查询管理员
    public Admin findAdmin(String adminName, String password){
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(adminName);
        criteria.andPasswordEqualTo(password);

        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size() > 0){
            return admins.get(0);
        } else
            return null;
    }

    //更新管理员信息
    public boolean updateAdmin(Admin admin){
        if(adminMapper.updateByPrimaryKey(admin) > 0){
            return true;
        } else
            return false;
    }
}
