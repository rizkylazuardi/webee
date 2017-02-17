/**
 * 
 */
package com.anabatic.webee;

/**
 * Constant values used throughout the application.
 * @author <a href="mailto:if08007@gmail.com">Arni Sihombing</a>
 * implemented by : ahlul.esasjana
 */
public class Constants {
	private Constants() {
    }
    /**
     * The name of the ResourceBundle used in this application
     */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /**
     * File separator from System properties
     */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /**
     * User home from System properties
     */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";

    /**
     * Session scope attribute that holds the locale set by the user. By setting this key
     * to the same one that Struts uses, we get synchronization in Struts w/o having
     * to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "preferredLocale";

    /**
     * The request scope attribute under which an editable user form is stored
     */
    public static final String USER_KEY = "userForm";

    /**
     * The request scope attribute that holds the user list
     */
    public static final String USER_LIST = "userList";

    /**
     * The request scope attribute for indicating a newly-registered user
     */
    public static final String REGISTERED = "registered";

    /**
     * The name of the Administrator role, as specified in web.xml
     */
    public static final String ADMIN_ROLE = "ROLE_HO_ADMINISTRATOR";

    /**
     * The name of the User role, as specified in web.xml
     */
    public static final String USER_ROLE = "ROLE_HO_USER";

    /**
     * The name of the user's role list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String USER_ROLES = "userRoles";

    /**
     * The name of the available roles list, a request-scoped attribute
     * when adding/editing a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles";


    /**
     * The request scope attribute that holds the user list
     */
    public static final String LENDING_PRODUCTS = "lendingProducts";

    public static final String MODEL_PACKAGE = "com.anabatic.corebanking.persistence.model";

    public static final String SERVICE_PACKAGE = "com.anabatic.corebanking.service";


    public static final Integer PAGING_MAX_RECORD = 20;

    public static final String BREADCRUMBS = "CB_BREADCRUMBS";

    public static final String SYSTEM = "SYSTEM";

    public static final String CORE_USER = "coreUser";
    
    //Attribute used in session to indicate online mode
    public static final String ONLINE_MODE = "onlineMode";
    
    public static final String NEW_RECORD = "NEW RECORD";
    
    public static final String MODIFY_RECORD  = "MODIFY RECORD";
    
    public static final String DELETE_RECORD = "DELETE RECORD";

    public static final String AUTHORIZE_RECORD = "AUTHORIZE RECORD";
    
    public static final String USER_MENU = "USER MENU";
    
    public static final Integer LOGIN_MAX_ATTEMPTS = 3;
    
    public static final Integer MPIN_MAX_ATTEMPTS = 3;
    
    public static final Integer ACCOUNT_LENGTH = 12;
    
    public static final String MPIN_BTPNS_SEPARATOR = "%";
    
    public static final Long SYSTEM_TRACE_NUMBER_MAX = 999999L;
    
    public static final Integer SYSTEM_TRACE_NUMBER_MAXLENGTH = 6;
    
    public static final Long RETRIEVAL_REFERENCE_NUMBER_MAX = 999999999999L;
    
    public static final Integer RETRIEVAL_REFERENCE_NUMBER_MAXLENGTH = 12;
    
    public static final Long CARD_ACCEPTOR_TERMINAL_IDENTIFICATION_MAX = 99999999L;
    
    public static final Integer CARD_ACCEPTOR_TERMINAL_IDENTIFICATION_MAXLENGTH = 8;
    
    public static final Long SEND_SMS_ID_MAX = 99999999L;
    
    public static final Integer SEND_SMS_ID_MAXLENGTH = 8;
    
    public static final String SEARCH_RECORD = "ENQUIRY";
    
    public static final String COB_INSTANCE = "COB_INSTANCE";
    
    public static final String ACTIVATION_CODE_REGEX = "<code>";
}
