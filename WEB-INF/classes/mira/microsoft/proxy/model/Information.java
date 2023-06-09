/*    */ package WEB-INF.classes.mira.microsoft.proxy.model;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlAttribute;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlRootElement
/*    */ public class Information {
/*    */   @XmlAttribute
/*    */   protected String id;
/*    */   
/*    */   public Information(String key, String value) {
/* 14 */     this.id = key;
/* 15 */     this.value = value;
/*    */   } @XmlValue
/*    */   protected String value; public Information() {}
/*    */   public void setId(String id) {
/* 19 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 23 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 27 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 31 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\model\Information.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */