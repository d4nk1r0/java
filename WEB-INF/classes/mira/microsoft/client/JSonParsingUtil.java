/*    */ package WEB-INF.classes.mira.microsoft.client;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import java.util.Date;
/*    */ import mira.microsoft.proxy.model.ErrorModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JSonParsingUtil
/*    */ {
/* 12 */   static Gson gson = new Gson();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String sampleData = "{\"error\": \"invalid_request\",\"error_description\": \"AADSTS9000410: Malformed JSON.\r\nTrace ID: fca15e78-f519-4c06-a297-82b533a90400\r\nCorrelation ID: a8e3c030-7373-4a5f-9698-9bb03b337af0\r\nTimestamp: 2020-05-13 03:09:18Z\",\"error_codes\": [   9000410],\"timestamp\": \"2020-05-13 03:09:18Z\",\"trace_id\": \"fca15e78-f519-4c06-a297-82b533a90400\",\"correlation_id\": \"a8e3c030-7373-4a5f-9698-9bb03b337af0\"}";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ErrorModel parsingError(String data) {
/* 24 */     ErrorModel error = null;
/* 25 */     return error;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] data) {
/* 30 */     ErrorModel errorModel = new ErrorModel();
/* 31 */     errorModel.setError("019");
/*    */     
/* 33 */     errorModel.setTimestamp(new Date());
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\client\JSonParsingUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */