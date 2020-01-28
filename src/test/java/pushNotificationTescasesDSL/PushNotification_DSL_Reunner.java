package pushNotificationTescasesDSL;

import org.testng.TestNG;

public class PushNotification_DSL_Reunner {
	
	public static TestNG testNG ;
	public static void main(String [] args ) {
		
		testNG = new TestNG();
		testNG.setTestClasses(new Class[] {
				TC001_pushNotification_Home_DSL.class,
				TC002_pushNotification_Tariff_DSL.class,
				TC003_pushNotification_SpeedTest_DSL.class,
				TC004_pushNotification_shopFinder_DSL.class,
				TC005_pushNotification_FAQ_DSL.class,
				TC006_pushNotification_Forums_DSL.class,
				TC007_pushNotification_InvalidForumsDeeplink_DSL.class,
				TC008_pushNotification_BillDeeplink_DSL.class,
				TC009_pushNotification_DataDeeplink_DSL.class,
				TC010_pushNotification_OrderDeeplink_DSL.class,
				TC011_pushNotification_BillNewMappingDeeplink_DSL.class,
				TC012_pushNotification_DataNewMappingDeeplink_DSL_Postpaid.class,
				TC013_pushNotification_MeinTariffNewMapping_DSL_Postpaid.class,
				TC014_pushNotification_TariffNewMapping_DSL_Postpaid.class
		});
		//testNG.run();
		
		
		
		
	}
	
	
	
	

}
