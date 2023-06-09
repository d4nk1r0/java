package WEB-INF.classes.mira.microsoft.proxy.messages;

import mira.microsoft.proxy.messages.Headers;

public interface IProxyRequest {
  String getInterfaceId();
  
  void setInterfaceId(String paramString);
  
  void setHeaders(Headers paramHeaders);
  
  Headers getHeaders();
}


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\IProxyRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */