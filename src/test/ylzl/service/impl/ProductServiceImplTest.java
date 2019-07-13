package test.ylzl.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import ylzl.domain.PageBean;
import ylzl.domain.Product;
import ylzl.service.ProductService;
import ylzl.service.impl.ProductServiceImpl;

/** 
* ProductServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 13, 2019</pre> 
* @version 1.0 
*/ 
public class ProductServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: listAllProducts() 
* 
*/ 
@Test
public void testListAllProducts() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insert(Product product) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getProductById(String id) 
* 
*/ 
@Test
public void testGetProductById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getProductCategory() 
* 
*/ 
@Test
public void testGetProductCategory() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(String id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: listAllProductsByStr(String str) 
* 
*/ 
@Test
public void testListAllProductsByStr() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAllProductBynameWithPage(int pageNum, int pageSize, String f_name) 
* 
*/ 
@Test
public void testFindAllProductBynameWithPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findProductByCategoryWithPage(int pageNum, int pageSize, String category) 
* 
*/ 
@Test
public void testFindProductByCategoryWithPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: listProductWithPage(int pageNum, int pageSize) 
* 
*/ 
@Test
public void testListProductWithPage() throws Exception { 
//TODO: Test goes here...
    ProductService productService = new ProductServiceImpl();
    PageBean pageBean = productService.listProductWithPage(2,4);
    for (Product p :pageBean.getList()
         ) {
        System.out.println(p.getName());
    }

}


/** 
* 
* Method: listAllIds() 
* 
*/ 
@Test
public void testListAllIds() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: update(Product product) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectByConditions(String id, String name, String category, int minPrice, int maxPrice) 
* 
*/ 
@Test
public void testSelectByConditions() throws Exception { 
//TODO: Test goes here... 
} 


} 
