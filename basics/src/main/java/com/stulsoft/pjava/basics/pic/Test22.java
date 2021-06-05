/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.pic;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;
import java.util.Properties;

/**
 * @author Yuriy Stul
 */
public class Test22{

    private static final String[] attrIds = {"distinguishedName", "sn", "givenname", "mail", "sAMAccountName", "memberOf", "userPassword", "Picture", "thumbnailPhoto"};
    private String searchBase;
    private String ldapUrl;
    private String ldapSystemUsername;
    private String ldapSystemUserPassword;

    private void handle() {
        var username ="uuu";
        var password = "ppp";
        String searchFilter = "sAMAccountName=" + username;
        SearchControls searchControls = new SearchControls();
        searchControls.setReturningAttributes(attrIds);

        // Specify the search scope
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        DirContext ctx;
        try {
            // Init JNDI
            Hashtable<String, Object> env = new Hashtable<>(11);
            env.put(javax.naming.Context.PROVIDER_URL, ldapUrl);
            env.put(javax.naming.Context.SECURITY_PRINCIPAL, ldapSystemUsername);
            env.put(javax.naming.Context.SECURITY_CREDENTIALS, ldapSystemUserPassword);
            env.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            ctx = new InitialDirContext(env);
            NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, searchControls);
            if (answer.hasMoreElements()) {
                var result = answer.next();
                var distinguishedName = result.getNameInNamespace();

                // attempt another authentication, now with the user
                Properties authEnv = new Properties();
                authEnv.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
                authEnv.put(javax.naming.Context.PROVIDER_URL, ldapUrl);
                authEnv.put(javax.naming.Context.SECURITY_PRINCIPAL, distinguishedName);
                authEnv.put(javax.naming.Context.SECURITY_CREDENTIALS, password);

                DirContext dctx = new InitialDirContext(authEnv);

                var answer2 = dctx.search(searchBase, searchFilter, searchControls);
                if (answer2.hasMoreElements()) {
                    var result2 = answer2.next();
                    var attributes = result2.getAttributes();
                    var givenName = attributes.get("givenName").get();
                    var surname = attributes.get("sn").get();
                    var mail = attributes.get("mail").get();

                    var thumbnailPhoto = result2.getAttributes().get("thumbnailPhoto");

/*
                    var response = new JsonObject();
                    if (thumbnailPhoto != null)
                        response.put("thumbnail", thumbnailPhoto.get());
                    vertx.eventBus().<JsonObject>request(PermissionProviderVerticle.EB_ADDRESS,
                            username,
                            permissionResult -> {
                                if (permissionResult.succeeded()) {
                                    var properties = new JsonObject()
                                            .put("name", givenName)
                                            .put("surname", surname)
                                            .put("mail", mail)
                                            .put("roles",
                                                    permissionResult.result().body().getJsonArray("roles"))
                                            .put("permissions",
                                                    permissionResult.result().body().getJsonArray("permissions"));

                                    var user = new JsonObject()
                                            .put("username", username)
                                            .put("password", "")
                                            .put("token", UUID.randomUUID().toString())
                                            .put("properties", properties);
                                    var objectToCreateToken = new JsonObject().put("user", user);
                                    var token = jwtProvider.generateToken(objectToCreateToken, jwtOptions);
                                    response.put("token", token);
                                    message.reply(response);
                                } else {
                                    logger.error(permissionResult.cause().getMessage());
                                    message.fail(401, "permissions were not found");
                                }
                            });
*/
                } else {
//                    message.fail(401, "user was not found");
                }
                dctx.close();
            } else {
//                message.fail(500, "LDAP is unavailable");
            }
            ctx.close();
        } catch (NamingException exception) {
        }
    }
}

