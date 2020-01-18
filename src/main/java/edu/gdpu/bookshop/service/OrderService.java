package edu.gdpu.bookshop.service;

import com.github.pagehelper.PageHelper;
import edu.gdpu.bookshop.entity.OrderDetail;
import edu.gdpu.bookshop.entity.OrderDetailExample;
import edu.gdpu.bookshop.entity.OrderMaster;
import edu.gdpu.bookshop.entity.OrderMasterExample;
import edu.gdpu.bookshop.mapper.OrderDetailMapper;
import edu.gdpu.bookshop.mapper.OrderMasterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderMasterMapper orderMasterMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    //获取所有的订单数据
    public List<OrderMaster> findAllOrder(){
        return orderMasterMapper.selectByExample(new OrderMasterExample());
    }

    //保存新的 OrderMaster 到 数据库
    public void addOrderMaster(OrderMaster orderMaster){
      orderMasterMapper.insert(orderMaster);
    }

    //保存 orderDetailList 到数据库
    public void addOrderDetailList(List<OrderDetail> orderDetailList){
        for (OrderDetail orderDetail: orderDetailList) {
            orderDetailMapper.insert(orderDetail);
        }
    }

    //更新OrderMaster 的状态
    public void updateOrderMaster(OrderMaster orderMaster){
        orderMasterMapper.updateByPrimaryKey(orderMaster);
    }

    //根据userId 读出 OrderMasterList
    public List<OrderMaster> findOrderMasterByUserId(Integer userId){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return orderMasterMapper.selectByExample(orderMasterExample);
    }

    //统计待付款的订单数
    public long countAllOrder(Integer userId){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return orderMasterMapper.countByExample(orderMasterExample);
    }

    //统计待付款的订单数
    public long countUnpaidOrder(Integer userId){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andOrderStatusEqualTo((byte)0);
        return orderMasterMapper.countByExample(orderMasterExample);
    }

    //统计待发货的订单数
    public long countUnDelivery(Integer userId){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andOrderStatusEqualTo((byte)1);
        return orderMasterMapper.countByExample(orderMasterExample);
    }

    //统计待收货的订单数
    public long countUnreceived(Integer userId){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andOrderStatusEqualTo((byte)2);
        return orderMasterMapper.countByExample(orderMasterExample);
    }

    //统计待评价(已收货)的订单数
    public long countReceived(Integer userId){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andOrderStatusEqualTo((byte)3);
        return orderMasterMapper.countByExample(orderMasterExample);
    }

    /*根据订单号读出订单详情*/
    public List<OrderDetail> findOrderDetailByOrderId(String orderId){
        OrderDetailExample orderDetailExample = new OrderDetailExample();
        OrderDetailExample.Criteria criteria = orderDetailExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        return orderDetailMapper.selectByExample(orderDetailExample);
    }

    /*根据orderId 读出 orderMaster*/
    public OrderMaster findOrderMasterByOrderId(String orderId){
        return orderMasterMapper.selectByPrimaryKey(orderId);
    }

    /*根据orderExample读出orderMasterList*/
    public List<OrderMaster> findOrderByExample(OrderMasterExample orderMasterExample){
        return orderMasterMapper.selectByExample(orderMasterExample);
    }

    /* 查询未付款的订单*/
    public List<OrderMaster> findOrderUnpaid(String userName, String orderId, Integer pageNum){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andOrderStatusEqualTo((byte)0);
        criteria.andUserNameLike("%"+userName+"%");
        criteria.andOrderIdLike("%"+orderId+"%");
        PageHelper.startPage(pageNum, 10);
        return orderMasterMapper.selectByExample(orderMasterExample);
    }

    /*查询未发货的订单*/
    public List<OrderMaster> findOrderUnDelivery(String userName, String orderId, Integer pageNum){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andOrderStatusEqualTo((byte)1);
        criteria.andUserNameLike("%"+userName+"%");
        criteria.andOrderIdLike("%"+orderId+"%");
        PageHelper.startPage(pageNum, 10);
        return orderMasterMapper.selectByExample(orderMasterExample);
    }

    /*查询未收货的订单*/
    public List<OrderMaster> findOrderUnReceived(String userName, String orderId, Integer pageNum){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andOrderStatusEqualTo((byte)2);
        criteria.andUserNameLike("%"+userName+"%");
        criteria.andOrderIdLike("%"+orderId+"%");
        PageHelper.startPage(pageNum, 10);
        return orderMasterMapper.selectByExample(orderMasterExample);
    }

    /*根据userName 和 orderId 查询订单*/
    public List<OrderMaster> findByUnameOrderId(String userName, String orderId, Integer pageNum){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserNameLike("%"+userName+"%");
        criteria.andOrderIdLike("%"+orderId+"%");
        PageHelper.startPage(pageNum, 10);
        return  orderMasterMapper.selectByExample(orderMasterExample);
    }

    public List<OrderMaster> findOrderByTime(String userName, String orderId, Integer pageNum){
        OrderMasterExample orderMasterExample = new OrderMasterExample();
        OrderMasterExample.Criteria criteria = orderMasterExample.createCriteria();
        criteria.andUserNameLike("%"+userName+"%");
        criteria.andOrderIdLike("%"+orderId+"%");
        PageHelper.startPage(pageNum, 10, "create_time desc");
        List<OrderMaster> orderMasterList = orderMasterMapper.selectByExample(orderMasterExample);
        System.out.println("orderMasterList:********** size="+orderMasterList.size());
        return orderMasterList;
        //return orderMasterList.stream().sorted(Comparator.comparing(OrderMaster::getCreateTime).reversed()).collect(Collectors.toList());
    }
}
