package edu.gdpu.bookshop.service;

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
}
