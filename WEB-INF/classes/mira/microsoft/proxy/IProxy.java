package WEB-INF.classes.mira.microsoft.proxy;

import mira.microsoft.proxy.APIException;
import mira.microsoft.proxy.messages.IProxyResponse;
import mira.microsoft.proxy.messages.MicrosoftAPIRequest;

public interface IProxy {
  IProxyResponse execute(MicrosoftAPIRequest paramMicrosoftAPIRequest) throws APIException;
}


/* Location:              C:\Users\dquiroz\Desktop\MicrosoftAPIProxy.war!\WEB-INF\classes\mira\microsoft\proxy\IProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */