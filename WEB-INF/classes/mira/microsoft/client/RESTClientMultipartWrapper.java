/*     */ package WEB-INF.classes.mira.microsoft.client;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.xpath.XPath;
/*     */ import javax.xml.xpath.XPathConstants;
/*     */ import javax.xml.xpath.XPathExpression;
/*     */ import javax.xml.xpath.XPathFactory;
/*     */ import mira.microsoft.client.RESTClientWrapper;
/*     */ import mira.microsoft.client.RESTRequest;
/*     */ import mira.microsoft.client.RESTResponse;
/*     */ import mira.microsoft.proxy.APIException;
/*     */ import mira.microsoft.util.LoggerUtil;
/*     */ import okhttp3.Call;
/*     */ import okhttp3.OkHttpClient;
/*     */ import okhttp3.Request;
/*     */ import okhttp3.RequestBody;
/*     */ import okhttp3.Response;
/*     */ import okhttp3.ResponseBody;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RESTClientMultipartWrapper
/*     */   extends RESTClientWrapper
/*     */ {
/*  55 */   private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */   private static DocumentBuilder builder;
/*  57 */   private Document doc = null;
/*     */   private static XPathFactory xpathFactory;
/*     */   private static XPath xpath;
/*     */   
/*     */   static {
/*     */     try {
/*  63 */       builder = factory.newDocumentBuilder();
/*  64 */       xpathFactory = XPathFactory.newInstance();
/*  65 */       xpath = xpathFactory.newXPath();
/*  66 */     } catch (Exception e) {
/*  67 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESTResponse invoke(RESTRequest request) throws APIException {
/*  79 */     if (request.getBinaryContent() == null) {
/*  80 */       throw new APIException("Contenido de documento no enviado");
/*     */     }
/*     */     
/*  83 */     RESTResponse response = new RESTResponse();
/*     */     
/*  85 */     String tempURL = request.getTargetURL();
/*     */ 
/*     */     
/*  88 */     LoggerUtil.debug("RESTClientMultipartWrapper", "Preparando invocación API REST de MS <" + tempURL + ">");
/*     */     
/*  90 */     OkHttpClient client = (new OkHttpClient()).newBuilder().build();
/*     */ 
/*     */     
/*  93 */     RequestBody body = RequestBody.create(request.getBinaryContent());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     Request requestHTTP = (new Request.Builder()).url(tempURL).method("POST", body).addHeader("Content-Type", "application/x-www-form-urlencoded").addHeader("X-RequestDigest", "{form_digest_value}").addHeader("Authorization", "Bearer " + request.getToken()).build();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 107 */       Call call = client.newCall(requestHTTP);
/* 108 */       Response responseHTTP = call.execute();
/* 109 */       LoggerUtil.debug("RESTClientMultipartWrapper", "Invocación API UploadDoc <" + responseHTTP
/* 110 */           .code() + " - " + responseHTTP.message() + ">");
/*     */       
/* 112 */       LoggerUtil.debug("RESTClientMultipartWrapper", "Invocación API UploadDoc <" + responseHTTP
/* 113 */           .code() + " - " + responseHTTP.message() + ">");
/*     */       
/* 115 */       if (responseHTTP.code() == 200) {
/* 116 */         response.setSuccess(Boolean.TRUE);
/* 117 */         response.setMessage("Documento cargado correctamente");
/*     */         
/* 119 */         LoggerUtil.debug("RESTClientMultipartWrapper:message", responseHTTP.message());
/* 120 */         LoggerUtil.debug("RESTClientMultipartWrapper:toString", responseHTTP.toString());
/*     */ 
/*     */         
/*     */         try {
/* 124 */           ResponseBody in = responseHTTP.body();
/*     */           
/* 126 */           InputStream is = in.byteStream();
/* 127 */           InputStreamReader inputStreamReader = new InputStreamReader(is);
/* 128 */           BufferedReader buffReader = new BufferedReader(inputStreamReader);
/*     */           
/* 130 */           String lineStream = null;
/*     */           
/* 132 */           StringBuffer buffer = new StringBuffer();
/*     */           
/* 134 */           while ((lineStream = buffReader.readLine()) != null)
/*     */           {
/* 136 */             buffer.append(lineStream);
/*     */           }
/*     */ 
/*     */           
/* 140 */           response.setExtended(readXml(buffer.toString()));
/* 141 */           buffReader.close();
/*     */         
/*     */         }
/* 144 */         catch (Exception e) {
/* 145 */           e.printStackTrace();
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 150 */         response.setCode(Integer.valueOf(responseHTTP.code()));
/* 151 */         response.setSuccess(Boolean.FALSE);
/* 152 */         response.setMessage("Documento no cargado correctamente (" + responseHTTP.message() + "). Detalles: " + responseHTTP
/* 153 */             .body().string());
/*     */       } 
/*     */ 
/*     */       
/* 157 */       responseHTTP.close();
/* 158 */     } catch (Exception e) {
/* 159 */       response.setMessage("No es posible cargar documento en Shjarepoint (" + e.getMessage() + ")");
/* 160 */       LoggerUtil.error("RESTClientMultipartWrapper", "No es posible enviar documento", e);
/*     */     } 
/*     */ 
/*     */     
/* 164 */     return response;
/*     */   }
/*     */ 
/*     */   
/*     */   private HashMap<String, String> readXml(String data) {
/* 169 */     HashMap<String, String> dataMap = new HashMap<>();
/*     */ 
/*     */     
/* 172 */     if (data != null) {
/* 173 */       InputStream inputStream = new ByteArrayInputStream(data.getBytes(Charset.forName("UTF-8")));
/*     */       try {
/* 175 */         this.doc = builder.parse(inputStream);
/* 176 */         XPathExpression expr = xpath.compile("//content/properties/*");
/*     */         
/* 178 */         NodeList propsNode = (NodeList)expr.evaluate(this.doc, XPathConstants.NODESET);
/* 179 */         LoggerUtil.debug("RESTClientMultipartWrapper:PropResponse", propsNode
/* 180 */             .toString() + "---> " + propsNode.getLength());
/*     */         
/* 182 */         Node iNode = null;
/* 183 */         for (int i = 0; i < propsNode.getLength(); i++) {
/* 184 */           iNode = propsNode.item(i);
/* 185 */           LoggerUtil.debug("RESTClientMultipartWrapper:" + iNode.getNodeName(), "---> " + iNode
/* 186 */               .getTextContent());
/*     */           
/* 188 */           dataMap.put(iNode.getNodeName().replaceAll("d:", ""), iNode.getTextContent());
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 197 */       catch (Exception e) {
/* 198 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 204 */     return dataMap;
/*     */   }
/*     */ }


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\client\RESTClientMultipartWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */