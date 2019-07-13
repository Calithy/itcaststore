package test.ylzl.dao.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import ylzl.dao.OrderItemDao;
import ylzl.dao.impl.OrderItemDaoImpl;
import ylzl.dto.OrderItemDTO;

import java.util.List;

/** 
* OrderItemDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 13, 2019</pre> 
* @version 1.0 
*/ 
public class OrderItemDaoImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getByOrderId(String orderId) 
* 
*/ 
@Test
public void testGetByOrderId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getByProductId(String productId) 
* 
*/ 
@Test
public void testGetByProductId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getById(int id) 
* 
*/ 
@Test
public void testGetById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAll() 
* 
*/ 
@Test
public void testSelectAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insert(OrderItem entity) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDeleteId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getByOrderIdAndProductId(String orderId, String productId) 
* 
*/ 
@Test
public void testGetByOrderIdAndProductId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectOrdersById(String orderId) 
* 
*/ 
@Test
public void testSelectOrdersById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectOrderById(String orderId) 
* 
*/ 
@Test
public void testSelectOrderById() throws Exception {
//TODO: Test goes here...
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    List<OrderItemDTO> orderItemDTOList = orderItemDao.selectOrderItemById("0c0796f2-0124-4a13-a891-5efbb63b04f9",4);
    for (OrderItemDTO o : orderItemDTOList
    ) {
        System.out.println(o.getName());
    }
}

/** 
* 
* Method: update(OrderItem entity) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 


} 
