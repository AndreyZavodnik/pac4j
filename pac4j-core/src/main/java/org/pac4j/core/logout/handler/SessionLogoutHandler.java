package org.pac4j.core.logout.handler;

import org.pac4j.core.context.CallContext;

import java.util.Optional;

/**
 * This interface defines how to handle logout requests on client side.
 * For the CAS support, the key is the service ticket.
 * For the SAML support, the key is the session index or the nameID.
 * For the OIDC support, the key is the ssid claim.
 *
 * @author Jerome Leleu
 * @since 1.9.2
 */
public interface SessionLogoutHandler {

    /**
     * Associates a key with the current web session.
     *
     * @param ctx the context
     * @param key the key
     */
    void recordSession(CallContext ctx, String key);

    /**
     * Destroys the current web session for the given key for a front or back channel logout.
     *
     * @param ctx the context
     * @param key the key
     */
    void destroySession(CallContext ctx, String key);

    /**
     * Renew the web session.
     *
     * @param ctx the context
     * @param oldSessionId the old session identifier
     */
    void renewSession(CallContext ctx, String oldSessionId);

    /**
     * Clean a recorded sessionId.
     *
     * @param sessionId the sessionId
     * @return the associated key.
     */
    Optional<String> cleanRecord(String sessionId);
}
