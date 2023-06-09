/*     */ package WEB-INF.classes.mira.microsoft.api.sharepoint.upload;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import javax.jws.WebMethod;
/*     */ import javax.jws.WebParam;
/*     */ import javax.jws.WebService;
/*     */ import mira.microsoft.api.AuthService;
/*     */ import mira.microsoft.client.RESTClientMultipartWrapper;
/*     */ import mira.microsoft.client.RESTClientWrapper;
/*     */ import mira.microsoft.client.RESTRequest;
/*     */ import mira.microsoft.client.RESTResponse;
/*     */ import mira.microsoft.proxy.APIException;
/*     */ import mira.microsoft.proxy.messages.AuthResponse;
/*     */ import mira.microsoft.proxy.messages.Header;
/*     */ import mira.microsoft.proxy.messages.MicrosoftAPIRequest;
/*     */ import mira.microsoft.proxy.messages.UploadDocumentRequest;
/*     */ import mira.microsoft.proxy.messages.UploadDocumentResponse;
/*     */ import mira.microsoft.util.LoggerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebService(serviceName = "UploadDocumentService")
/*     */ public class UploadDocumentService
/*     */ {
/*  26 */   private RESTClientWrapper wrapper = (RESTClientWrapper)new RESTClientMultipartWrapper();
/*  27 */   private AuthService authService = new AuthService();
/*     */ 
/*     */   
/*     */   @WebMethod
/*     */   public UploadDocumentResponse upload(@WebParam(name = "payload") UploadDocumentRequest uploadPayload) {
/*  32 */     UploadDocumentResponse response = new UploadDocumentResponse();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  39 */     LoggerUtil.debug("UploadDocumentService", "Autenticando!" + uploadPayload.getParams().size() + " params");
/*  40 */     MicrosoftAPIRequest autRequest = new MicrosoftAPIRequest();
/*     */     
/*  42 */     autRequest.setParams(uploadPayload.getParams());
/*     */     
/*  44 */     AuthResponse authResponse = this.authService.invoke(autRequest);
/*     */ 
/*     */     
/*  47 */     if (Boolean.TRUE.equals(authResponse.getSuccess())) {
/*  48 */       LoggerUtil.debug("UploadDocumentService", "Autenticado correctamente!");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  57 */       String url = uploadPayload.getServerURL() + "('" + uploadPayload.getServerRelativeUrl() + "')/Files/add(url='" + uploadPayload.getDocName() + "',overwrite=true)";
/*     */       
/*  59 */       RESTRequest proxyRequest = new RESTRequest(url);
/*  60 */       proxyRequest.setJson(false);
/*  61 */       proxyRequest.setBinary(true);
/*  62 */       proxyRequest.setBinaryContent(uploadPayload.getDocContent());
/*     */       
/*  64 */       proxyRequest.setMethod("POST");
/*     */ 
/*     */       
/*  67 */       String token = authResponse.getAccessToken();
/*     */       
/*  69 */       proxyRequest.setToken(token);
/*     */       
/*  71 */       proxyRequest.getHeaders()
/*  72 */         .getHeaders()
/*  73 */         .add(new Header("Authorization", "Bearer " + token));
/*     */       
/*  75 */       proxyRequest.getHeaders().getHeaders().add(new Header("Content-Type", "application/x-www-form-urlencoded"));
/*     */       
/*  77 */       LoggerUtil.debug("UploadDocumentService", "Iniciando carga de documento");
/*  78 */       RESTResponse restResponse = null;
/*     */       
/*     */       try {
/*  81 */         restResponse = this.wrapper.invoke(proxyRequest);
/*     */         
/*  83 */         response.setSuccess(restResponse.getSuccess());
/*     */         
/*  85 */         if (restResponse.getExtended() != null) {
/*  86 */           Iterator<String> itKeys = restResponse.getExtended().keySet().iterator();
/*     */           
/*  88 */           while (itKeys.hasNext()) {
/*  89 */             String iKey = itKeys.next();
/*  90 */             response.addInfo(iKey, (String)restResponse.getExtended().get(iKey));
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  96 */         if (Boolean.TRUE.equals(restResponse.getSuccess())) {
/*  97 */           LoggerUtil.debug("UploadDocumentService:Sharepoint", "Documento '" + uploadPayload.getDocName() + "' cargado correctamente en Sharepoint");
/*  98 */           response.setMessage("Documento '" + uploadPayload.getDocName() + "' cargado correctamente en Sharepoint");
/*     */         } else {
/* 100 */           LoggerUtil.debug("UploadDocumentService:Sharepoint", "Documento '" + uploadPayload.getDocName() + "' NO cargado correctamente en Sharepoint");
/* 101 */           response.setMessage("Documento '" + uploadPayload.getDocName() + "' NO cargado correctamente en Sharepoint");
/*     */         }
/*     */       
/* 104 */       } catch (APIException e) {
/* 105 */         LoggerUtil.error("UploadDocumentService:Sharepoint", "No es posible hacer carga de documento", (Throwable)e);
/*     */         
/* 107 */         response.setMessage(restResponse.getMessage());
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 116 */       LoggerUtil.debug("UploadDocumentService", "No fue posible completar autenticación (" + authResponse
/* 117 */           .getMessage() + ")");
/* 118 */       response.setMessage("No fue posible completar autenticación (" + authResponse.getMessage() + ")");
/* 119 */       response.setDetail(authResponse.getDetail());
/*     */     } 
/*     */     
/* 122 */     return response;
/*     */   }
/*     */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\api\sharepoin\\upload\UploadDocumentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */