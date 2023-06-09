/*     */ package WEB-INF.classes.mira.microsoft.client;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import mira.microsoft.proxy.messages.Headers;
/*     */ import mira.microsoft.proxy.messages.ParamRequest;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RESTRequest
/*     */ {
/*     */   public static final String POST = "POST";
/*     */   public static final String PUT = "PUT";
/*     */   public static final String GET = "GET";
/*     */   private String targetURL;
/*     */   private String method;
/*     */   private String token;
/*     */   private String data;
/*     */   private boolean json = true;
/*     */   private boolean binary = false;
/*  26 */   private byte[] binaryContent = null;
/*     */   
/*  28 */   private List<ParamRequest> params = new ArrayList<>();
/*     */   
/*     */   @XmlElement(name = "header")
/*  31 */   private Headers headers = new Headers();
/*     */ 
/*     */   
/*     */   public RESTRequest(String url) {
/*  35 */     this.targetURL = url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTargetURL(String targetURL) {
/*  42 */     this.targetURL = targetURL;
/*     */   }
/*     */   
/*     */   public String getTargetURL() {
/*  46 */     return this.targetURL;
/*     */   }
/*     */   
/*     */   public void setMethod(String method) {
/*  50 */     this.method = method;
/*     */   }
/*     */   
/*     */   public String getMethod() {
/*  54 */     return this.method;
/*     */   }
/*     */   
/*     */   public void setHeaders(Headers headers) {
/*  58 */     this.headers = headers;
/*     */   }
/*     */   
/*     */   public Headers getHeaders() {
/*  62 */     return this.headers;
/*     */   }
/*     */   
/*     */   public void setData(String data) {
/*  66 */     this.data = data;
/*     */   }
/*     */   
/*     */   public String getData() {
/*  70 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setJson(boolean json) {
/*  74 */     this.json = json;
/*     */   }
/*     */   
/*     */   public boolean isJson() {
/*  78 */     return this.json;
/*     */   }
/*     */   
/*     */   public void setParams(List<ParamRequest> params) {
/*  82 */     this.params = params;
/*     */   }
/*     */   
/*     */   public List<ParamRequest> getParams() {
/*  86 */     return this.params;
/*     */   }
/*     */   
/*     */   public void setBinary(boolean binary) {
/*  90 */     this.binary = binary;
/*     */   }
/*     */   
/*     */   public boolean isBinary() {
/*  94 */     return this.binary;
/*     */   }
/*     */   
/*     */   public void setBinaryContent(byte[] binaryContent) {
/*  98 */     this.binaryContent = binaryContent;
/*     */   }
/*     */   
/*     */   public byte[] getBinaryContent() {
/* 102 */     return this.binaryContent;
/*     */   }
/*     */   
/*     */   public void setToken(String token) {
/* 106 */     this.token = token;
/*     */   }
/*     */   
/*     */   public String getToken() {
/* 110 */     return this.token;
/*     */   }
/*     */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\client\RESTRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */