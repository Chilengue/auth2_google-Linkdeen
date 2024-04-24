package devstac.com.auth2.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.endpoint.DefaultOAuth2AccessTokenResponseMapConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ch.qos.logback.core.pattern.Converter;

@Configuration
@EnableWebSecurity
public class SecurityCondig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(request ->
         request
         .requestMatchers("/login", "/resources/**", "/logout").permitAll()
            .anyRequest()
            .authenticated())
         .oauth2Login(oauth ->
                oauth.loginPage("/login")
                .tokenEndpoint(token ->{
                    var defafaultMapCoverter =new DefaultOAuth2AccessTokenResponseMapConverter();
        //                         Converter<Map<String, Object>, OAuth2AcessTokenResponse>  linkedinMapConverter= tokenResponde ->{
        //                             var withTokenType= new HasMap<>(tokenResponde)
        //                             withTokenType.put(OAuth2parameterNames.TOKEN_TYPE, oauth2.) 
        //                         }  }))
        // .logout(logout ->
        //    logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
        //             .logoutSuccessUrl("/login"));
         
         
        return http.build();
    }

}
