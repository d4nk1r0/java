/*    */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import mira.microsoft.proxy.messages.MicrosoftAPIRequest;
/*    */ 
/*    */ public class SharepointRequest extends MicrosoftAPIRequest {
/*    */   @XmlElement(name = "document")
/*    */   private boolean document;
/*    */   @XmlElement
/* 10 */   private String itemType = "SP.Folder";
/*    */   
/*    */   @XmlElement
/* 13 */   private String serverRelativeUrl = "";
/*    */ 
/*    */   
/*    */   @XmlElement
/*    */   private String token;
/*    */ 
/*    */   
/*    */   public void setDocument(boolean document) {
/* 21 */     this.document = document;
/*    */   }
/*    */   
/*    */   public boolean isDocument() {
/* 25 */     return this.document;
/*    */   }
/*    */   
/*    */   public void setItemType(String itemType) {
/* 29 */     this.itemType = itemType;
/*    */   }
/*    */   
/*    */   public String getItemType() {
/* 33 */     return this.itemType;
/*    */   }
/*    */   
/*    */   public void setServerRelativeUrl(String serverRelativeUrl) {
/* 37 */     this.serverRelativeUrl = serverRelativeUrl;
/*    */   }
/*    */   
/*    */   public String getServerRelativeUrl() {
/* 41 */     return this.serverRelativeUrl;
/*    */   }
/*    */   
/*    */   public String toCreateFolderJSon() {
/* 45 */     return "{\"__metadata\": {\"type\": \"" + getItemType() + "\"},\"ServerRelativeUrl\": \"" + 
/* 46 */       getServerRelativeUrl() + "\"}";
/*    */   }
/*    */   
/*    */   public void setToken(String token) {
/* 50 */     this.token = token;
/*    */   }
/*    */   
/*    */   public String getToken() {
/* 54 */     return this.token;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\SharepointRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */