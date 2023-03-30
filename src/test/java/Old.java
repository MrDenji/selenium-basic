import org.testng.Assert;
import org.testng.annotations.*;

public class Old {

    public static int add(int a, int b){
        return a+b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }

    @Test
    public void testAdd(){
        System.out.println("Testuję metodę add");
        Assert.assertEquals(add(2,3), 5);
    }

    @Test
    public void testMulitply(){
        System.out.println("Testuję metodę Multiply");
        Assert.assertEquals(multiply(2,3), 10, "razy x");
    }
    //@Test
    //public void test1(){
    //    System.out.println("Test1");
    //    Assert.assertEquals(true,false);
    //}
    //@Test
    //public void test2(){
    //    System.out.println("Test2");
    //    Assert.assertEquals("false","false");
    //}

    @BeforeClass
    public void beforeClass(){
        System.out.println("Uruchamiam raz pred wszystkimi metodami danej klasy");
    }

    @BeforeMethod
    public void beforeEach(){
        System.out.println("Metoda uruchamiana przed każdym testem");
    }

    @AfterMethod
    public void afterEach(){
        System.out.println("Metoda uruchamiana po każdym teście");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Ta metoda uruchamiana jest raz po wszystkich metodach testsowych");
    }
}
