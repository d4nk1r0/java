/*    */ package WEB-INF.classes.mira.microsoft.proxy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class APIException
/*    */   extends Exception
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public APIException() {}
/*    */   
/*    */   public APIException(String error) {
/* 15 */     super(error);
/*    */   }
/*    */ 
/*    */   
/*    */   public APIException(String error, Throwable cause) {
/* 20 */     super(error);
/* 21 */     initCause(cause);
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\APIException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */