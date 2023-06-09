/*     */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import mira.microsoft.proxy.messages.IProxyResponse;
/*     */ import mira.microsoft.util.LoggerUtil;
/*     */ 
/*     */ public class AuthResponse
/*     */   implements IProxyResponse {
/*  11 */   private static Gson jsonConverter = new Gson();
/*     */ 
/*     */   
/*     */   @SerializedName("token_type")
/*     */   private String tokenType;
/*     */   
/*     */   @SerializedName("token")
/*     */   private String token;
/*     */   
/*     */   @SerializedName("expires_in")
/*     */   private String expiresIn;
/*     */   
/*     */   @SerializedName("not_before")
/*     */   private String notBefore;
/*     */   
/*     */   @SerializedName("expires_on")
/*     */   private String expiresOn;
/*     */   
/*     */   @SerializedName("resource")
/*     */   private String resource;
/*     */   
/*     */   @SerializedName("access_token")
/*     */   private String accessToken;
/*     */   
/*  35 */   private Boolean success = Boolean.FALSE;
/*     */   
/*     */   private String message;
/*     */   
/*     */   private String detail;
/*     */ 
/*     */   
/*     */   public static mira.microsoft.proxy.messages.AuthResponse toJson(String json) {
/*  43 */     LoggerUtil.debug("AuthResponse", json);
/*  44 */     JsonObject convertedObject = (JsonObject)jsonConverter.fromJson(json, JsonObject.class);
/*  45 */     mira.microsoft.proxy.messages.AuthResponse response = new mira.microsoft.proxy.messages.AuthResponse();
/*  46 */     if (!convertedObject.isJsonObject()) {
/*  47 */       LoggerUtil.error("AuthResponse", "Respuesta no es un Json: " + json, null);
/*     */     }
/*     */     else {
/*     */       
/*  51 */       if (convertedObject.get("error") != null) {
/*  52 */         response.setMessage(convertedObject.get("error").getAsString());
/*     */       }
/*     */       
/*  55 */       if (convertedObject.get("error_description") != null) {
/*  56 */         response.setDetail(convertedObject.get("error_description").getAsString());
/*     */       }
/*     */ 
/*     */       
/*  60 */       if (convertedObject.get("access_token") != null) {
/*  61 */         response.setAccessToken(convertedObject.get("access_token").getAsString());
/*     */       }
/*     */ 
/*     */       
/*  65 */       if (convertedObject.get("expires_in") != null) {
/*  66 */         response.setExpiresIn(convertedObject.get("expires_in").getAsString());
/*     */       }
/*     */       
/*  69 */       if (convertedObject.get("not_before") != null) {
/*  70 */         response.setNotBefore(convertedObject.get("not_before").getAsString());
/*     */       }
/*     */       
/*  73 */       if (convertedObject.get("resource") != null) {
/*  74 */         response.setResource(convertedObject.get("resource").getAsString());
/*     */       }
/*     */       
/*  77 */       if (convertedObject.get("token_type") != null) {
/*  78 */         response.setTokenType(convertedObject.get("token_type").getAsString());
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     return response;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTokenType(String tokenType) {
/*  92 */     this.tokenType = tokenType;
/*     */   }
/*     */   
/*     */   public String getTokenType() {
/*  96 */     return this.tokenType;
/*     */   }
/*     */   
/*     */   public void setToken(String token) {
/* 100 */     this.token = token;
/*     */   }
/*     */   
/*     */   public String getToken() {
/* 104 */     return this.token;
/*     */   }
/*     */   
/*     */   public void setSuccess(Boolean success) {
/* 108 */     this.success = success;
/*     */   }
/*     */   
/*     */   public Boolean getSuccess() {
/* 112 */     return this.success;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/* 116 */     this.message = message;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 120 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setDetail(String detail) {
/* 124 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public String getDetail() {
/* 128 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setExpiresIn(String expiresIn) {
/* 132 */     this.expiresIn = expiresIn;
/*     */   }
/*     */   
/*     */   public String getExpiresIn() {
/* 136 */     return this.expiresIn;
/*     */   }
/*     */   
/*     */   public void setNotBefore(String notBefore) {
/* 140 */     this.notBefore = notBefore;
/*     */   }
/*     */   
/*     */   public String getNotBefore() {
/* 144 */     return this.notBefore;
/*     */   }
/*     */   
/*     */   public void setExpiresOn(String expiresOn) {
/* 148 */     this.expiresOn = expiresOn;
/*     */   }
/*     */   
/*     */   public String getExpiresOn() {
/* 152 */     return this.expiresOn;
/*     */   }
/*     */   
/*     */   public void setResource(String resource) {
/* 156 */     this.resource = resource;
/*     */   }
/*     */   
/*     */   public String getResource() {
/* 160 */     return this.resource;
/*     */   }
/*     */   
/*     */   public void setAccessToken(String accessToken) {
/* 164 */     this.accessToken = accessToken;
/*     */   }
/*     */   
/*     */   public String getAccessToken() {
/* 168 */     return this.accessToken;
/*     */   }
/*     */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\AuthResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */