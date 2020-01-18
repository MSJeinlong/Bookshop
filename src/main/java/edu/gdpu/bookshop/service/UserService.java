package edu.gdpu.bookshop.service;

import com.github.pagehelper.PageHelper;
import edu.gdpu.bookshop.entity.BsUser;
import edu.gdpu.bookshop.entity.BsUserExample;
import edu.gdpu.bookshop.mapper.BsUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private BsUserMapper userMapper;

    public List<BsUser> findAllUsers() {
        return userMapper.selectByExample(new BsUserExample());
    }

    //根据手机号码和密码查询用户
    public BsUser findUserByCellphone(String cellphone, String password){
        BsUserExample bsUserExample = new BsUserExample();
        BsUserExample.Criteria criteria = bsUserExample.createCriteria();
        //设置查询条件
        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(password);

        List<BsUser> bsUsers = userMapper.selectByExample(bsUserExample);
        if(bsUsers.size() > 0){
            return bsUsers.get(0);
        } else {
            return null;
        }
    }

    //根据邮箱和密码查询用户
    public BsUser findUserByEmail(String email, String password){
        BsUserExample bsUserExample = new BsUserExample();
        BsUserExample.Criteria criteria = bsUserExample.createCriteria();
        //设置查询条件
        criteria.andEmailEqualTo(email);
        criteria.andPasswordEqualTo(password);

        List<BsUser> bsUsers = userMapper.selectByExample(bsUserExample);
        if(bsUsers.size() > 0){
            return bsUsers.get(0);
        } else {
            return null;
        }
    }

    //根据昵称和密码查询用户
    public BsUser findUserByNickName(String nickname, String password){
        BsUserExample bsUserExample = new BsUserExample();
        BsUserExample.Criteria criteria = bsUserExample.createCriteria();
        //设置查询条件
        criteria.andNicknameEqualTo(nickname);
        criteria.andPasswordEqualTo(password);

        List<BsUser> bsUsers = userMapper.selectByExample(bsUserExample);
        if(bsUsers.size() > 0){
            return bsUsers.get(0);
        } else {
            return null;
        }
    }

    //根据手机号码获取用户
    public BsUser findUserByTel(String cellphone){
        BsUserExample bsUserExample = new BsUserExample();
        BsUserExample.Criteria criteria = bsUserExample.createCriteria();
        //设置查询条件
        criteria.andCellphoneEqualTo(cellphone);

        List<BsUser> bsUsers = userMapper.selectByExample(bsUserExample);
        if(bsUsers.size() > 0){
            return bsUsers.get(0);
        } else {
            return null;
        }
    }

    //保存注册用户
    public boolean addUser(BsUser user){
        int res = userMapper.insert(user);
        if(res > 0)
            return true;
        else
            return false;
    }

    //更新用户的信息
    public void updateUser(BsUser user){
        userMapper.updateByPrimaryKey(user);
    }

    //用户更新信息时判断邮箱是否重复
    public boolean isRepeatEmail(BsUser user){
        BsUserExample bsUserExample = new BsUserExample();
        BsUserExample.Criteria criteria = bsUserExample.createCriteria();
        //设置查询条件
        criteria.andEmailEqualTo(user.getEmail());

        List<BsUser> bsUsers = userMapper.selectByExample(bsUserExample);
        for (BsUser u: bsUsers) {
            if(u.getUserId() != user.getUserId())
                return true;
        }
        return false;
    }

    //用户更新信息时判断昵称是否重复
    public boolean isRepeatNickName(BsUser user){
        BsUserExample bsUserExample = new BsUserExample();
        BsUserExample.Criteria criteria = bsUserExample.createCriteria();
        //设置查询条件
        criteria.andNicknameEqualTo(user.getNickname());

        List<BsUser> bsUsers = userMapper.selectByExample(bsUserExample);
        for (BsUser u: bsUsers) {
            if(u.getUserId() != user.getUserId())
                return true;
        }
        return false;
    }

    public BsUser findUserById(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public void deleteUserById(Integer userId){
        userMapper.deleteByPrimaryKey(userId);
    }

    public List<BsUser> findUserBynicknameAndTel(String nickname, String cellphone, Integer pageNum){
        BsUserExample userExample = new BsUserExample();
        BsUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNicknameLike("%"+nickname+"%");
        criteria.andCellphoneLike("%"+cellphone+"%");
        PageHelper.startPage(pageNum, 10);
        return userMapper.selectByExample(userExample);
    }
}
