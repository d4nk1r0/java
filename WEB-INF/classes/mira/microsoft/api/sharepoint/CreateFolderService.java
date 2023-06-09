/*     */ package WEB-INF.classes.mira.microsoft.api.sharepoint;
/*     */ 
/*     */ import javax.jws.WebMethod;
/*     */ import javax.jws.WebParam;
/*     */ import javax.jws.WebService;
/*     */ import mira.microsoft.client.RESTClientWrapper;
/*     */ import mira.microsoft.client.RESTRequest;
/*     */ import mira.microsoft.client.RESTResponse;
/*     */ import mira.microsoft.proxy.APIException;
/*     */ import mira.microsoft.proxy.SharepointProxy;
/*     */ import mira.microsoft.proxy.messages.Header;
/*     */ import mira.microsoft.proxy.messages.SharepointRequest;
/*     */ import mira.microsoft.proxy.messages.SharepointResponse;
/*     */ import mira.microsoft.util.LoggerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @WebService(serviceName = "CreateFolderService")
/*     */ public class CreateFolderService
/*     */ {
/*  26 */   private RESTClientWrapper wrapper = new RESTClientWrapper();
/*     */ 
/*     */   
/*     */   @WebMethod(operationName = "createFolder")
/*     */   public SharepointResponse invoke(@WebParam(name = "sharepointRequest") SharepointRequest payload) {
/*  31 */     SharepointResponse response = new SharepointResponse();
/*  32 */     LoggerUtil.debug("CreateFolderService", "Invocando servicio de CreateFolder:\n" + payload.toCreateFolderJSon());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     RESTRequest proxyRequest = new RESTRequest(SharepointProxy.getContentURLService());
/*  41 */     proxyRequest.setJson(true);
/*  42 */     proxyRequest.setParams(payload.getParams());
/*  43 */     proxyRequest.setMethod("POST");
/*     */     
/*  45 */     proxyRequest.getHeaders()
/*  46 */       .getHeaders()
/*  47 */       .add(new Header("Content-Type", "application/json;odata=verbose"));
/*  48 */     proxyRequest.getHeaders()
/*  49 */       .getHeaders()
/*  50 */       .add(new Header("Accept-Encoding", "gzip, deflate, br"));
/*     */     
/*  52 */     proxyRequest.getHeaders()
/*  53 */       .getHeaders()
/*  54 */       .add(new Header("Connection", "keep-alive"));
/*     */ 
/*     */     
/*  57 */     proxyRequest.getHeaders()
/*  58 */       .getHeaders()
/*  59 */       .add(new Header("Host", "ceterimx.sharepoint.com:80"));
/*     */     
/*  61 */     proxyRequest.getHeaders()
/*  62 */       .getHeaders()
/*  63 */       .add(new Header("Accept", "application/json;odata=verbose"));
/*     */     
/*  65 */     String token = payload.getToken();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     proxyRequest.getHeaders()
/*  73 */       .getHeaders()
/*  74 */       .add(new Header("Authorization", "Bearer " + token));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     proxyRequest.setData(payload.toCreateFolderJSon());
/*     */ 
/*     */     
/*     */     try {
/*  86 */       RESTResponse pxyResponse = this.wrapper.invoke(proxyRequest);
/*     */       
/*  88 */       LoggerUtil.debug("CreateFolderService", "RPTA servicio Sharepoint: " + pxyResponse);
/*     */ 
/*     */ 
/*     */       
/*  92 */       response = SharepointResponse.toJson(pxyResponse.getData());
/*  93 */       if (pxyResponse.getSuccess().booleanValue()) {
/*  94 */         response.setMessage("Operación realizada correctamente");
/*  95 */         response.setSuccess(Boolean.TRUE);
/*     */       } else {
/*     */         
/*  98 */         response.setMessage("Operación fallida. " + response.getMessage());
/*  99 */         response.setDetail(pxyResponse.getCode() + " - " + pxyResponse.getMessage() + ". " + response
/* 100 */             .getDetail());
/* 101 */         response.setSuccess(Boolean.FALSE);
/*     */       }
/*     */     
/*     */     }
/* 105 */     catch (APIException e) {
/* 106 */       LoggerUtil.error("CreateFolderService", "Error invocando servicio de Sharepoint", (Throwable)e);
/* 107 */       response.setSuccess(Boolean.FALSE);
/*     */     } 
/*     */ 
/*     */     
/* 111 */     return response;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 118 */     mira.microsoft.api.sharepoint.CreateFolderService service = new mira.microsoft.api.sharepoint.CreateFolderService();
/*     */     
/* 120 */     SharepointRequest request = new SharepointRequest();
/* 121 */     request.setDocument(false);
/* 122 */     request.setServerRelativeUrl("/Shared%20Documents/Prueba_1_21042020");
/* 123 */     request.setItemType("SP.Folder");
/* 124 */     request.setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IkN0VHVoTUptRDVNN0RMZHpEMnYyeDNRS1NSWSIsImtpZCI6IkN0VHVoTUptRDVNN0RMZHpEMnYyeDNRS1NSWSJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvY2V0ZXJpbXguc2hhcmVwb2ludC5jb21AN2Y2ZjQ5MzItOTM1OC00YjQ0LWFmMWQtNGZjZjg3NWRiNzMyIiwiaXNzIjoiMDAwMDAwMDEtMDAwMC0wMDAwLWMwMDAtMDAwMDAwMDAwMDAwQDdmNmY0OTMyLTkzNTgtNGI0NC1hZjFkLTRmY2Y4NzVkYjczMiIsImlhdCI6MTU4OTU3NjcxMCwibmJmIjoxNTg5NTc2NzEwLCJleHAiOjE1ODk2NjM0MTAsImlkZW50aXR5cHJvdmlkZXIiOiIwMDAwMDAwMS0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDBAN2Y2ZjQ5MzItOTM1OC00YjQ0LWFmMWQtNGZjZjg3NWRiNzMyIiwibmFtZWlkIjoiNmQ5M2UyYzctZTY5ZC00MjU3LTgwNWMtMDFhOWE5YmI4MWE1QDdmNmY0OTMyLTkzNTgtNGI0NC1hZjFkLTRmY2Y4NzVkYjczMiIsIm9pZCI6Ijk3NjVhZTUxLTJjNzItNDA1NC1hZmE4LTJlODEzOTEzYzgwNCIsInN1YiI6Ijk3NjVhZTUxLTJjNzItNDA1NC1hZmE4LTJlODEzOTEzYzgwNCIsInRydXN0ZWRmb3JkZWxlZ2F0aW9uIjoiZmFsc2UifQ.gRu9B-ywCiJRFu3zm2KzFsacn0lZ46tCJXccOdgoDZfWz_G60snxigQjZfCDUD4M-x3Y-v3YAiEhUrZfwIaYxar-sVvVak5p7UZVBGuDNVjui1A2ATG1YOiF3etiMQCt0t_Njh8SFBjbRj1_pn9pmyMTaj9AyjoNEqbAU5Grr_apHREcPqi-oeF0ILHCUvKGdvD_9oth4afGuvzt6HUbwU6eySv5D5bV_jG-Qx5PEK4Mhw2SZ1T6qTo6U1QxyZYwKNHSfcn9-cw4CKZCNQRAfDbnSVWnX29UAG48Mo-Nk6YFXC2oaN_xYC5RlKDW2QdbgsXtxg_Pfl48FGjy1u8bNg");
/*     */     
/* 126 */     SharepointResponse response = service.invoke(request);
/*     */     
/* 128 */     System.out.println("[FINISHED]" + response.getMessage() + " --- " + response.getDetail());
/*     */   }
/*     */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\api\sharepoint\CreateFolderService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */