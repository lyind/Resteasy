package org.jboss.resteasy.client.jaxrs.internal.proxy.processors.webtarget;

import org.jboss.resteasy.client.jaxrs.internal.proxy.processors.WebTargetProcessor;

import javax.ws.rs.client.WebTarget;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class PathParamProcessor implements WebTargetProcessor
{
   private final String paramName;
   private final boolean isEncoded;

   public PathParamProcessor(String paramName)
   {
      this.paramName = paramName;
      this.isEncoded = true;
   }

   public PathParamProcessor(String paramName, boolean isEncoded)
   {
      this.paramName = paramName;
      this.isEncoded = isEncoded;
   }

   @Override
   public WebTarget build(WebTarget target, Object param)
   {
      return isEncoded
         ? target.resolveTemplateFromEncoded(paramName, param)
         : target.resolveTemplate(paramName, param, false);
   }
}
