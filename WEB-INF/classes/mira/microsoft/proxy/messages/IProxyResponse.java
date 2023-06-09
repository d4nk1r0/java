package WEB-INF.classes.mira.microsoft.proxy.messages;

public interface IProxyResponse {
  void setSuccess(Boolean paramBoolean);
  
  Boolean getSuccess();
  
  void setMessage(String paramString);
  
  String getMessage();
  
  void setDetail(String paramString);
  
  String getDetail();
}


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\messages\IProxyResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */