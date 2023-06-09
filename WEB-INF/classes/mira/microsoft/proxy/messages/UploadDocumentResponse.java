/*    */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mira.microsoft.proxy.messages.SharepointResponse;
/*    */ import mira.microsoft.proxy.model.Information;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UploadDocumentResponse
/*    */   extends SharepointResponse
/*    */ {
/*    */   private List<Information> information;
/*    */   
/*    */   public void addInfo(String k, String v) {
/* 19 */     if (this.information == null) {
/* 20 */       this.information = new ArrayList<>();
/*    */     }
/*    */     
/* 23 */     this.information.add(new Information(k, v));
/*    */   }
/*    */ 
/*    */   
/*    */   public void setInformation(List<Information> information) {
/* 28 */     this.information = information;
/*    */   }
/*    */   
/*    */   public List<Information> getInformation() {
/* 32 */     return this.information;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\UploadDocumentResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */