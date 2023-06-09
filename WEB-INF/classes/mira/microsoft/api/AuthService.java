/*    */ package WEB-INF.classes.mira.microsoft.api;
/*    */ 
/*    */ import javax.jws.WebMethod;
/*    */ import javax.jws.WebParam;
/*    */ import javax.jws.WebService;
/*    */ import mira.microsoft.client.RESTClientWrapper;
/*    */ import mira.microsoft.client.RESTRequest;
/*    */ import mira.microsoft.client.RESTResponse;
/*    */ import mira.microsoft.proxy.APIException;
/*    */ import mira.microsoft.proxy.SharepointProxy;
/*    */ import mira.microsoft.proxy.messages.AuthResponse;
/*    */ import mira.microsoft.proxy.messages.Header;
/*    */ import mira.microsoft.proxy.messages.MicrosoftAPIRequest;
/*    */ import mira.microsoft.proxy.messages.ParamRequest;
/*    */ import mira.microsoft.util.LoggerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebService(serviceName = "AuthService")
/*    */ public class AuthService
/*    */ {
/* 23 */   private RESTClientWrapper wrapper = new RESTClientWrapper();
/*    */ 
/*    */   
/*    */   @WebMethod(operationName = "authenticate")
/*    */   public AuthResponse invoke(@WebParam(name = "authenticateRequest") MicrosoftAPIRequest payload) {
/* 28 */     AuthResponse response = new AuthResponse();
/*    */     
/* 30 */     LoggerUtil.debug("AuthService", "Invocando servicio de autenticación");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 38 */     RESTRequest proxyRequest = new RESTRequest(SharepointProxy.getAuthURLService());
/* 39 */     proxyRequest.setJson(true);
/* 40 */     proxyRequest.setParams(payload.getParams());
/* 41 */     proxyRequest.setMethod("POST");
/* 42 */     proxyRequest.getHeaders().getHeaders().add(new Header("Content-Type", "application/x-www-form-urlencoded"));
/*    */ 
/*    */     
/* 45 */     proxyRequest.setData("");
/*    */ 
/*    */     
/*    */     try {
/* 49 */       RESTResponse pxyResponse = this.wrapper.invoke(proxyRequest);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 55 */       response = AuthResponse.toJson(pxyResponse.getData());
/* 56 */       if (pxyResponse.getSuccess().booleanValue()) {
/* 57 */         response.setMessage("Autenticación realizada correctamente");
/* 58 */         response.setSuccess(Boolean.TRUE);
/*    */       } else {
/*    */         
/* 61 */         response.setMessage("Autenticación fallida. " + response.getMessage());
/* 62 */         response.setDetail(pxyResponse.getCode() + " - " + pxyResponse.getMessage() + ". " + response.getDetail());
/* 63 */         response.setSuccess(Boolean.FALSE);
/*    */       }
/*    */     
/*    */     }
/* 67 */     catch (APIException e) {
/* 68 */       LoggerUtil.error("AuthService", "Error invocando servicio de autenticación", (Throwable)e);
/* 69 */       response.setSuccess(Boolean.FALSE);
/*    */     } 
/*    */ 
/*    */     
/* 73 */     return response;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 78 */     mira.microsoft.api.AuthService service = new mira.microsoft.api.AuthService();
/*    */     
/* 80 */     MicrosoftAPIRequest request = new MicrosoftAPIRequest();
/* 81 */     request.getHeaders().getHeaders().add(new Header("Content-Type", "application/x-www-form-urlencoded"));
/*    */     
/* 83 */     request.getHeaders().getHeaders().add(new Header("Host", ""));
/* 84 */     request.getHeaders().getHeaders().add(new Header("User-Agent", "PostmanRuntime/7.24.1"));
/* 85 */     request.getHeaders().getHeaders().add(new Header("Accept", "*/*"));
/* 86 */     request.getHeaders().getHeaders().add(new Header("Accept-Encoding", "gzip, deflate, br"));
/* 87 */     request.getHeaders().getHeaders().add(new Header("Connection", "keep-alive"));
/*    */     
/* 89 */     request.getParams().add(new ParamRequest("grant_type", "client_credentials"));
/* 90 */     request.getParams().add(new ParamRequest("resource", "00000003-0000-0ff1-ce00-000000000000/ceterimx.sharepoint.com@7f6f4932-9358-4b44-af1d-4fcf875db732"));
/* 91 */     request.getParams().add(new ParamRequest("client_id", "6d93e2c7-e69d-4257-805c-01a9a9bb81a5@7f6f4932-9358-4b44-af1d-4fcf875db732\n"));
/* 92 */     request.getParams().add(new ParamRequest("client_secret", ":AZIPCO=o5D?2u6:NSnc2UOb0084h.wv"));
/*    */     
/* 94 */     AuthResponse response = service.invoke(request);
/*    */     
/* 96 */     System.out.println("[FINISHED]" + response.getSuccess() + "-->  token?" + response.getAccessToken());
/* 97 */     System.out.println("[FINISHED]" + response.getMessage() + " --- " + response.getDetail());
/*    */   }
/*    */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\api\AuthService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */