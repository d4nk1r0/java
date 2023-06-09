/*    */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*    */ 
/*    */ public class ParamRequest {
/*    */   private String key;
/*    */   private String value;
/*    */   
/*    */   public ParamRequest() {}
/*    */   
/*    */   public ParamRequest(String k, String v) {
/* 10 */     this.key = k;
/* 11 */     this.value = v;
/*    */   }
/*    */   
/*    */   public void setKey(String key) {
/* 15 */     this.key = key;
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 19 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 23 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 27 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\ParamRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */