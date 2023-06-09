/*    */ package WEB-INF.classes.mira.microsoft.proxy.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ErrorModel {
/*    */   private String error;
/*    */   private String errorDescription;
/*    */   private String[] errorCodes;
/*    */   private Date timestamp;
/*    */   private String traceId;
/*    */   private String correlationId;
/*    */   
/*    */   public void setError(String error) {
/* 14 */     this.error = error;
/*    */   }
/*    */   
/*    */   public String getError() {
/* 18 */     return this.error;
/*    */   }
/*    */   
/*    */   public void setErrorDescription(String errorDescription) {
/* 22 */     this.errorDescription = errorDescription;
/*    */   }
/*    */   
/*    */   public String getErrorDescription() {
/* 26 */     return this.errorDescription;
/*    */   }
/*    */   
/*    */   public void setErrorCodes(String[] errorCodes) {
/* 30 */     this.errorCodes = errorCodes;
/*    */   }
/*    */   
/*    */   public String[] getErrorCodes() {
/* 34 */     return this.errorCodes;
/*    */   }
/*    */   
/*    */   public void setTimestamp(Date timestamp) {
/* 38 */     this.timestamp = timestamp;
/*    */   }
/*    */   
/*    */   public Date getTimestamp() {
/* 42 */     return this.timestamp;
/*    */   }
/*    */   
/*    */   public void setTraceId(String traceId) {
/* 46 */     this.traceId = traceId;
/*    */   }
/*    */   
/*    */   public String getTraceId() {
/* 50 */     return this.traceId;
/*    */   }
/*    */   
/*    */   public void setCorrelationId(String correlationId) {
/* 54 */     this.correlationId = correlationId;
/*    */   }
/*    */   
/*    */   public String getCorrelationId() {
/* 58 */     return this.correlationId;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\model\ErrorModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */