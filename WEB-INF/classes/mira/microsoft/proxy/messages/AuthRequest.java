/*    */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mira.microsoft.proxy.messages.MicrosoftAPIRequest;
/*    */ import mira.microsoft.proxy.messages.ParamRequest;
/*    */ 
/*    */ public class AuthRequest extends MicrosoftAPIRequest {
/*  9 */   private List<ParamRequest> params = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setParams(List<ParamRequest> params) {
/* 17 */     this.params = params;
/*    */   }
/*    */   
/*    */   public List<ParamRequest> getParams() {
/* 21 */     return this.params;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\AuthRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */