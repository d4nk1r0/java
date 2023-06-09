/*    */ package WEB-INF.classes.mira.microsoft.util;
/*    */ 
/*    */ public class PropertiesUtil
/*    */ {
/*    */   public static String getSysProperty(String key, String defaultValue) {
/*  6 */     String property = defaultValue;
/*    */     try {
/*  8 */       property = System.getProperty(key, defaultValue);
/*    */     }
/* 10 */     catch (Exception e) {
/* 11 */       property = defaultValue;
/*    */     } 
/*    */     
/* 14 */     return property;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsof\\util\PropertiesUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */