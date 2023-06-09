/*    */ package WEB-INF.classes.mira.microsoft.client;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class RESTResponse {
/*    */   private Integer code;
/*  7 */   private String message = "";
/*    */   private String data;
/*  9 */   private Boolean success = Boolean.FALSE;
/*    */   
/*    */   private HashMap<String, String> extended;
/*    */ 
/*    */   
/*    */   public RESTResponse() {}
/*    */ 
/*    */   
/*    */   public RESTResponse(Integer code, String message) {
/* 18 */     this.code = code;
/* 19 */     this.message = message;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 24 */     return "{code : '" + this.code + "', message: '" + this.message + "', data :  [" + this.data + "] }";
/*    */   }
/*    */ 
/*    */   
/*    */   public void setCode(Integer code) {
/* 29 */     this.code = code;
/*    */   }
/*    */   
/*    */   public Integer getCode() {
/* 33 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 37 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 41 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setData(String data) {
/* 45 */     this.data = data;
/*    */   }
/*    */   
/*    */   public String getData() {
/* 49 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setSuccess(Boolean success) {
/* 53 */     this.success = success;
/*    */   }
/*    */   
/*    */   public Boolean getSuccess() {
/* 57 */     return this.success;
/*    */   }
/*    */   
/*    */   public void setExtended(HashMap<String, String> extended) {
/* 61 */     this.extended = extended;
/*    */   }
/*    */   
/*    */   public HashMap<String, String> getExtended() {
/* 65 */     return this.extended;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\client\RESTResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */