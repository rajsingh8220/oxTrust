/*
 * oxTrust is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2016, Gluu
 */
package org.gluu.oxtrust.action;

import java.io.Serializable;

import org.gluu.oxtrust.ldap.service.Shibboleth3ConfService;
import org.gluu.oxtrust.util.ProductInstallationChecker;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.log.Log;

/**
 * Action class for updating and adding the SAML IDP to Asimba.
 * 
 * @author Dmitry Ognyannikov
 */
@Scope(ScopeType.APPLICATION)
@Name("productInstallationCheckerAction")
@Restrict("#{identity.loggedIn}")
public class ProductInstallationCheckerAction implements Serializable {

    private static final long serialVersionUID = 1125167091541923404L;
    
    @Logger
    private Log log;
    
    private boolean showSAMLMenu = true;
    private boolean showAsimbaSubmenu = true;
    private boolean showSAMLSubmenu = true;
    // CAS protocol through Shibboleth IDP
    private boolean showIDP_CAS = true;
    
    public ProductInstallationCheckerAction() {
    }
    
    @Create
    public void init() {        
        log.info("init() ProductInstallationCheckerAction call");
        
        showSAMLMenu = !ProductInstallationChecker.isGluuCE() || ProductInstallationChecker.isOxAsimbaInstalled() || Shibboleth3ConfService.instance().isIdpInstalled();
        
        showAsimbaSubmenu = !ProductInstallationChecker.isGluuCE() || ProductInstallationChecker.isOxAsimbaInstalled();
        
        showSAMLSubmenu = !ProductInstallationChecker.isGluuCE() || Shibboleth3ConfService.instance().isIdpInstalled();
        
        showIDP_CAS = !ProductInstallationChecker.isGluuCE() || ProductInstallationChecker.isShibbolethIDP3Installed();
    }

    /**
     * @return the showSAMLMenu
     */
    public boolean isShowSAMLMenu() {
        return showSAMLMenu;
    }

    /**
     * @param showSAMLMenu the showSAMLMenu to set
     */
    public void setShowSAMLMenu(boolean showSAMLMenu) {
        this.showSAMLMenu = showSAMLMenu;
    }

    /**
     * @return the showAsimbaSubmenu
     */
    public boolean isShowAsimbaSubmenu() {
        return showAsimbaSubmenu;
    }

    /**
     * @param showAsimbaSubmenu the showAsimbaSubmenu to set
     */
    public void setShowAsimbaSubmenu(boolean showAsimbaSubmenu) {
        this.showAsimbaSubmenu = showAsimbaSubmenu;
    }

    /**
     * @return the showSAMLSubmenu
     */
    public boolean isShowSAMLSubmenu() {
        return showSAMLSubmenu;
    }

    /**
     * @param showSAMLSubmenu the showSAMLSubmenu to set
     */
    public void setShowSAMLSubmenu(boolean showSAMLSubmenu) {
        this.showSAMLSubmenu = showSAMLSubmenu;
    }

    /**
     * @return the showIDP_CAS
     */
    public boolean isShowIDP_CAS() {
        return showIDP_CAS;
    }

    /**
     * @param showIDP_CAS the showIDP_CAS to set
     */
    public void setShowIDP_CAS(boolean showIDP_CAS) {
        this.showIDP_CAS = showIDP_CAS;
    }
    
    
    
}
