package edu.gdpu.bookshop.service;

import edu.gdpu.bookshop.entity.MyCart;
import edu.gdpu.bookshop.entity.MyCartExample;
import edu.gdpu.bookshop.mapper.MyCartMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyCartService {

    @Resource
    private MyCartMapper myCartMapper;

    public List<MyCart> findAll(){
        return myCartMapper.selectByExample(new MyCartExample());
    }

    /*添加商品到购物车*/
    public boolean addToMyCart(MyCart cart){
        if(myCartMapper.insert(cart) > 0)
            return true;
        else
            return false;
    }

    /*根据userId 查询购物车记录*/
    public List<MyCart> findMyCartByUserId(Integer userId){
        MyCartExample myCartExample = new MyCartExample();
        MyCartExample.Criteria criteria = myCartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return myCartMapper.selectByExample(myCartExample);
    }

    /*根据 UserId 和 bookId 查询 购物车记录*/
    public MyCart findMyCartByBookId(Integer userId, Integer bookId){
        MyCartExample myCartExample = new MyCartExample();
        MyCartExample.Criteria criteria = myCartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andBookIdEqualTo(bookId);
        List<MyCart> cartList = myCartMapper.selectByExample(myCartExample);
        if(cartList.size() > 0)
            return cartList.get(0);
        else
            return null;
    }

    /*根据 cartId 更新记录*/
    public boolean updateMyCart(MyCart myCart){
       if (myCartMapper.updateByPrimaryKey(myCart) > 0){
           return true;
       } else
           return false;
    }

    /*根据 userId 统计购物车记录*/
    public long getCartCount(Integer userId){
        MyCartExample myCartExample = new MyCartExample();
        MyCartExample.Criteria criteria = myCartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return myCartMapper.countByExample(myCartExample);
    }

    /*根据userId 和 bookName查询购物车记录*/
    public List<MyCart> findMyCartByBookName(Integer userId, String bookName){
        MyCartExample myCartExample = new MyCartExample();
        MyCartExample.Criteria criteria = myCartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andBookNameLike("%"+bookName+"%");
        return myCartMapper.selectByExample(myCartExample);
    }

    /*根据userId, cartIds 进行删除*/
    public boolean deleteByCartIds(Integer userId, List<Integer> cartIds){
        MyCartExample myCartExample = new MyCartExample();
        MyCartExample.Criteria criteria = myCartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCartIdIn(cartIds);
        if(myCartMapper.deleteByExample(myCartExample) > 0)
            return true;
        else
            return false;
    }

    /*根据 userId 进行删除*/
    public boolean deleteAllByUserId(Integer userId){
        MyCartExample myCartExample = new MyCartExample();
        MyCartExample.Criteria criteria = myCartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if(myCartMapper.deleteByExample(myCartExample) > 0)
            return true;
        else
            return false;
    }

    /*根据 List<Integer> cartIds 和 userId 查询购物车记录*/
    public List<MyCart> findMyCartByCartIds(Integer userId, List<Integer> cartIds){
        MyCartExample myCartExample = new MyCartExample();
        MyCartExample.Criteria criteria = myCartExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andCartIdIn(cartIds);
        return myCartMapper.selectByExample(myCartExample);
    }
}
