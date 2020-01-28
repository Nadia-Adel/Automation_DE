package sandboxTestCases;

import org.testng.TestNG;
public class RunnerClass {
    
    static TestNG testNG;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        testNG = new TestNG();
        testNG.setTestClasses(new Class[]{UpdateSandBox.class});
        testNG.run();
        
    }
}
