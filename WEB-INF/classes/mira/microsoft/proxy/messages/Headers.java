/*    */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import mira.microsoft.proxy.messages.Header;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Headers
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   @XmlElement(name = "header")
/* 17 */   private List<Header> headers = new ArrayList<>();
/*    */ 
/*    */   
/*    */   public void setHeaders(List<Header> headers) {
/* 21 */     this.headers = headers;
/*    */   }
/*    */   
/*    */   public List<Header> getHeaders() {
/* 25 */     return this.headers;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\Headers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */