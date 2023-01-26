

package io.cypress.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class UserProperties {
    private static final UserConfig CONFIG = ConfigFactory.create(UserConfig.class, System.getProperties());

    public static final String
            USERNAME = CONFIG.userName(),
            PASSWORD = CONFIG.password(),
            EMAIL = CONFIG.email(),
            STAND = CONFIG.stand(),
            SELENOIDUSER = CONFIG.selenoidUser(),
            SELENOIDKEY = CONFIG.selenoidKey(),
            COMPANYNAME = CONFIG.companyName();

    @Config.Sources({ "classpath:config/user.properties","system:properties"})
    private interface UserConfig extends Config {

        @Key("userName")
        String userName();
        @Key("password")
        String password();
        @Key("email")
        String email();
        @Key("companyName")
        String companyName();
        @Key("stand")
        String stand();
        @Key("selenoidUser")
        String selenoidUser();
        @Key("selenoidKey")
        String selenoidKey();

    }
}

