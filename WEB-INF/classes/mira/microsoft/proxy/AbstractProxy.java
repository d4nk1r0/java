/*    */ package WEB-INF.classes.mira.microsoft.proxy;
/*    */ 
/*    */ import mira.microsoft.proxy.APIException;
/*    */ import mira.microsoft.proxy.IProxy;
/*    */ import mira.microsoft.proxy.messages.IProxyResponse;
/*    */ import mira.microsoft.proxy.messages.MicrosoftAPIRequest;
/*    */ import mira.microsoft.util.LoggerUtil;
/*    */ import mira.microsoft.util.PropertiesUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractProxy
/*    */   implements IProxy
/*    */ {
/*    */   protected static final String BASE_URL = "https://accounts.accesscontrol.windows.net";
/*    */   protected static final String MS_INSTANCE_ID = "7f6f4932-9358-4b44-af1d-4fcf875db732";
/*    */   protected static final String AUTH_SERVICE = "/tokens/OAuth/2";
/*    */   
/*    */   public IProxyResponse execute(MicrosoftAPIRequest request) throws APIException {
/* 21 */     IProxyResponse response = null;
/* 22 */     if (request == null) {
/* 23 */       throw new APIException("Request no válido");
/*    */     }
/*    */     
/* 26 */     LoggerUtil.debug("IProxy", "invocando proxy ");
/*    */     
/* 28 */     response = invoke(request);
/*    */     
/* 30 */     return response;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract IProxyResponse invoke(MicrosoftAPIRequest paramMicrosoftAPIRequest);
/*    */   
/*    */   public static String getAuthURLService() {
/* 37 */     return PropertiesUtil.getSysProperty("sharepoint.authServiceURL", "https://accounts.accesscontrol.windows.net/7f6f4932-9358-4b44-af1d-4fcf875db732/tokens/OAuth/2");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getContentURLService() {
/* 46 */     return PropertiesUtil.getSysProperty("sharepoint.contentServiceURL", "https://ceterimx.sharepoint.com/sites/ProyectMIRA/_api/web/folders");
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\AbstractProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */