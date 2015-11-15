package com.adobe.acs.commons.httpcache.rule.impl;

import com.adobe.acs.commons.httpcache.rule.AbstractHttpCacheHandlingRule;
import org.apache.felix.scr.annotations.Component;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

/**
 * Cache only Http response status for the request is 200.
 */
@Component(label = "ACS AEM Commons - HTTP Cache - Rule: Cache only response status 200.",
           description = "Cache only Http response status for the request is 200.",
           immediate = true)
public class CacheOnlyResponse200 extends AbstractHttpCacheHandlingRule {
    private static final int HTTP_SUCCESS_RESPONSE_STATUS = 200;

    @Override
    public boolean onResponseCache(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        // Continue only if the response status is 200.
        if (HTTP_SUCCESS_RESPONSE_STATUS != response.getStatus())
            return false;
        return true;
    }
}
