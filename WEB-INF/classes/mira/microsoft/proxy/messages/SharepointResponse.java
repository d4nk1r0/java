/*     */ package WEB-INF.classes.mira.microsoft.proxy.messages;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonObject;
/*     */ import mira.microsoft.proxy.messages.IProxyResponse;
/*     */ import mira.microsoft.util.LoggerUtil;
/*     */ 
/*     */ public class SharepointResponse
/*     */   implements IProxyResponse
/*     */ {
/*  11 */   private Boolean success = Boolean.FALSE;
/*     */   
/*     */   private String message;
/*     */   
/*     */   private String detail;
/*     */   
/*     */   private Boolean exists;
/*     */   private Boolean wopIEnabled;
/*     */   private Integer itemCount;
/*     */   private String name;
/*     */   private String uniqueId;
/*     */   private String progID;
/*     */   private String serverRelativeUrl;
/*     */   private String timeCreated;
/*     */   private String timeLastModified;
/*  26 */   private static Gson jsonConverter = new Gson();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static mira.microsoft.proxy.messages.SharepointResponse toJson(String json) {
/*  35 */     LoggerUtil.debug("SharepointResponse:Source2Convert", json);
/*  36 */     JsonObject convertedObject = (JsonObject)jsonConverter.fromJson(json, JsonObject.class);
/*  37 */     mira.microsoft.proxy.messages.SharepointResponse response = new mira.microsoft.proxy.messages.SharepointResponse();
/*     */     
/*  39 */     if (convertedObject != null && convertedObject.get("d") != null) {
/*  40 */       JsonObject data = (JsonObject)convertedObject.get("d");
/*     */       
/*  42 */       if (data.get("Exists") != null) response.setExists(Boolean.valueOf(data.get("Exists").getAsBoolean())); 
/*  43 */       if (data.get("IsWOPIEnabled") != null) response.setWopIEnabled(Boolean.valueOf(data.get("IsWOPIEnabled").getAsBoolean())); 
/*  44 */       if (data.get("ItemCount") != null) response.setItemCount(Integer.valueOf(data.get("ItemCount").getAsInt())); 
/*  45 */       if (data.get("Name") != null) response.setName(data.get("Name").getAsString());
/*     */       
/*  47 */       if (data.get("ServerRelativeUrl") != null) response.setServerRelativeUrl(data.get("ServerRelativeUrl").getAsString()); 
/*  48 */       if (data.get("TimeCreated") != null) response.setTimeCreated(data.get("TimeCreated").getAsString()); 
/*  49 */       if (data.get("TimeLastModified") != null) response.setTimeLastModified(data.get("TimeLastModified").getAsString()); 
/*  50 */       if (data.get("UniqueId") != null) response.setUniqueId(data.get("UniqueId").getAsString());
/*     */     
/*     */     } else {
/*  53 */       if (convertedObject.get("error") != null) {
/*  54 */         if (!convertedObject.get("error").isJsonObject()) {
/*     */           
/*  56 */           response.setMessage(convertedObject.get("error").getAsString());
/*     */         } else {
/*  58 */           JsonObject data = (JsonObject)convertedObject.get("error");
/*     */           
/*  60 */           if (data.get("code") != null && 
/*  61 */             !data.get("code").isJsonObject()) {
/*  62 */             response.setMessage(data.get("code").getAsString());
/*     */           }
/*     */ 
/*     */           
/*  66 */           if (data.get("message") != null) {
/*  67 */             if (data.get("message").isJsonObject()) {
/*  68 */               JsonObject message = (JsonObject)data.get("message");
/*  69 */               response.setDetail(message.get("value").getAsString());
/*     */             } else {
/*     */               
/*  72 */               response.setDetail(data.get("message").getAsString());
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*  79 */       if (convertedObject.get("error_description") != null) {
/*  80 */         response.setDetail(convertedObject.get("error_description").getAsString());
/*     */       }
/*     */     } 
/*     */     
/*  84 */     return response;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSuccess(Boolean success) {
/*  89 */     this.success = success;
/*     */   }
/*     */   
/*     */   public Boolean getSuccess() {
/*  93 */     return this.success;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  97 */     this.message = message;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 101 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setDetail(String detail) {
/* 105 */     this.detail = detail;
/*     */   }
/*     */   
/*     */   public String getDetail() {
/* 109 */     return this.detail;
/*     */   }
/*     */   
/*     */   public void setExists(Boolean exists) {
/* 113 */     this.exists = exists;
/*     */   }
/*     */   
/*     */   public Boolean getExists() {
/* 117 */     return this.exists;
/*     */   }
/*     */   
/*     */   public void setWopIEnabled(Boolean wopIEnabled) {
/* 121 */     this.wopIEnabled = wopIEnabled;
/*     */   }
/*     */   
/*     */   public Boolean getWopIEnabled() {
/* 125 */     return this.wopIEnabled;
/*     */   }
/*     */   
/*     */   public void setItemCount(Integer itemCount) {
/* 129 */     this.itemCount = itemCount;
/*     */   }
/*     */   
/*     */   public Integer getItemCount() {
/* 133 */     return this.itemCount;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 137 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 141 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setUniqueId(String uniqueId) {
/* 145 */     this.uniqueId = uniqueId;
/*     */   }
/*     */   
/*     */   public String getUniqueId() {
/* 149 */     return this.uniqueId;
/*     */   }
/*     */   
/*     */   public void setProgID(String progID) {
/* 153 */     this.progID = progID;
/*     */   }
/*     */   
/*     */   public String getProgID() {
/* 157 */     return this.progID;
/*     */   }
/*     */   
/*     */   public void setServerRelativeUrl(String serverRelativeUrl) {
/* 161 */     this.serverRelativeUrl = serverRelativeUrl;
/*     */   }
/*     */   
/*     */   public String getServerRelativeUrl() {
/* 165 */     return this.serverRelativeUrl;
/*     */   }
/*     */   
/*     */   public void setTimeCreated(String timeCreated) {
/* 169 */     this.timeCreated = timeCreated;
/*     */   }
/*     */   
/*     */   public String getTimeCreated() {
/* 173 */     return this.timeCreated;
/*     */   }
/*     */   
/*     */   public void setTimeLastModified(String timeLastModified) {
/* 177 */     this.timeLastModified = timeLastModified;
/*     */   }
/*     */   
/*     */   public String getTimeLastModified() {
/* 181 */     return this.timeLastModified;
/*     */   }
/*     */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\SharepointResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */