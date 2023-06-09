/*     */ package WEB-INF.classes.mira.microsoft.client;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.SocketException;
/*     */ import java.net.SocketTimeoutException;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mira.microsoft.client.RESTRequest;
/*     */ import mira.microsoft.client.RESTResponse;
/*     */ import mira.microsoft.proxy.APIException;
/*     */ import mira.microsoft.proxy.messages.Header;
/*     */ import mira.microsoft.proxy.messages.ParamRequest;
/*     */ import mira.microsoft.util.LoggerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RESTClientWrapper
/*     */ {
/*  41 */   URL url = null;
/*  42 */   HttpURLConnection httpURLConnection = null;
/*  43 */   OutputStreamWriter outputStreamWriter = null;
/*     */   DataOutputStream dataWriter;
/*  45 */   String responseMessageFromServer = null;
/*  46 */   String responseXML = null;
/*     */   boolean sendBodyData = true;
/*     */   
/*     */   public RESTResponse invoke(RESTRequest request) throws APIException {
/*  50 */     RESTResponse response = new RESTResponse();
/*     */     
/*  52 */     LoggerUtil.debug("RESTClientWrapper", "Preparando invocación API REST de MS <" + request.getTargetURL() + ">");
/*     */     
/*     */     try {
/*  55 */       int binaryLength = 0;
/*     */       
/*  57 */       this.url = new URL(request.getTargetURL());
/*     */ 
/*     */       
/*  60 */       this.httpURLConnection = (HttpURLConnection)this.url.openConnection();
/*     */       
/*  62 */       this.httpURLConnection.setDoOutput(true);
/*  63 */       this.httpURLConnection.setRequestMethod(request.getMethod());
/*     */ 
/*     */ 
/*     */       
/*  67 */       StringBuilder postData = new StringBuilder();
/*     */       
/*     */       try {
/*  70 */         for (ParamRequest param : request.getParams())
/*     */         {
/*  72 */           if (postData.length() != 0) {
/*  73 */             postData.append('&');
/*     */           }
/*  75 */           postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
/*     */           
/*  77 */           postData.append('=');
/*  78 */           postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
/*     */         }
/*     */       
/*     */       }
/*  82 */       catch (UnsupportedEncodingException e) {
/*  83 */         throw new APIException("Codificación no soportada");
/*     */       } 
/*  85 */       LoggerUtil.debug("RESTClientWrapper:URLParamsEncoded=", postData.toString());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       this.httpURLConnection.setRequestProperty("User-Agent", "MIRAProxy");
/*  91 */       this.httpURLConnection.setRequestProperty("Accept", "*/*");
/*  92 */       this.httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
/*  93 */       this.httpURLConnection.setRequestProperty("Connection", "keep-alive");
/*     */       
/*  95 */       if (!request.isBinary()) {
/*  96 */         if (!this.sendBodyData) {
/*  97 */           this.httpURLConnection.setRequestProperty("Content-Length", Integer.toString((postData.toString()
/*  98 */                 .getBytes()).length));
/*     */         } else {
/*     */           
/* 101 */           this.httpURLConnection.setRequestProperty("Content-Length", Integer.toString((request.getData()
/* 102 */                 .getBytes()).length));
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 107 */       else if (request.getBinaryContent() != null) {
/*     */         
/* 109 */         binaryLength = (request.getBinaryContent()).length;
/* 110 */         this.httpURLConnection.setRequestProperty("Content-Length", 
/* 111 */             Integer.toString(binaryLength));
/*     */       } else {
/* 113 */         throw new APIException("Contenido de documento a cargar es nulo");
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 118 */       for (Header header : request.getHeaders().getHeaders()) {
/* 119 */         LoggerUtil.debug("RESTClientWrapper:Header Original", header.getKey() + "-->" + header.getValue());
/* 120 */         this.httpURLConnection.setRequestProperty(header.getKey(), header.getValue());
/*     */         
/* 122 */         if ("Content-Type".equals(header.getKey()) && "application/x-www-form-urlencoded"
/* 123 */           .equals(header.getValue())) {
/* 124 */           this.sendBodyData = false;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 131 */       this.httpURLConnection.setUseCaches(false);
/* 132 */       this.httpURLConnection.setDoInput(true);
/* 133 */       this.httpURLConnection.setDoOutput(true);
/*     */ 
/*     */       
/* 136 */       this.dataWriter = new DataOutputStream(this.httpURLConnection.getOutputStream());
/*     */ 
/*     */       
/* 139 */       if (!request.isBinary()) {
/* 140 */         String data = request.getData();
/* 141 */         if (!this.sendBodyData) {
/* 142 */           data = postData.toString();
/*     */         }
/* 144 */         LoggerUtil.debug("RESTClientWrapper<DATA:sendBodyData?" + this.sendBodyData + ">", data);
/* 145 */         this.dataWriter.writeBytes(data);
/*     */       }
/*     */       else {
/*     */         
/* 149 */         LoggerUtil.debug("RESTClientWrapper", "Enviando Contenido Binario -->" + binaryLength + " bytes");
/* 150 */         this.dataWriter.write(request.getBinaryContent());
/*     */       } 
/*     */ 
/*     */       
/* 154 */       this.dataWriter.flush();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 159 */       Integer code = Integer.valueOf(this.httpURLConnection.getResponseCode());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       if (code.intValue() == 200 || code.intValue() == 201) {
/*     */         
/* 166 */         response = new RESTResponse(Integer.valueOf(this.httpURLConnection.getResponseCode()), this.httpURLConnection.getResponseMessage());
/*     */         
/* 168 */         response.setData(readServiceResponse(this.httpURLConnection.getInputStream()));
/*     */ 
/*     */         
/* 171 */         LoggerUtil.debug("RESTClientWrapper:HTTP OK", "PETICIÓN REST PROCESADA CORRECTAMENTE::RAW:" + this.httpURLConnection.getContent());
/* 172 */         LoggerUtil.debug("RESTClientWrapper:HTTP OK", "RESTResponse: " + response);
/*     */ 
/*     */         
/* 175 */         response.setSuccess(Boolean.TRUE);
/*     */       } else {
/*     */         
/* 178 */         response.setSuccess(Boolean.FALSE);
/*     */         
/* 180 */         LoggerUtil.debug("RESTClientWrapper:ErrorStream", code + " - " + response.getMessage());
/* 181 */         response.setCode(code);
/* 182 */         response.setMessage(this.httpURLConnection.getResponseMessage());
/*     */         
/* 184 */         String responseData = "{ \"error_stream\": ";
/* 185 */         String tempData = null;
/* 186 */         InputStream stream = this.httpURLConnection.getErrorStream();
/* 187 */         if (stream != null) {
/* 188 */           tempData = readServiceResponse(stream);
/*     */         }
/* 190 */         LoggerUtil.debug("RESTClientWrapper:ErrorStream", tempData);
/*     */         
/* 192 */         responseData = responseData + "\"" + tempData + "\"";
/* 193 */         responseData = responseData + ", \"info_stream\": ";
/*     */         
/* 195 */         stream = this.httpURLConnection.getInputStream();
/* 196 */         if (stream != null) {
/* 197 */           tempData = readServiceResponse(stream);
/*     */         }
/* 199 */         LoggerUtil.debug("RESTClientWrapper:InputStream", tempData);
/*     */         
/* 201 */         responseData = responseData + "\"" + tempData + "\"";
/* 202 */         responseData = responseData + "}";
/*     */         
/* 204 */         response.setData(responseData);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 209 */       if (this.dataWriter != null) {
/* 210 */         this.dataWriter.close();
/*     */       }
/* 212 */       if (this.httpURLConnection != null) {
/* 213 */         this.httpURLConnection.disconnect();
/*     */       }
/*     */     }
/* 216 */     catch (MalformedURLException e) {
/*     */       
/* 218 */       LoggerUtil.error("URL de API objetivo inválida", e);
/* 219 */       throw new APIException("URL de API objetivo inválida", e);
/*     */     }
/* 221 */     catch (IOException e) {
/* 222 */       LoggerUtil.error("No es posible crear conexión a API objetivo", e);
/*     */       
/* 224 */       throw new APIException("No es posible crear conexión a API objetivo", e);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 229 */     return response;
/*     */   }
/*     */ 
/*     */   
/*     */   private void printHTTPHeaders() {
/* 234 */     Map<String, List<String>> iHeadMap = this.httpURLConnection.getHeaderFields();
/* 235 */     Iterator<String> itHead = iHeadMap.entrySet().iterator();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     while (itHead.hasNext()) {
/* 241 */       String headK = itHead.next();
/* 242 */       List<String> headVS = iHeadMap.get(headK);
/* 243 */       LoggerUtil.debug("RESTClientWrapper:Headers", headK + "--> #" + ((headVS != null) ? headVS.size() : 0) + " valores");
/*     */       
/* 245 */       for (String headValue : headVS) {
/* 246 */         LoggerUtil.debug("RESTClientWrapper:<" + headVS + ">", "--> " + headValue);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String readServiceResponse(InputStream inputStream) throws APIException {
/* 255 */     StringBuffer stringBuffer = new StringBuffer();
/* 256 */     BufferedReader bufferedReader = null;
/* 257 */     InputStreamReader inputStreamReader = null;
/* 258 */     String readSingleLine = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 267 */       inputStreamReader = new InputStreamReader(inputStream);
/* 268 */       bufferedReader = new BufferedReader(inputStreamReader);
/*     */ 
/*     */       
/* 271 */       while ((readSingleLine = bufferedReader.readLine()) != null) {
/* 272 */         stringBuffer.append(readSingleLine + "\n");
/*     */       }
/* 274 */     } catch (SocketException e) {
/* 275 */       LoggerUtil.error("RESTClientWrapper", "Error leyendo socket de respuesta", e);
/* 276 */       throw new APIException("Error leyendo socket de respuesta", e);
/* 277 */     } catch (SocketTimeoutException e) {
/* 278 */       LoggerUtil.error("RESTClientWrapper", "Timeout leyendo socket de respuesta", e);
/* 279 */       throw new APIException("Timeout leyendo socket de respuesta", e);
/* 280 */     } catch (Exception e) {
/* 281 */       LoggerUtil.error("RESTClientWrapper", "Error leyendo respuesta de API REST", e);
/* 282 */       throw new APIException("Timeout leyendo socket de respuesta", e);
/*     */     } finally {
/* 284 */       if (bufferedReader != null) {
/*     */         try {
/* 286 */           bufferedReader.close();
/* 287 */         } catch (Exception exception) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 293 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\client\RESTClientWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */