/*    */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import mira.microsoft.proxy.messages.Headers;
/*    */ import mira.microsoft.proxy.messages.ParamRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MicrosoftAPIRequest
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   protected String interfaceId;
/*    */   @XmlElement(name = "headers")
/* 18 */   protected Headers headers = new Headers();
/*    */   
/*    */   @XmlElement(name = "param")
/* 21 */   private List<ParamRequest> params = new ArrayList<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getInterfaceId() {
/* 29 */     return this.interfaceId;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setInterfaceId(String id) {
/* 34 */     this.interfaceId = id;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setHeaders(Headers headers) {
/* 39 */     this.headers = headers;
/*    */   }
/*    */   
/*    */   public Headers getHeaders() {
/* 43 */     return this.headers;
/*    */   }
/*    */   
/*    */   public void setParams(List<ParamRequest> params) {
/* 47 */     this.params = params;
/*    */   }
/*    */   
/*    */   public List<ParamRequest> getParams() {
/* 51 */     return this.params;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\MicrosoftAPIRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */