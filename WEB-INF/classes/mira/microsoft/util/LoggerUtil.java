/*    */ package WEB-INF.classes.mira.microsoft.util;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class LoggerUtil
/*    */ {
/*    */   public static void info(String invoker, String message) {
/*  8 */     log("INFO", invoker, message, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void debug(String invoker, String message) {
/* 13 */     log("DEBUG", invoker, message, null);
/*    */   }
/*    */   
/*    */   public static void warn(String invoker, String message) {
/* 17 */     log("WARN", invoker, message, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void error(String invoker, String message, Throwable cause) {
/* 22 */     log("ERROR", invoker, message, cause);
/*    */   }
/*    */   
/*    */   public static void info(String message) {
/* 26 */     log("INFO", null, message, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void debug(String message) {
/* 31 */     log("DEBUG", null, message, null);
/*    */   }
/*    */   
/*    */   public static void warn(String message) {
/* 35 */     log("WARN", null, message, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void error(String message, Throwable cause) {
/* 40 */     log("ERROR", null, message, cause);
/*    */   }
/*    */ 
/*    */   
/*    */   protected static void log(String level, String invoker, String message, Throwable cause) {
/* 45 */     System.out.println(new Date() + "\t[" + level + "]\t[" + invoker + "]\t" + message);
/* 46 */     if (cause != null)
/* 47 */       cause.printStackTrace(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsof\\util\LoggerUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */