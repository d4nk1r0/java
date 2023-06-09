/*    */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*    */ 
/*    */ import mira.microsoft.proxy.messages.SharepointRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UploadDocumentRequest
/*    */   extends SharepointRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String docName;
/*    */   private byte[] docContent;
/*    */   private String serverURL;
/*    */   
/*    */   public void setDocName(String docName) {
/* 20 */     this.docName = docName;
/*    */   }
/*    */   
/*    */   public String getDocName() {
/* 24 */     return this.docName;
/*    */   }
/*    */   
/*    */   public void setDocContent(byte[] docContent) {
/* 28 */     this.docContent = docContent;
/*    */   }
/*    */   
/*    */   public byte[] getDocContent() {
/* 32 */     return this.docContent;
/*    */   }
/*    */   
/*    */   public void setServerURL(String serverURL) {
/* 36 */     this.serverURL = serverURL;
/*    */   }
/*    */   
/*    */   public String getServerURL() {
/* 40 */     return this.serverURL;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\UploadDocumentRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */