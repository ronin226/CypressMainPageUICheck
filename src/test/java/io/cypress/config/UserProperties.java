

package io.cypress.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class UserProperties {
    private static final UserConfig CONFIG = ConfigFactory.create(UserConfig.class, System.getProperties());

    public static final String
            USERNAME = CONFIG.username(),
            PASSWORD = CONFIG.password(),
            EMAIL = CONFIG.email(),
            BOTTOKEN = CONFIG.bottoken(),
            CHATID = CONFIG.chatid(),
            STAND = CONFIG.stand(),
            COMPANYNAME = CONFIG.companyname();

    @Config.Sources({"system:properties", "classpath:config/user.properties"})
    private interface UserConfig extends Config {

        @Key("username")
        String username();

        @Key("password")
        String password();

        @Key("email")
        String email();

        @Key("companyname")
        String companyname();

        @Key("bottoken")
        String bottoken();

        @Key("chatid")
        String chatid();
        @Key("stand")
        String stand();

    }
}

